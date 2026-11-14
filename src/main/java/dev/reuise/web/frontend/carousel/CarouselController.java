package dev.reuise.web.frontend.carousel;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import akasha.Element;
import akasha.Event;
import akasha.EventListener;
import akasha.HTMLElement;
import akasha.IntersectionObserver;
import akasha.KeyboardEvent;
import akasha.MediaQueryList;
import akasha.MouseEvent;
import akasha.MutationObserver;
import akasha.MutationObserverInit;
import akasha.MutationRecord;
import akasha.Node;
import akasha.PointerEvent;
import akasha.ResizeObserver;
import akasha.WindowGlobal;
import dev.reuise.core.carousel.CarouselPages;
import dev.reuise.web.frontend.WebFrontendComponent;
import jsinterop.base.Js;

/** Owns one carousel's navigation, measurements and resources; content nodes are never cloned. */
final class CarouselController {
    private final WebFrontendCarousel carousel;
    private final HTMLElement root;
    private final HTMLElement viewport;
    private final HTMLElement slider;
    private final HTMLElement indicators;
    private final HTMLElement previous;
    private final HTMLElement next;
    private final HTMLElement autoplay;
    private final HTMLElement announcement;
    private final List<HTMLElement> cards = new ArrayList<>();
    private final Map<HTMLElement, String> originalHidden = new LinkedHashMap<>();
    private final Map<HTMLElement, Boolean> originalInert = new LinkedHashMap<>();
    private final EventListener click = this::click;
    private final EventListener keydown = event -> keydown((KeyboardEvent) event);
    private final EventListener enter = event -> { hovering = true; scheduleAutoplay(); };
    private final EventListener leave = event -> { hovering = false; scheduleAutoplay(); };
    private final EventListener focus = this::focusIn;
    private final EventListener visibility = event -> scheduleAutoplay();
    private final EventListener motionChange = event -> { refresh(); scheduleAutoplay(); };
    private final EventListener pointerDown = event -> pointerDown((PointerEvent) event);
    private final EventListener pointerMove = event -> pointerMove((PointerEvent) event);
    private final EventListener pointerUp = event -> pointerUp((PointerEvent) event, false);
    private final EventListener pointerCancel = event -> pointerUp((PointerEvent) event, true);
    private final EventListener dragStart = this::dragStart;
    private IntersectionObserver intersection;
    private MutationObserver content;
    private MutationObserver removal;
    private ResizeObserver sizes;
    private MediaQueryList motion;
    private CarouselPages pages = new CarouselPages(new double[0], new double[0], 0, null, "start", false);
    private int frame = -1;
    private int timer = -1;
    private int active = -1;
    private int pointer = -1;
    private int clickReset = -1;
    private double dragX;
    private double dragY;
    private boolean dragged;
    private boolean suppressClick;
    private boolean refreshing;
    private boolean connected;
    private boolean inView;
    private boolean hovering;
    private boolean allowFocusedPlay;
    private boolean rtl;
    private boolean disposed;

    CarouselController(WebFrontendCarousel carousel) {
        this.carousel = carousel;
        root = carousel.getHtmlElement();
        viewport = element(carousel.getViewport());
        slider = element(carousel.getSlider());
        indicators = element(carousel.getIndicators());
        previous = element(carousel.getPreviousButton());
        next = element(carousel.getNextButton());
        autoplay = element(carousel.getAutoplayButton());
        announcement = element(carousel.getAnnouncement());
        root.addEventListener("click", click, true);
        root.addEventListener("keydown", keydown);
        root.addEventListener("pointerenter", enter);
        root.addEventListener("pointerleave", leave);
        root.addEventListener("focusin", focus);
        viewport.addEventListener("pointerdown", pointerDown);
        viewport.addEventListener("pointermove", pointerMove);
        viewport.addEventListener("pointerup", pointerUp);
        viewport.addEventListener("pointercancel", pointerCancel);
        viewport.addEventListener("lostpointercapture", pointerCancel);
        viewport.addEventListener("dragstart", dragStart);
        intersection = new IntersectionObserver((entries, observer) -> {
            if (disposed) return;
            for (int i = 0; i < entries.length; i++)
                inView = Js.asBoolean(Js.asPropertyMap(entries.getAt(i)).get("isIntersecting"));
            if (root.isConnected()) acquire();
            else release();
            scheduleRefresh();
        });
        intersection.observe(root);
        refresh();
    }

    private static HTMLElement element(Object component) {
        return ((WebFrontendComponent) component).getHtmlElement();
    }

    private void focusIn(Event event) {
        if (event.target() instanceof Node && autoplay.contains((Node) event.target())) {
            scheduleAutoplay();
            return;
        }
        allowFocusedPlay = false;
        carousel.pause();
        scheduleAutoplay();
    }

    private void dragStart(Event event) {
        if (carousel.isDraggable()) event.preventDefault();
    }

    private void acquire() {
        if (connected || disposed) return;
        connected = true;
        motion = WindowGlobal.matchMedia("(prefers-reduced-motion: reduce)");
        motion.addEventListener("change", motionChange);
        WindowGlobal.document().addEventListener("visibilitychange", visibility);
        WindowGlobal.document().addEventListener("pointerup", pointerUp);
        WindowGlobal.document().addEventListener("pointercancel", pointerCancel);
        sizes = new ResizeObserver((entries, observer) -> scheduleRefresh());
        sizes.observe(viewport);
        for (HTMLElement card : cards) sizes.observe(card);
        content = new MutationObserver((records, observer) -> {
            for (int i = 0; i < records.length; i++) {
                // GWT observer records can originate in a different realm from the host DOM.
                MutationRecord record = Js.uncheckedCast(records.getAt(i));
                if (record.target() == slider && "style".equals(record.attributeName())) continue;
                scheduleRefresh();
                break;
            }
        });
        MutationObserverInit init = MutationObserverInit.of();
        init.setChildList(true);
        init.setSubtree(true);
        init.setCharacterData(true);
        init.setAttributes(true);
        init.setAttributeFilter("style", "class", "data-autosize");
        content.observe(slider, init);
        MutationObserverInit config = MutationObserverInit.of();
        config.setAttributes(true);
        config.setAttributeFilter("data-activeindex", "data-groupsize", "data-align", "data-whitespace",
                "data-circular", "data-draggable", "data-autoplay", "data-autoplayinterval",
                "data-paused", "data-transitionmillis", "data-gap", "data-pagelabel",
                "data-playlabel", "data-pauselabel", "dir");
        content.observe(root, config);
        removal = new MutationObserver((records, observer) -> {
            if (!root.isConnected()) release();
            else {
                for (int i = 0; i < records.length; i++) {
                    MutationRecord record = Js.uncheckedCast(records.getAt(i));
                    if ("attributes".equals(record.type()) && record.target() instanceof Element
                            && ((Element) record.target()).contains(root)) {
                        scheduleRefresh();
                        break;
                    }
                }
            }
        });
        MutationObserverInit tree = MutationObserverInit.of();
        tree.setChildList(true);
        tree.setSubtree(true);
        tree.setAttributes(true);
        tree.setAttributeFilter("dir", "hidden", "class", "style");
        removal.observe(WindowGlobal.document(), tree);
    }

    private void scheduleRefresh() {
        if (disposed || frame != -1) return;
        frame = WindowGlobal.requestAnimationFrame(time -> {
            frame = -1;
            refresh();
        });
    }

    void refresh() {
        if (disposed || refreshing) return;
        refreshing = true;
        try {
            List<HTMLElement> found = new ArrayList<>();
            for (int i = 0; i < slider.children().length(); i++) {
                HTMLElement card = Js.uncheckedCast(slider.children().item(i));
                found.add(card);
                if (!originalHidden.containsKey(card)) {
                    originalHidden.put(card, card.getAttribute("aria-hidden"));
                    originalInert.put(card, card.hasAttribute("inert"));
                    if (sizes != null) sizes.observe(card);
                }
            }
            for (HTMLElement old : new ArrayList<>(originalHidden.keySet())) {
                if (!found.contains(old)) {
                    restoreCard(old);
                    if (sizes != null) sizes.unobserve(old);
                    originalHidden.remove(old);
                    originalInert.remove(old);
                }
            }
            cards.clear();
            cards.addAll(found);
            if (!root.isConnected() || viewport.clientWidth() == 0) {
                stopTimer();
                return;
            }
            rtl = "rtl".equals(WindowGlobal.getComputedStyle(root).getPropertyValue("direction"));
            double[] positions = new double[cards.size()];
            double[] widths = new double[cards.size()];
            var box = slider.getBoundingClientRect();
            double scale = slider.offsetWidth() == 0 ? 1 : box.width() / slider.offsetWidth();
            if (scale <= 0) return;
            for (int i = 0; i < cards.size(); i++) {
                var card = cards.get(i).getBoundingClientRect();
                positions[i] = (rtl ? box.right() - card.right() : card.left() - box.left()) / scale;
                widths[i] = card.width() / scale;
            }
            pages = new CarouselPages(positions, widths, viewport.clientWidth(), carousel.getGroupSize(),
                    carousel.getAlign(), carousel.isWhitespace());
            int index = Math.max(0, Math.min(Math.max(0, pages.size() - 1), carousel.getActiveIndex()));
            if (index != carousel.getActiveIndex()) carousel.setActiveIndex(index);
            boolean changed = active >= 0 && active != index;
            int duration = active < 0 || reducedMotion() ? 0 : carousel.getTransitionMillis();
            slider.style().setProperty("transition", "transform " + duration + "ms ease");
            slider.style().setProperty("transform", "translateX("
                    + (pages.size() == 0 ? 0 : (rtl ? 1 : -1) * pages.offset(index)) + "px)");
            viewport.style().setProperty("touch-action", carousel.isDraggable() ? "pan-y" : "auto");
            viewport.scrollLeft = 0;
            root.setAttribute("data-carousel-ready", "");
            active = index;
            synchronizeCards(positions, widths);
            synchronizeControls();
            if (changed) {
                if (carousel.isPaused() || !carousel.isAutoplay() || reducedMotion())
                    announcement.textContent = pageLabel(index);
                if (carousel.getOnActiveIndexChange() != null) carousel.getOnActiveIndexChange().accept(index);
            }
        } finally {
            refreshing = false;
        }
        scheduleAutoplay();
    }

    private void synchronizeCards(double[] positions, double[] widths) {
        double offset = pages.size() == 0 ? 0 : pages.offset(active);
        for (int i = 0; i < cards.size(); i++) {
            HTMLElement card = cards.get(i);
            boolean visible = positions[i] + widths[i] > offset + .5
                    && positions[i] < offset + viewport.clientWidth() - .5;
            if (visible) restoreCard(card);
            else {
                if (card.contains(WindowGlobal.document().activeElement())) viewport.focus();
                card.setAttribute("aria-hidden", "true");
                card.setAttribute("inert", "");
            }
        }
    }

    private void restoreCard(HTMLElement card) {
        String hidden = originalHidden.get(card);
        if (hidden == null) card.removeAttribute("aria-hidden");
        else card.setAttribute("aria-hidden", hidden);
        if (!Boolean.TRUE.equals(originalInert.get(card))) card.removeAttribute("inert");
    }

    private String pageLabel(int index) {
        return carousel.getPageLabel().replace("{index}", Integer.toString(index + 1))
                .replace("{count}", Integer.toString(pages.size()));
    }

    private void synchronizeControls() {
        boolean empty = pages.size() < 2;
        disabled(previous, empty || (!carousel.isCircular() && active == 0));
        disabled(next, empty || (!carousel.isCircular() && active == pages.size() - 1));
        if (indicators.childElementCount() != pages.size()) {
            boolean hadFocus = indicators.contains(WindowGlobal.document().activeElement());
            indicators.textContent = "";
            for (int i = 0; i < pages.size(); i++) {
                HTMLElement button = Js.uncheckedCast(WindowGlobal.document().createElement("button"));
                button.setAttribute("type", "button");
                button.setAttribute("class", "reuise-carousel_indicator");
                button.setAttribute("data-carousel-page", Integer.toString(i));
                indicators.appendChild(button);
            }
            if (hadFocus) {
                if (pages.size() > 0) ((HTMLElement) indicators.children().item(active)).focus();
                else viewport.focus();
            }
        }
        for (int i = 0; i < indicators.childElementCount(); i++) {
            Element button = indicators.children().item(i);
            button.setAttribute("aria-label", pageLabel(i));
            button.setAttribute("aria-controls", viewport.id);
            button.setAttribute("aria-current", Boolean.toString(i == active));
        }
        boolean running = carousel.isAutoplay() && !carousel.isPaused() && !reducedMotion();
        String label = running ? carousel.getPauseLabel() : carousel.getPlayLabel();
        if (!label.equals(carousel.getAutoplayButton().getLabel()))
            carousel.getAutoplayButton().setLabel(label);
        autoplay.setAttribute("aria-label", label);
        announcement.setAttribute("aria-live", running ? "off" : "polite");
    }

    private void disabled(Element element, boolean disabled) {
        if (disabled) element.setAttribute("disabled", "");
        else element.removeAttribute("disabled");
    }

    void move(int delta) {
        if (disposed || pages.size() == 0) return;
        int index = Math.max(0, active) + delta;
        if (carousel.isCircular()) index = (index % pages.size() + pages.size()) % pages.size();
        else index = Math.max(0, Math.min(pages.size() - 1, index));
        carousel.setActiveIndex(index);
    }

    private void click(Event event) {
        if (disposed || !(event.target() instanceof Element)) return;
        Element target = (Element) event.target();
        if (target.closest(".reuise-carousel") != root) return;
        if (suppressClick && viewport.contains(target) && event instanceof MouseEvent
                && ((MouseEvent) event).detail() > 0) {
            suppressClick = false;
            event.preventDefault();
            event.stopImmediatePropagation();
            return;
        }
        if (previous.contains(target)) carousel.previous();
        else if (next.contains(target)) carousel.next();
        else if (autoplay.contains(target)) {
            if (carousel.isPaused() || reducedMotion()) play();
            else { carousel.pause(); refresh(); }
        } else {
            Element button = target.closest("[data-carousel-page]");
            if (button != null && indicators.contains(button))
                carousel.setActiveIndex(Integer.parseInt(button.getAttribute("data-carousel-page")));
        }
    }

    private void keydown(KeyboardEvent event) {
        if (!(event.target() instanceof Element)) return;
        Element target = (Element) event.target();
        if (target.closest(".reuise-carousel") != root
                || (target != viewport && !indicators.contains(target))) return;
        String key = event.key();
        if ("ArrowRight".equals(key) || "ArrowLeft".equals(key)) {
            event.preventDefault();
            move(("ArrowRight".equals(key) != rtl) ? 1 : -1);
        } else if ("Home".equals(key) || "End".equals(key)) {
            event.preventDefault();
            carousel.setActiveIndex("Home".equals(key) ? 0 : Math.max(0, pages.size() - 1));
        } else return;
        if (indicators.contains(target) && indicators.children().item(active) instanceof HTMLElement)
            ((HTMLElement) indicators.children().item(active)).focus();
    }

    private void pointerDown(PointerEvent event) {
        if (!carousel.isDraggable() || event.button() != 0 || !event.isPrimary()
                || !(event.target() instanceof Element)) return;
        Element target = (Element) event.target();
        if (target.closest(".reuise-carousel") != root
                || target.closest("input,textarea,select,button,[contenteditable=\"true\"]") != null) return;
        pointer = event.pointerId();
        dragX = event.clientX();
        dragY = event.clientY();
        dragged = false;
        suppressClick = false;
        stopTimer();
    }

    private void pointerMove(PointerEvent event) {
        if (pointer != event.pointerId()) return;
        double dx = event.clientX() - dragX;
        double dy = event.clientY() - dragY;
        if (!dragged && Math.abs(dy) > Math.abs(dx) && Math.abs(dy) > 8) {
            pointer = -1;
            scheduleAutoplay();
            return;
        }
        if (Math.abs(dx) > 8) {
            dragged = true;
            viewport.setPointerCapture(pointer);
            event.preventDefault();
        }
    }

    private void pointerUp(PointerEvent event, boolean cancel) {
        if (pointer != event.pointerId()) return;
        double dx = event.clientX() - dragX;
        if (viewport.hasPointerCapture(pointer)) viewport.releasePointerCapture(pointer);
        pointer = -1;
        if (!cancel && dragged) {
            suppressClick = true;
            if (clickReset != -1) WindowGlobal.clearTimeout(clickReset);
            clickReset = WindowGlobal.setTimeout(() -> {
                suppressClick = false;
                clickReset = -1;
            }, 500);
            if (Math.abs(dx) >= 30) move((dx < 0 != rtl) ? 1 : -1);
        }
        dragged = false;
        scheduleAutoplay();
    }

    void play() {
        allowFocusedPlay = true;
        carousel.setAutoplay(true);
        carousel.setPaused(false);
        refresh();
    }

    private boolean reducedMotion() {
        return motion != null && motion.matches();
    }

    private void scheduleAutoplay() {
        stopTimer();
        if (disposed || !connected || !inView || hovering || pointer != -1 || pages.size() < 2
                || !carousel.isAutoplay() || carousel.isPaused() || reducedMotion()
                || WindowGlobal.document().hidden()
                || (!allowFocusedPlay && root.contains(WindowGlobal.document().activeElement()))
                || "hidden".equals(WindowGlobal.getComputedStyle(root).getPropertyValue("visibility"))
                || (!carousel.isCircular() && active == pages.size() - 1)) return;
        timer = WindowGlobal.setTimeout(() -> {
            timer = -1;
            move(1);
        }, carousel.getAutoplayInterval());
    }

    private void stopTimer() {
        if (timer != -1) WindowGlobal.clearTimeout(timer);
        timer = -1;
    }

    private void release() {
        connected = false;
        hovering = false;
        stopTimer();
        if (pointer != -1 && viewport.hasPointerCapture(pointer)) viewport.releasePointerCapture(pointer);
        pointer = -1;
        dragged = false;
        suppressClick = false;
        if (clickReset != -1) WindowGlobal.clearTimeout(clickReset);
        clickReset = -1;
        slider.style().removeProperty("transition");
        if (frame != -1) WindowGlobal.cancelAnimationFrame(frame);
        frame = -1;
        if (content != null) content.disconnect();
        content = null;
        if (removal != null) removal.disconnect();
        removal = null;
        if (sizes != null) sizes.disconnect();
        sizes = null;
        if (motion != null) motion.removeEventListener("change", motionChange);
        motion = null;
        WindowGlobal.document().removeEventListener("visibilitychange", visibility);
        WindowGlobal.document().removeEventListener("pointerup", pointerUp);
        WindowGlobal.document().removeEventListener("pointercancel", pointerCancel);
    }

    void dispose() {
        if (disposed) return;
        disposed = true;
        release();
        intersection.disconnect();
        root.removeEventListener("click", click, true);
        root.removeEventListener("keydown", keydown);
        root.removeEventListener("pointerenter", enter);
        root.removeEventListener("pointerleave", leave);
        root.removeEventListener("focusin", focus);
        viewport.removeEventListener("pointerdown", pointerDown);
        viewport.removeEventListener("pointermove", pointerMove);
        viewport.removeEventListener("pointerup", pointerUp);
        viewport.removeEventListener("pointercancel", pointerCancel);
        viewport.removeEventListener("lostpointercapture", pointerCancel);
        viewport.removeEventListener("dragstart", dragStart);
        slider.style().removeProperty("transform");
        slider.style().removeProperty("transition");
        viewport.style().removeProperty("touch-action");
        root.removeAttribute("data-carousel-ready");
        for (HTMLElement card : cards) restoreCard(card);
        cards.clear();
        originalHidden.clear();
        originalInert.clear();
    }
}

package dev.reuise.web.frontend.menu;

import akasha.CSSStyleDeclaration;
import akasha.DOMRect;
import akasha.Element;
import akasha.Event;
import akasha.EventListener;
import akasha.HTMLElement;
import akasha.Node;
import akasha.ResizeObserver;
import akasha.VisualViewport;
import akasha.WindowGlobal;

/** Positions in place; deliberately does not escape ancestor overflow or stacking contexts. */
final class MenuButtonPopupPosition {
    private static final String[] PROPERTIES = {
        "left", "right", "top", "bottom", "max-width", "max-height",
        "min-width", "min-height", "overflow-x", "overflow-y", "box-sizing"
    };
    private final HTMLElement root;
    private final HTMLElement trigger;
    private final HTMLElement popup;
    private final String[] values = new String[PROPERTIES.length];
    private final String[] priorities = new String[PROPERTIES.length];
    private final EventListener resize = event -> schedule();
    private final EventListener scroll = this::scroll;
    private ResizeObserver sizes;
    private VisualViewport viewport;
    private int frame = -1;
    private boolean active;

    MenuButtonPopupPosition(HTMLElement root, HTMLElement trigger, HTMLElement popup) {
        this.root = root;
        this.trigger = trigger;
        this.popup = popup;
    }

    void start() {
        if (active) return;
        active = true;
        CSSStyleDeclaration style = popup.style();
        for (int i = 0; i < PROPERTIES.length; i++) {
            values[i] = style.getPropertyValue(PROPERTIES[i]);
            priorities[i] = style.getPropertyPriority(PROPERTIES[i]);
        }
        WindowGlobal.addEventListener("resize", resize);
        WindowGlobal.addEventListener("scroll", scroll, true);
        viewport = WindowGlobal.visualViewport();
        if (viewport != null) {
            viewport.addEventListener("resize", resize);
            viewport.addEventListener("scroll", resize);
        }
        try {
            sizes = new ResizeObserver((entries, observer) -> schedule());
            sizes.observe(trigger);
            sizes.observe(popup);
        } catch (Throwable unavailable) {
            // Older browsers retain scroll/viewport positioning without size observation.
            if (sizes != null) sizes.disconnect();
            sizes = null;
        }
        position();
    }

    private void scroll(Event event) {
        // Scrolling the constrained popup should not reset its scroll position.
        if (event.target() instanceof Node && popup.contains((Node) event.target())) return;
        schedule();
    }

    void schedule() {
        if (!active || frame != -1) return;
        frame = WindowGlobal.requestAnimationFrame(timestamp -> {
            frame = -1;
            position();
        });
    }

    private void position() {
        if (!active || !root.isConnected() || popup.hasAttribute("hidden")) return;
        double scrollTop = popup.scrollTop;
        double scrollLeft = popup.scrollLeft;
        restore();
        double viewportLeft = viewport == null ? 0 : viewport.offsetLeft();
        double viewportTop = viewport == null ? 0 : viewport.offsetTop();
        double viewportWidth = viewport == null
                ? WindowGlobal.document().documentElement().clientWidth() : viewport.width();
        double viewportHeight = viewport == null
                ? WindowGlobal.document().documentElement().clientHeight() : viewport.height();
        double gutterX = Math.min(8, viewportWidth / 2);
        double gutterY = Math.min(8, viewportHeight / 2);
        double left = viewportLeft + gutterX;
        double right = viewportLeft + viewportWidth - gutterX;
        double top = viewportTop + gutterY;
        double bottom = viewportTop + viewportHeight - gutterY;

        double scaleX = 1;
        double scaleY = 1;
        Element parent = popup.offsetParent();
        if (parent instanceof HTMLElement) {
            HTMLElement containingBlock = (HTMLElement) parent;
            DOMRect bounds = containingBlock.getBoundingClientRect();
            CSSStyleDeclaration computed = WindowGlobal.getComputedStyle(parent);
            double width = borderBox(computed, "width", "left", "right");
            double height = borderBox(computed, "height", "top", "bottom");
            if (width > 0) scaleX = bounds.width() / width;
            if (height > 0) scaleY = bounds.height() / height;
        }
        if (scaleX <= 0 || scaleY <= 0) return;

        CSSStyleDeclaration style = popup.style();
        own("box-sizing", "border-box");
        own("min-width", "0");
        own("min-height", "0");
        own("left", "0");
        own("right", "auto");
        own("top", "0");
        own("bottom", "auto");
        // Preserve a caller's smaller max-width while allowing oversized content to scroll.
        double naturalWidth = popup.getBoundingClientRect().width();
        own("max-width", Math.max(0, Math.min(naturalWidth, right - left) / scaleX) + "px");
        own("overflow-x", "auto");
        DOMRect natural = popup.getBoundingClientRect();
        DOMRect anchor = trigger.getBoundingClientRect();
        double below = Math.max(0, Math.min(bottom - top, bottom - anchor.bottom()));
        double above = Math.max(0, Math.min(bottom - top, anchor.top() - top));
        boolean opensBelow = natural.height() <= below || below >= above;
        double available = opensBelow ? below : above;
        own("max-height", Math.max(0, Math.min(natural.height(), available) / scaleY) + "px");
        own("overflow-y", "auto");
        DOMRect measured = popup.getBoundingClientRect();
        double x = clamp(anchor.right() - measured.width(), left, right - measured.width());
        double y = clamp(opensBelow ? anchor.bottom() : anchor.top() - measured.height(),
                top, bottom - measured.height());
        // Starting at left/top=0 accounts for containing-block borders, scrolling and margins.
        style.setProperty("left", (x - measured.left()) / scaleX + "px", "important");
        style.setProperty("top", (y - measured.top()) / scaleY + "px", "important");
        popup.scrollTop = scrollTop;
        popup.scrollLeft = scrollLeft;
        Element focused = WindowGlobal.document().activeElement();
        if (focused != null && popup.contains(focused)) {
            DOMRect item = focused.getBoundingClientRect();
            DOMRect bounds = popup.getBoundingClientRect();
            double innerTop = bounds.top() + popup.clientTop() * scaleY;
            double innerBottom = innerTop + popup.clientHeight() * scaleY;
            if (item.top() < innerTop) popup.scrollTop -= (innerTop - item.top()) / scaleY;
            else if (item.bottom() > innerBottom) popup.scrollTop += (item.bottom() - innerBottom) / scaleY;
        }
    }

    private double clamp(double value, double minimum, double maximum) {
        return Math.max(minimum, Math.min(value, Math.max(minimum, maximum)));
    }

    private double borderBox(CSSStyleDeclaration computed, String dimension, String before, String after) {
        double size = pixels(computed, dimension);
        if (!"border-box".equals(computed.getPropertyValue("box-sizing"))) {
            size += pixels(computed, "padding-" + before) + pixels(computed, "padding-" + after)
                    + pixels(computed, "border-" + before + "-width") + pixels(computed, "border-" + after + "-width");
        }
        return size;
    }

    private double pixels(CSSStyleDeclaration computed, String property) {
        String value = computed.getPropertyValue(property);
        return value.endsWith("px") ? Double.parseDouble(value.substring(0, value.length() - 2)) : 0;
    }

    private void own(String property, String value) {
        popup.style().setProperty(property, value, "important");
    }

    private void restore() {
        for (int i = 0; i < PROPERTIES.length; i++) {
            if (values[i].isEmpty()) popup.style().removeProperty(PROPERTIES[i]);
            else popup.style().setProperty(PROPERTIES[i], values[i], priorities[i]);
        }
    }

    void stop() {
        if (!active) return;
        active = false;
        WindowGlobal.removeEventListener("resize", resize);
        WindowGlobal.removeEventListener("scroll", scroll, true);
        if (viewport != null) {
            viewport.removeEventListener("resize", resize);
            viewport.removeEventListener("scroll", resize);
            viewport = null;
        }
        if (sizes != null) {
            sizes.disconnect();
            sizes = null;
        }
        if (frame != -1) {
            WindowGlobal.cancelAnimationFrame(frame);
            frame = -1;
        }
        restore();
    }
}

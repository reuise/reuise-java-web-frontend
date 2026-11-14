package dev.reuise.web.frontend.text;

import akasha.Animation;
import akasha.Element;
import akasha.EventListener;
import akasha.HTMLElement;
import akasha.IntersectionObserver;
import akasha.MediaQueryList;
import akasha.MutationObserver;
import akasha.MutationObserverInit;
import akasha.Node;
import akasha.NodeList;
import akasha.WindowGlobal;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

/**
 * Owns the browser resources of one rotating text element. Until the element is connected only an
 * IntersectionObserver on the element itself exists, so never-attached components hold no
 * document-level listeners or observers. Detaching releases those resources; reattaching resumes.
 */
final class RotatingTextController {
    private final Element root;
    private final EventListener visibilityListener = event -> update();
    private final EventListener motionListener = event -> update();
    private MutationObserver mutations;
    private IntersectionObserver intersection;
    private MediaQueryList motion;
    private Animation outgoing;
    private Animation incoming;
    private int timer = -1;
    private int index;
    private int dwell = 3000;
    private int transition = 350;
    private boolean paused;
    private boolean visible;
    private boolean disposed;

    RotatingTextController(Element root) {
        this.root = root;
        JsPropertyMap<Object> window = Js.asPropertyMap(WindowGlobal.window());
        if (!"function".equals(Js.typeof(window.get("IntersectionObserver")))
                || !"function".equals(Js.typeof(window.get("MutationObserver")))
                || !"function".equals(Js.typeof(window.get("matchMedia")))) return;
        intersection = new IntersectionObserver((entries, observer) -> {
            if (disposed || observer != intersection) return;
            for (int i = 0; i < entries.length; i++) {
                Object value = Js.asPropertyMap(entries.getAt(i)).get("isIntersecting");
                visible = "boolean".equals(Js.typeof(value)) && Js.asBoolean(value);
            }
            if (root.isConnected()) acquire();
            else release();
            update();
        });
        intersection.observe(root);
    }

    void configure(Integer dwellMillis, Integer transitionMillis, boolean paused) {
        dwell = dwellMillis == null ? 3000 : Math.max(1, dwellMillis);
        transition = transitionMillis == null ? 350 : Math.max(0, transitionMillis);
        this.paused = paused;
        stopTimer();
        update();
    }

    void reset() {
        stopTimer();
        stopAnimations();
        index = 0;
        showOnly(0);
        update();
    }

    private void acquire() {
        if (motion != null || disposed) return;
        motion = WindowGlobal.matchMedia("(prefers-reduced-motion: reduce)");
        motion.addEventListener("change", motionListener);
        WindowGlobal.document().addEventListener("visibilitychange", visibilityListener);
        mutations = new MutationObserver((records, observer) -> {
            if (!root.isConnected()) {
                release();
                return;
            }
            for (int i = 0; i < records.length; i++) {
                Node target = Js.uncheckedCast(Js.asPropertyMap(records.getAt(i)).get("target"));
                if (target != null && target.contains(root)) {
                    update();
                    break;
                }
            }
        });
        MutationObserverInit init = MutationObserverInit.of();
        init.setChildList(true);
        init.setSubtree(true);
        init.setAttributes(true);
        init.setAttributeFilter("style", "class", "hidden");
        mutations.observe(WindowGlobal.document(), init);
    }

    private void release() {
        stopTimer();
        stopAnimations();
        showOnly(index);
        visible = false;
        if (mutations != null) mutations.disconnect();
        mutations = null;
        if (motion != null) {
            motion.removeEventListener("change", motionListener);
            WindowGlobal.document().removeEventListener("visibilitychange", visibilityListener);
            motion = null;
            if (!disposed && intersection != null) {
                // Restart observation so reattachment reports a fresh intersection state.
                intersection.unobserve(root);
                intersection.observe(root);
            }
        }
    }

    private void update() {
        if (disposed || motion == null) return;
        if (motion.matches()) {
            stopTimer();
            stopAnimations();
            index = 0;
            showOnly(0);
            return;
        }
        if (paused || !visible || WindowGlobal.document().hidden() || !root.isConnected()
                || "hidden".equals(WindowGlobal.getComputedStyle(root).getPropertyValue("visibility"))) {
            stopTimer();
            stopAnimations();
            showOnly(index);
            return;
        }
        if (timer == -1 && incoming == null && items().length() > 1)
            timer = WindowGlobal.setTimeout(this::advance, dwell);
    }

    private void advance() {
        timer = -1;
        NodeList items = items();
        if (items.length() < 2) return;
        int next = (index + 1) % items.length();
        HTMLElement oldItem = Js.uncheckedCast(items.item(index));
        HTMLElement newItem = Js.uncheckedCast(items.item(next));
        index = next;
        if (transition == 0 || !"function".equals(Js.typeof(Js.asPropertyMap(newItem).get("animate")))) {
            showOnly(index);
            update();
            return;
        }
        newItem.style().removeProperty("visibility");
        JsPropertyMap<Object> timing = JsPropertyMap.of();
        timing.set("duration", transition);
        timing.set("easing", "ease-in-out");
        JsPropertyMap<Object> out = JsPropertyMap.of();
        out.set("opacity", new String[] { "1", "0" });
        out.set("transform", new String[] { "translateY(0)", "translateY(-0.5em)" });
        JsPropertyMap<Object> in = JsPropertyMap.of();
        in.set("opacity", new String[] { "0", "1" });
        in.set("transform", new String[] { "translateY(0.5em)", "translateY(0)" });
        outgoing = oldItem.animate(Js.uncheckedCast(out), Js.uncheckedCast(timing));
        incoming = newItem.animate(Js.uncheckedCast(in), Js.uncheckedCast(timing));
        incoming.onfinish = event -> {
            stopAnimations();
            showOnly(index);
            update();
        };
    }

    private NodeList items() {
        return root.querySelectorAll("[data-rotating-item]");
    }

    private void showOnly(int active) {
        NodeList items = items();
        for (int i = 0; i < items.length(); i++) {
            HTMLElement item = Js.uncheckedCast(items.item(i));
            // The active item inherits visibility so hidden ancestors still hide it.
            if (i == active) item.style().removeProperty("visibility");
            else item.style().setProperty("visibility", "hidden");
        }
    }

    private void stopTimer() {
        if (timer != -1) WindowGlobal.clearTimeout(timer);
        timer = -1;
    }

    private void stopAnimations() {
        Animation oldOutgoing = outgoing;
        Animation oldIncoming = incoming;
        outgoing = null;
        incoming = null;
        if (oldOutgoing != null) oldOutgoing.cancel();
        if (oldIncoming != null) {
            oldIncoming.onfinish = null;
            oldIncoming.cancel();
        }
    }

    void dispose() {
        if (disposed) return;
        disposed = true;
        release();
        if (intersection != null) intersection.disconnect();
        intersection = null;
    }
}
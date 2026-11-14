package dev.reuise.web.frontend;

import akasha.Animation;
import akasha.Console;
import akasha.Element;
import akasha.EventListener;
import akasha.IntersectionObserver;
import akasha.MediaQueryList;
import akasha.MutationObserver;
import akasha.MutationObserverInit;
import akasha.NodeList;
import akasha.WindowGlobal;
import dev.reuise.core.ComponentAnimation;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

/**
 * Browser-side, progressive-enhancement controller. It never changes inline styles:
 * SSR and unenhanced content remain visible, including while waiting for the viewport.
 */
public final class ComponentEntranceAnimation {
    private static final String PROPERTY = "__reuiseEntranceAnimation";
    private final Element element;
    private final ComponentAnimation config;
    private IntersectionObserver intersection;
    private MutationObserver removal;
    private MediaQueryList motion;
    private EventListener motionListener;
    private Animation animation;
    private boolean armed = true;

    public ComponentEntranceAnimation(Element element, ComponentAnimation config) {
        this.element = element;
        this.config = config;
        Js.asPropertyMap(element).set(PROPERTY, this);
    }

    /** Activate configurations on a newly attached component and its descendants. */
    public static void attachTree(Element root) {
        forTree(root, true);
    }

    /** Stop pending and running animations before a component subtree is removed. */
    public static void cancelTree(Element root) {
        forTree(root, false);
    }

    private static void forTree(Element root, boolean attach) {
        if (root == null) return;
        visit(root, attach);
        NodeList nodes = root.querySelectorAll("*");
        for (int i = 0; i < nodes.length(); i++) visit((Element) nodes.item(i), attach);
    }

    private static void visit(Element element, boolean attach) {
        Object value = Js.asPropertyMap(element).get(PROPERTY);
        if (value == null) return;
        ComponentEntranceAnimation controller = (ComponentEntranceAnimation) value;
        if (attach) controller.attach();
        else controller.cancel();
    }

    public void attach() {
        if (!armed || config.getTrigger() == ComponentAnimation.Trigger.MANUAL) return;
        try {
            if (!browserApisAvailable(config.getTrigger() == ComponentAnimation.Trigger.VIEWPORT)) {
                cancel();
                return;
            }
            if (!element.isConnected()) return;
            if (config.getTrigger() == ComponentAnimation.Trigger.RENDER) {
                startInternal();
                return;
            }
            MediaQueryList query = motionQuery();
            if (query == null || query.matches()) {
                cancel();
                return;
            }
            watchRemoval();
            watchMotion(query);
            if (intersection == null) {
                intersection = new IntersectionObserver((entries, observer) -> {
                    try {
                        if (!armed || intersection != observer) return;
                        for (int i = 0; i < entries.length; i++) {
                            // Entries can belong to the callback's realm, not the window's realm.
                            Object isIntersecting = Js.asPropertyMap(entries.getAt(i)).get("isIntersecting");
                            if (!"boolean".equals(Js.typeof(isIntersecting))) {
                                cancel();
                                return;
                            }
                            if (Js.asBoolean(isIntersecting)) {
                                startInternal();
                                break;
                            }
                        }
                    } catch (RuntimeException | Error failure) {
                        reportFailure(failure);
                        throw failure;
                    }
                });
                intersection.observe(element);
            }
        } catch (RuntimeException | Error failure) {
            reportFailure(failure);
            throw failure;
        }
    }

    public void start() {
        try {
            startInternal();
        } catch (RuntimeException | Error failure) {
            reportFailure(failure);
            throw failure;
        }
    }

    private void startInternal() {
        if (!browserApisAvailable(false) || !element.isConnected()) {
            cancel();
            return;
        }
        MediaQueryList query = motionQuery();
        if (query == null || query.matches()) {
            cancel();
            return;
        }
        stopResources();
        armed = false;
        watchRemoval();
        watchMotion(query);
        JsPropertyMap<Object> frames = JsPropertyMap.of();
        String opacity = WindowGlobal.getComputedStyle(element).getPropertyValue("opacity");
        if (config.getEffect() == ComponentAnimation.Effect.FADE) {
            frames.set("opacity", new String[] { "0", opacity });
        } else if (config.getEffect() == ComponentAnimation.Effect.SLIDE) {
            String existing = WindowGlobal.getComputedStyle(element).getPropertyValue("transform");
            if ("none".equals(existing)) existing = "";
            int distance = config.getDistancePixels();
            String offset;
            switch (config.getDirection()) {
                case TOP: offset = "translateY(-" + distance + "px)"; break;
                case LEFT: offset = "translateX(-" + distance + "px)"; break;
                case RIGHT: offset = "translateX(" + distance + "px)"; break;
                default: offset = "translateY(" + distance + "px)"; break;
            }
            frames.set("transform", new String[] { offset + " " + existing, existing.isEmpty() ? "none" : existing });
        } else {
            String existing = WindowGlobal.getComputedStyle(element).getPropertyValue("filter");
            if ("none".equals(existing)) existing = "";
            frames.set("filter", new String[] { "blur(" + config.getBlurPixels() + "px) " + existing,
                    existing.isEmpty() ? "none" : existing });
            frames.set("opacity", new String[] { "0", opacity });
        }
        JsPropertyMap<Object> timing = JsPropertyMap.of();
        timing.set("duration", config.getDurationMillis());
        timing.set("delay", config.getDelayMillis());
        String easing;
        switch (config.getEasing()) {
            case LINEAR: easing = "linear"; break;
            case EASE: easing = "ease"; break;
            case EASE_IN: easing = "ease-in"; break;
            case EASE_IN_OUT: easing = "ease-in-out"; break;
            default: easing = "ease-out"; break;
        }
        timing.set("easing", easing);
        timing.set("fill", "backwards");
        animation = element.animate(Js.uncheckedCast(frames), Js.uncheckedCast(timing));
        animation.onfinish = event -> {
            animation = null;
            try {
                stopResources();
            } catch (RuntimeException | Error failure) {
                reportFailure(failure);
                throw failure;
            }
        };
    }

    public void cancel() {
        armed = false;
        stopResources();
    }

    public void dispose() {
        cancel();
        if (Js.asPropertyMap(element).get(PROPERTY) == this)
            Js.asPropertyMap(element).delete(PROPERTY);
    }

    private boolean browserApisAvailable(boolean viewport) {
        JsPropertyMap<Object> window = Js.asPropertyMap(WindowGlobal.window());
        JsPropertyMap<Object> target = Js.asPropertyMap(element);
        return isFunction(window.get("matchMedia"))
                && isFunction(window.get("getComputedStyle"))
                && isFunction(window.get("MutationObserver"))
                && (!viewport || isFunction(window.get("IntersectionObserver")))
                && isFunction(target.get("animate"))
                && "boolean".equals(Js.typeof(target.get("isConnected")));
    }

    private static boolean isFunction(Object value) {
        return "function".equals(Js.typeof(value));
    }

    private MediaQueryList motionQuery() {
        MediaQueryList query = WindowGlobal.matchMedia("(prefers-reduced-motion: reduce)");
        if (query == null) throw new IllegalStateException("matchMedia returned null");
        JsPropertyMap<Object> properties = Js.asPropertyMap(query);
        if (!"boolean".equals(Js.typeof(properties.get("matches")))
                || !isFunction(properties.get("addEventListener"))
                || !isFunction(properties.get("removeEventListener"))) return null;
        return query;
    }

    private void reportFailure(Throwable failure) {
        try {
            cancel();
        } catch (RuntimeException | Error cleanupFailure) {
            Console.error("Reuise animation cleanup failed", cleanupFailure);
        }
        Console.error("Reuise entrance animation failed", failure);
    }

    private void watchRemoval() {
        if (removal != null) return;
        removal = new MutationObserver((records, observer) -> {
            try {
                if (!element.isConnected()) cancel();
            } catch (RuntimeException | Error failure) {
                reportFailure(failure);
                throw failure;
            }
        });
        MutationObserverInit init = MutationObserverInit.of();
        init.setChildList(true);
        init.setSubtree(true);
        removal.observe(WindowGlobal.document(), init);
    }

    private void watchMotion(MediaQueryList query) {
        if (motion != null) return;
        motion = query;
        motionListener = event -> {
            try {
                if (motion != null && motion.matches()) cancel();
            } catch (RuntimeException | Error failure) {
                reportFailure(failure);
                throw failure;
            }
        };
        motion.addEventListener("change", motionListener);
    }

    private void stopResources() {
        IntersectionObserver oldIntersection = intersection;
        MutationObserver oldRemoval = removal;
        MediaQueryList oldMotion = motion;
        EventListener oldMotionListener = motionListener;
        Animation running = animation;
        intersection = null;
        removal = null;
        motion = null;
        motionListener = null;
        animation = null;
        try {
            if (oldIntersection != null) oldIntersection.disconnect();
        } finally {
            try {
                if (oldRemoval != null) oldRemoval.disconnect();
            } finally {
                try {
                    if (oldMotion != null && oldMotionListener != null)
                        oldMotion.removeEventListener("change", oldMotionListener);
                } finally {
                    if (running != null) {
                        running.onfinish = null;
                        running.cancel();
                    }
                }
            }
        }
    }
}

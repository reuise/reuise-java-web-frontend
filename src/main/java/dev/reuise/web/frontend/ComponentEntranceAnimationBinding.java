package dev.reuise.web.frontend;

import akasha.Element;
import dev.reuise.core.ComponentAnimation;

/** Per-component state used by opted-in frontend component parts. */
public final class ComponentEntranceAnimationBinding {
    private ComponentAnimation animation;
    private ComponentEntranceAnimation controller;

    public ComponentAnimation get() {
        return animation;
    }

    public void set(Element element, ComponentAnimation value) {
        if (animation == value && controller != null) return;
        if (controller != null) controller.dispose();
        animation = value;
        controller = value == null ? null : new ComponentEntranceAnimation(element, value);
        if (controller != null) controller.attach();
    }

    public void start() {
        if (controller != null) controller.start();
    }

    public void cancel() {
        if (controller != null) controller.cancel();
    }
}

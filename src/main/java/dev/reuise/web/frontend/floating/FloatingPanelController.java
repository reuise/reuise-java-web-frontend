package dev.reuise.web.frontend.floating;

import akasha.Element;
import akasha.Event;
import akasha.EventListener;
import akasha.HTMLElement;
import akasha.KeyboardEvent;
import akasha.MutationObserver;
import akasha.MutationObserverInit;
import akasha.Node;
import akasha.WindowGlobal;

/** Scoped listeners and non-modal focus management; no global keyboard or routing hooks. */
final class FloatingPanelController {
    private final WebFrontendFloatingPanel component;
    private final HTMLElement root;
    private final HTMLElement panel;
    private final HTMLElement trigger;
    private final EventListener click = this::click;
    private final EventListener keydown = event -> keydown((KeyboardEvent) event);
    private MutationObserver removal;
    private boolean expanded;
    private boolean connected;
    private boolean disposed;
    private boolean focusWasInside;
    private HTMLElement previousFocus;

    FloatingPanelController(WebFrontendFloatingPanel component) {
        this.component = component;
        root = component.getHtmlElement();
        panel = component.getPanel().getHtmlElement();
        trigger = component.getTrigger().getHtmlElement();
        root.addEventListener("click", click);
        root.addEventListener("keydown", keydown);
        // Hydrating an already-open panel must not steal focus.
        expanded = component.isExpanded();
        observeRemoval();
    }

    void beforeChange() {
        focusWasInside = panel.contains(WindowGlobal.document().activeElement());
    }

    void synchronize() {
        if (disposed || expanded == component.isExpanded()) return;
        expanded = component.isExpanded();
        if (expanded) {
            Element active = WindowGlobal.document().activeElement();
            previousFocus = active instanceof HTMLElement ? (HTMLElement) active : null;
            if (root.isConnected()) panel.focus();
        } else if (focusWasInside) {
            if (previousFocus != null && previousFocus != WindowGlobal.document().body
                    && previousFocus.isConnected() && previousFocus.getClientRects().length() > 0
                    && previousFocus.closest("[hidden],[inert],[disabled]") == null) previousFocus.focus();
            if (WindowGlobal.document().activeElement() != previousFocus && trigger.isConnected())
                trigger.focus();
        }
        if (!expanded) previousFocus = null;
    }

    private void click(Event event) {
        if (!(event.target() instanceof Element)) return;
        Element target = (Element) event.target();
        if (target.closest("[disabled],[aria-disabled=\"true\"],.reuise-disabled,[inert]") != null) return;
        if (trigger.contains(target)) component.toggle();
        else if (component.getCloseButton().getHtmlElement().contains(target)) component.close();
        else if (component.getMinimiseButton().getHtmlElement().contains(target)) component.minimise();
    }

    private void keydown(KeyboardEvent event) {
        if (!event.defaultPrevented() && "Escape".equals(event.key()) && component.isExpanded()
                && event.target() instanceof Node && panel.contains((Node) event.target())) {
            event.preventDefault();
            event.stopPropagation();
            component.close();
        }
    }

    private void observeRemoval() {
        connected = root.isConnected();
        removal = new MutationObserver((records, observer) -> {
            if (root.isConnected()) connected = true;
            else if (connected) dispose();
        });
        MutationObserverInit init = MutationObserverInit.of();
        init.setChildList(true);
        init.setSubtree(true);
        removal.observe(WindowGlobal.document(), init);
    }

    void dispose() {
        if (disposed) return;
        component.close();
        disposed = true;
        root.removeEventListener("click", click);
        root.removeEventListener("keydown", keydown);
        if (removal != null) {
            removal.disconnect();
            removal = null;
        }
        previousFocus = null;
    }
}

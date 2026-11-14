package dev.reuise.web.frontend.menu;

import java.util.ArrayList;
import java.util.List;
import akasha.Element;
import akasha.Event;
import akasha.EventListener;
import akasha.HTMLElement;
import akasha.KeyboardEvent;
import akasha.MutationObserver;
import akasha.MutationObserverInit;
import akasha.Node;
import akasha.NodeList;
import akasha.WindowGlobal;

/** One controller is installed by each created or hydrated MenuButton. */
final class MenuButtonController {
    private final WebFrontendMenuButton menu;
    private final HTMLElement root;
    private final HTMLElement trigger;
    private final HTMLElement popup;
    private final MenuButtonPopupPosition position;
    private final EventListener click = this::click;
    private final EventListener keydown = event -> keydown((KeyboardEvent) event);
    private final EventListener outside = this::outside;
    private MutationObserver removal;
    private boolean listening;
    private boolean connected;
    private boolean suppressRestore;
    private String search = "";
    private long searchTime;

    MenuButtonController(WebFrontendMenuButton menu) {
        this.menu = menu;
        root = menu.getHtmlElement();
        trigger = menu.getTrigger().getHtmlElement();
        popup = menu.getPopup().getHtmlElement();
        position = new MenuButtonPopupPosition(root, trigger, popup);
        root.addEventListener("click", click);
        root.addEventListener("keydown", keydown);
        synchronize();
    }

    void synchronize() {
        if (menu.isExpanded()) {
            if (listening) return;
            listening = true;
            connected = root.isConnected();
            WindowGlobal.document().addEventListener("pointerdown", outside, true);
            WindowGlobal.document().addEventListener("click", outside, true);
            WindowGlobal.document().addEventListener("focusin", outside, true);
            removal = new MutationObserver((records, observer) -> {
                if (root.isConnected()) {
                    connected = true;
                    position.schedule();
                }
                else if (connected) close(false);
            });
            MutationObserverInit init = MutationObserverInit.of();
            init.setChildList(true);
            init.setSubtree(true);
            removal.observe(WindowGlobal.document(), init);
            position.start();
            if (menu.isActionMenu()) focusBoundary(false);
        } else {
            if (!suppressRestore && popup.contains(WindowGlobal.document().activeElement()) && root.isConnected())
                trigger.focus();
            stopListening();
            search = "";
        }
    }

    private void outside(Event event) {
        if (event.target() instanceof Node && !root.contains((Node) event.target())) close(false);
    }

    private void click(Event event) {
        if (!(event.target() instanceof Element)) return;
        Element target = (Element) event.target();
        if (trigger.contains(target)) {
            if (disabled(trigger)) return;
            menu.toggle();
            return;
        }
        if (!menu.isExpanded() || !popup.contains(target)) return;
        if (menu.isActionMenu()) {
            Element item = target.closest("[role=\"menuitem\"]");
            if (item != null && item.closest("[role=\"menu\"]") == popup && !disabled(item)) close(true);
        } else {
            Element item = target.closest("a[href],button");
            if (item != null && popup.contains(item) && !disabled(item)) close(false);
        }
    }

    private void keydown(KeyboardEvent event) {
        if (!(event.target() instanceof Node)) return;
        Node target = (Node) event.target();
        boolean atTrigger = trigger.contains(target);
        boolean inPopup = popup.contains(target);
        String key = event.key();
        if ("Escape".equals(key) && menu.isExpanded()) {
            event.preventDefault();
            event.stopPropagation();
            close(true);
            return;
        }
        if (!menu.isActionMenu()) return;
        if (atTrigger && ("ArrowDown".equals(key) || "ArrowUp".equals(key))) {
            if (disabled(trigger)) return;
            event.preventDefault();
            menu.open();
            focusBoundary("ArrowUp".equals(key));
            return;
        }
        if (!inPopup || !menu.isExpanded()) return;
        // Do not handle keys belonging to a nested menu.
        if (event.target() instanceof Element
                && ((Element) event.target()).closest("[role=\"menu\"]") != popup) return;
        if ("Tab".equals(key)) {
            close(true);
            return;
        }
        List<HTMLElement> items = items();
        if (items.isEmpty()) return;
        int index = items.indexOf(WindowGlobal.document().activeElement());
        int next = -1;
        if ("ArrowDown".equals(key)) next = (index + 1) % items.size();
        else if ("ArrowUp".equals(key)) next = index <= 0 ? items.size() - 1 : index - 1;
        else if ("Home".equals(key)) next = 0;
        else if ("End".equals(key)) next = items.size() - 1;
        else if (key.length() == 1 && !" ".equals(key)
                && !event.ctrlKey() && !event.altKey() && !event.metaKey()) {
            long now = System.currentTimeMillis();
            search = now - searchTime > 700 ? key.toLowerCase() : search + key.toLowerCase();
            searchTime = now;
            String prefix = search;
            // Repeated letters cycle between matches rather than forming "aaa".
            boolean repeated = true;
            for (int i = 1; i < search.length(); i++) {
                if (search.charAt(i) != search.charAt(0)) repeated = false;
            }
            if (repeated) prefix = search.substring(0, 1);
            for (int offset = 1; offset <= items.size(); offset++) {
                int candidate = (index + offset) % items.size();
                String label = items.get(candidate).getAttribute("aria-label");
                if (label == null) label = items.get(candidate).textContent;
                if (label != null && label.trim().toLowerCase().startsWith(prefix)) {
                    next = candidate;
                    break;
                }
            }
        } else return;
        event.preventDefault();
        if (next >= 0) items.get(next).focus();
    }

    private boolean disabled(Element item) {
        return item.closest("[disabled],[aria-disabled=\"true\"],.reuise-disabled,[hidden],[inert]") != null;
    }

    private List<HTMLElement> items() {
        List<HTMLElement> items = new ArrayList<>();
        NodeList nodes = popup.querySelectorAll("[role=\"menuitem\"]");
        for (int i = 0; i < nodes.length(); i++) {
            Element item = (Element) nodes.item(i);
            if (item instanceof HTMLElement && item.closest("[role=\"menu\"]") == popup
                    && !disabled(item) && !"hidden".equals(WindowGlobal.getComputedStyle(item).getPropertyValue("visibility"))
                    && ((HTMLElement) item).getClientRects().length() > 0) {
                items.add((HTMLElement) item);
            }
        }
        return items;
    }

    private void focusBoundary(boolean last) {
        List<HTMLElement> items = items();
        if (!items.isEmpty()) items.get(last ? items.size() - 1 : 0).focus();
    }

    private void close(boolean restoreFocus) {
        suppressRestore = true;
        try {
            menu.close();
        } finally {
            suppressRestore = false;
        }
        if (restoreFocus && root.isConnected()) trigger.focus();
    }

    private void stopListening() {
        position.stop();
        WindowGlobal.document().removeEventListener("pointerdown", outside, true);
        WindowGlobal.document().removeEventListener("click", outside, true);
        WindowGlobal.document().removeEventListener("focusin", outside, true);
        if (removal != null) {
            removal.disconnect();
            removal = null;
        }
        listening = false;
    }

    void dispose() {
        close(false);
        stopListening();
        root.removeEventListener("click", click);
        root.removeEventListener("keydown", keydown);
    }
}

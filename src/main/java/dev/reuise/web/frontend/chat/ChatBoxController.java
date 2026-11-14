package dev.reuise.web.frontend.chat;

import java.util.Objects;

import akasha.Element;
import akasha.Event;
import akasha.EventListener;
import akasha.KeyboardEvent;
import akasha.MutationObserver;
import akasha.MutationObserverInit;
import akasha.MutationRecord;
import akasha.Node;
import akasha.NodeList;
import akasha.WindowGlobal;
import dev.reuise.core.chat.ChatActions;
import jsinterop.base.Js;

/**
 * Connects a created or hydrated ChatBox to application callbacks.
 * The application supplies and updates messages, loading, errors and handoff status;
 * no service, authentication, routing or persistence is performed here. A successful send
 * clears the unchanged draft; blank drafts and missing send handlers do nothing. Enter sends;
 * Shift+Enter and IME composition retain their native behavior. Status setters remain under
 * application control. Dispose explicitly if the box will never be mounted. After removal,
 * create a fresh box and controller.
 */
public final class ChatBoxController {
    private static final String ATTACHED = "data-reuise-chat-controller";
    private final WebFrontendChatBox chat;
    private final ChatActions actions;
    private final Element root;
    private final EventListener click = this::click;
    private final EventListener keydown = event -> keydown((KeyboardEvent) event);
    private MutationObserver removal;
    private boolean connected;
    private boolean disposed;

    public ChatBoxController(WebFrontendChatBox chat, ChatActions actions) {
        this.chat = Objects.requireNonNull(chat, "chat");
        this.actions = Objects.requireNonNull(actions, "actions");
        if (chat.hasAttribute(ATTACHED)) throw new IllegalStateException("A chat controller is already attached");
        root = chat.getElement();
        root.addEventListener("click", click);
        root.addEventListener("keydown", keydown);
        chat.setAttribute(ATTACHED, "true");
        connected = root.isConnected();
        removal = new MutationObserver((records, observer) -> {
            if (root.isConnected()) connected = true;
            else {
                for (int i = 0; !connected && i < records.length; i++) {
                    MutationRecord record = Js.uncheckedCast(records.getAt(i));
                    NodeList added = record.addedNodes();
                    for (int j = 0; j < added.length(); j++) {
                        Node node = added.item(j);
                        if (node == root || node.contains(root)) {
                            connected = true;
                            break;
                        }
                    }
                }
                if (connected) dispose();
            }
        });
        MutationObserverInit init = MutationObserverInit.of();
        init.setChildList(true);
        init.setSubtree(true);
        removal.observe(WindowGlobal.document(), init);
    }

    private void click(Event event) {
        if (disposed || !(event.target() instanceof Element) || !chat.getFloatingPanel().isExpanded()) return;
        Element target = (Element) event.target();
        if (target.closest("[disabled],[aria-disabled=\"true\"],.reuise-disabled,[inert]") != null) return;
        if (chat.getSendButton().getElement().contains(target) && !chat.isLoading()) send();
        else if (chat.getStopButton().getElement().contains(target) && chat.isLoading()) actions.stop();
        else if (chat.getRetryButton().getElement().contains(target) && !chat.isLoading()
                && chat.getErrorMessage() != null && !chat.getErrorMessage().isEmpty()) actions.retry();
        else if (chat.getRequestHumanButton().getElement().contains(target)
                && "available".equals(chat.getHandoffStatus())) actions.requestHuman();
    }

    private void keydown(KeyboardEvent event) {
        if (disposed || event.defaultPrevented() || chat.isLoading() || !chat.getFloatingPanel().isExpanded()
                || event.target() != chat.getComposer().getElement() || !"Enter".equals(event.key())
                || event.shiftKey() || event.ctrlKey() || event.altKey() || event.metaKey()
                || event.isComposing() || event.keyCode() == 229) return;
        event.preventDefault();
        send();
    }

    private void send() {
        String text = chat.getComposer().getValue();
        if (actions.send(text) && Objects.equals(text, chat.getComposer().getValue()))
            chat.getComposer().setValue("");
    }

    public void dispose() {
        if (disposed) return;
        disposed = true;
        root.removeEventListener("click", click);
        root.removeEventListener("keydown", keydown);
        if (removal != null) {
            removal.disconnect();
            removal = null;
        }
        chat.removeAttribute(ATTACHED);
    }
}

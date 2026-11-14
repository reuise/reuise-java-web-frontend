package dev.reuise.web.frontend.chat;
import dev.reuise.core.ComponentAnimation;
import dev.reuise.web.core.chat.WebChatBox;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
public interface WebFrontendChatBox extends WebFrontendContainer , WebChatBox , WebFrontendChatBoxPart , WebFrontendComponent {
    WebFrontendChatBox getComponent();

    WebFrontendChatBox setAnimation(ComponentAnimation animation);

    WebFrontendChatBox startAnimation();

    WebFrontendChatBox cancelAnimation();
}

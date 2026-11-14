package dev.reuise.web.frontend.chat;
import dev.reuise.web.core.chat.WebChatBoxPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.button.WebFrontendButton;
import dev.reuise.web.frontend.floating.WebFrontendFloatingPanel;
import dev.reuise.web.frontend.input.WebFrontendBasicInputField;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
import dev.reuise.web.frontend.layout.WebFrontendContainerPart;
import dev.reuise.web.frontend.text.WebFrontendParagraph;
public interface WebFrontendChatBoxPart extends WebFrontendComponentPart , WebChatBoxPart , WebFrontendContainerPart , WebFrontendChatBoxFeatures {
    WebFrontendFloatingPanel getFloatingPanel();

    WebFrontendContainer getChatContent();

    WebFrontendContainer getMessages();

    WebFrontendParagraph getLoadingIndicator();

    WebFrontendParagraph getErrorDisplay();

    WebFrontendButton getRetryButton();

    WebFrontendParagraph getHandoffDisplay();

    WebFrontendButton getRequestHumanButton();

    WebFrontendContainer getComposerArea();

    WebFrontendBasicInputField getComposer();

    WebFrontendButton getSendButton();

    WebFrontendButton getStopButton();

    WebFrontendContainerPart getContainerPart();
}

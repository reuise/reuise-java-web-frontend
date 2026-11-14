package dev.reuise.web.frontend.chat;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.core.option.ComponentCreator;
import dev.reuise.web.core.chat.WebChatBoxPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.button.WebFrontendButton;
import dev.reuise.web.frontend.button.WebFrontendButtonOptions;
import dev.reuise.web.frontend.floating.WebFrontendFloatingPanel;
import dev.reuise.web.frontend.floating.WebFrontendFloatingPanelOptions;
import dev.reuise.web.frontend.input.WebFrontendBasicInputField;
import dev.reuise.web.frontend.input.WebFrontendBasicInputFieldOptions;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
import dev.reuise.web.frontend.layout.WebFrontendContainerOptions;
import dev.reuise.web.frontend.layout.WebFrontendContainerPartOptions;
import dev.reuise.web.frontend.text.WebFrontendParagraph;
import dev.reuise.web.frontend.text.WebFrontendParagraphOptions;
public interface WebFrontendChatBoxPartOptions extends WebChatBoxPartOptions {
    WebFrontendContainerPartOptions getContainerPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    WebFrontendChatBoxPartOptions setFloatingPanelCreator(ComponentCreator<? extends WebFrontendFloatingPanel, ? extends WebFrontendFloatingPanelOptions> floatingPanelCreator);

    WebFrontendChatBoxPartOptions setChatContentCreator(ComponentCreator<? extends WebFrontendContainer, ? extends WebFrontendContainerOptions> chatContentCreator);

    WebFrontendChatBoxPartOptions setMessagesCreator(ComponentCreator<? extends WebFrontendContainer, ? extends WebFrontendContainerOptions> messagesCreator);

    WebFrontendChatBoxPartOptions setLoadingIndicatorCreator(ComponentCreator<? extends WebFrontendParagraph, ? extends WebFrontendParagraphOptions> loadingIndicatorCreator);

    WebFrontendChatBoxPartOptions setErrorDisplayCreator(ComponentCreator<? extends WebFrontendParagraph, ? extends WebFrontendParagraphOptions> errorDisplayCreator);

    WebFrontendChatBoxPartOptions setRetryButtonCreator(ComponentCreator<? extends WebFrontendButton, ? extends WebFrontendButtonOptions> retryButtonCreator);

    WebFrontendChatBoxPartOptions setHandoffDisplayCreator(ComponentCreator<? extends WebFrontendParagraph, ? extends WebFrontendParagraphOptions> handoffDisplayCreator);

    WebFrontendChatBoxPartOptions setRequestHumanButtonCreator(ComponentCreator<? extends WebFrontendButton, ? extends WebFrontendButtonOptions> requestHumanButtonCreator);

    WebFrontendChatBoxPartOptions setComposerAreaCreator(ComponentCreator<? extends WebFrontendContainer, ? extends WebFrontendContainerOptions> composerAreaCreator);

    WebFrontendChatBoxPartOptions setComposerCreator(ComponentCreator<? extends WebFrontendBasicInputField, ? extends WebFrontendBasicInputFieldOptions> composerCreator);

    WebFrontendChatBoxPartOptions setSendButtonCreator(ComponentCreator<? extends WebFrontendButton, ? extends WebFrontendButtonOptions> sendButtonCreator);

    WebFrontendChatBoxPartOptions setStopButtonCreator(ComponentCreator<? extends WebFrontendButton, ? extends WebFrontendButtonOptions> stopButtonCreator);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendChatBox getComponent();
}

package dev.reuise.web.frontend.consent;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.core.option.ComponentCreator;
import dev.reuise.web.core.consent.WebConsentBannerPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.button.WebFrontendButton;
import dev.reuise.web.frontend.button.WebFrontendButtonOptions;
import dev.reuise.web.frontend.dialog.WebFrontendDialog;
import dev.reuise.web.frontend.dialog.WebFrontendDialogOptions;
import dev.reuise.web.frontend.layout.WebFrontendFlexContainer;
import dev.reuise.web.frontend.layout.WebFrontendFlexContainerOptions;
import dev.reuise.web.frontend.layout.WebFrontendFlexContainerPartOptions;
import dev.reuise.web.frontend.text.WebFrontendParagraph;
import dev.reuise.web.frontend.text.WebFrontendParagraphOptions;
public interface WebFrontendConsentBannerPartOptions extends WebConsentBannerPartOptions {
    WebFrontendFlexContainerPartOptions getFlexContainerPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    WebFrontendConsentBannerPartOptions setMessageParagraphCreator(ComponentCreator<? extends WebFrontendParagraph, ? extends WebFrontendParagraphOptions> messageParagraphCreator);

    WebFrontendConsentBannerPartOptions setActionsCreator(ComponentCreator<? extends WebFrontendFlexContainer, ? extends WebFrontendFlexContainerOptions> actionsCreator);

    WebFrontendConsentBannerPartOptions setAcceptButtonCreator(ComponentCreator<? extends WebFrontendButton, ? extends WebFrontendButtonOptions> acceptButtonCreator);

    WebFrontendConsentBannerPartOptions setRejectButtonCreator(ComponentCreator<? extends WebFrontendButton, ? extends WebFrontendButtonOptions> rejectButtonCreator);

    WebFrontendConsentBannerPartOptions setPreferencesButtonCreator(ComponentCreator<? extends WebFrontendButton, ? extends WebFrontendButtonOptions> preferencesButtonCreator);

    WebFrontendConsentBannerPartOptions setPreferencesDialogCreator(ComponentCreator<? extends WebFrontendDialog, ? extends WebFrontendDialogOptions> preferencesDialogCreator);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendConsentBanner getComponent();
}

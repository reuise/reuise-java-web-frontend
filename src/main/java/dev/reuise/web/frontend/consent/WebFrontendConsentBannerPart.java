package dev.reuise.web.frontend.consent;
import dev.reuise.web.core.consent.WebConsentBannerPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.button.WebFrontendButton;
import dev.reuise.web.frontend.dialog.WebFrontendDialog;
import dev.reuise.web.frontend.layout.WebFrontendFlexContainer;
import dev.reuise.web.frontend.layout.WebFrontendFlexContainerPart;
import dev.reuise.web.frontend.text.WebFrontendParagraph;
public interface WebFrontendConsentBannerPart extends WebFrontendComponentPart , WebFrontendConsentBannerFeatures , WebFrontendFlexContainerPart , WebConsentBannerPart {
    WebFrontendParagraph getMessageParagraph();

    WebFrontendFlexContainer getActions();

    WebFrontendButton getAcceptButton();

    WebFrontendButton getRejectButton();

    WebFrontendButton getPreferencesButton();

    WebFrontendDialog getPreferencesDialog();

    WebFrontendFlexContainerPart getFlexContainerPart();
}

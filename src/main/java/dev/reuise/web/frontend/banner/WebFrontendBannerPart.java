package dev.reuise.web.frontend.banner;
import dev.reuise.web.core.banner.WebBannerPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.button.WebFrontendButton;
import dev.reuise.web.frontend.icon.WebFrontendIcon;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
import dev.reuise.web.frontend.layout.WebFrontendFlexContainer;
import dev.reuise.web.frontend.layout.WebFrontendFlexContainerPart;
import dev.reuise.web.frontend.text.WebFrontendParagraph;
public interface WebFrontendBannerPart extends WebFrontendComponentPart , WebFrontendFlexContainerPart , WebFrontendBannerFeatures , WebBannerPart {
    WebFrontendIcon getIcon();

    WebFrontendContainer getContent();

    WebFrontendParagraph getMessageParagraph();

    WebFrontendFlexContainer getActions();

    WebFrontendButton getDismissButton();

    WebFrontendFlexContainerPart getFlexContainerPart();
}

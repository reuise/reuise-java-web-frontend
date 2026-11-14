package dev.reuise.web.frontend.carousel;
import dev.reuise.web.core.carousel.WebCarouselPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.button.WebFrontendButton;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
import dev.reuise.web.frontend.layout.WebFrontendContainerPart;
import dev.reuise.web.frontend.text.WebFrontendInlineText;
public interface WebFrontendCarouselPart extends WebFrontendComponentPart , WebFrontendContainerPart , WebFrontendCarouselFeatures , WebCarouselPart {
    void dispose();

    WebFrontendContainer getViewport();

    WebFrontendContainer getSlider();

    WebFrontendContainer getNavigation();

    WebFrontendButton getPreviousButton();

    WebFrontendContainer getIndicators();

    WebFrontendButton getNextButton();

    WebFrontendButton getAutoplayButton();

    WebFrontendInlineText getAnnouncement();

    WebFrontendContainerPart getContainerPart();
}

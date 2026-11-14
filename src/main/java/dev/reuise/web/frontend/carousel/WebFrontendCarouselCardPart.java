package dev.reuise.web.frontend.carousel;
import dev.reuise.web.core.carousel.WebCarouselCardPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.layout.WebFrontendContainerPart;
public interface WebFrontendCarouselCardPart extends WebFrontendComponentPart , WebFrontendContainerPart , WebFrontendCarouselCardFeatures , WebCarouselCardPart {
    WebFrontendContainerPart getContainerPart();
}

package dev.reuise.web.frontend.carousel;
import dev.reuise.web.core.carousel.WebCarouselCardOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.layout.WebFrontendContainerOptions;
import dev.reuise.web.frontend.layout.WebFrontendContainerPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendCarouselCardOptions extends WebFrontendContainerOptions , WebFrontendComponentOptions , WebFrontendBaseComponentPartOptions , WebFrontendCarouselCardPartOptions , WebFrontendContainerPartOptions , WebFrontendParentComponentPartOptions , WebCarouselCardOptions {
    WebFrontendContainerPartOptions getContainerPart();

    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}

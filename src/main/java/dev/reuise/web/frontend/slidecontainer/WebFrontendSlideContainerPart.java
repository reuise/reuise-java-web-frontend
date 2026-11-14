package dev.reuise.web.frontend.slidecontainer;
import dev.reuise.web.core.slidecontainer.WebSlideContainerPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
import dev.reuise.web.frontend.layout.WebFrontendContainerPart;
public interface WebFrontendSlideContainerPart extends WebSlideContainerPart , WebFrontendComponentPart , WebFrontendContainerPart , WebFrontendSlideContainerFeatures {
    WebFrontendContainer getSlideAreaBefore();

    WebFrontendContainer getSlideArea();

    WebFrontendContainer getSlideAreaAfter();

    WebFrontendContainerPart getContainerPart();
}

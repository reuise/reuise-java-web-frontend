package dev.reuise.web.frontend.scrollablecontainer;
import dev.reuise.web.core.scrollablecontainer.WebScrollableContainerPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
import dev.reuise.web.frontend.layout.WebFrontendContainerPart;
public interface WebFrontendScrollableContainerPart extends WebFrontendComponentPart , WebScrollableContainerPart , WebFrontendContainerPart , WebFrontendScrollableContainerFeatures {
    WebFrontendContainer getScrollAreaBefore();

    WebFrontendScrollableContainerScrollArea getScrollArea();

    WebFrontendContainer getScrollAreaAfter();

    WebFrontendContainerPart getContainerPart();
}

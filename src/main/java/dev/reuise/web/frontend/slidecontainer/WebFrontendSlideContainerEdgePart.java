package dev.reuise.web.frontend.slidecontainer;
import dev.reuise.web.core.slidecontainer.WebSlideContainerEdgePart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
public interface WebFrontendSlideContainerEdgePart extends WebFrontendParentComponentPart , WebFrontendComponentPart , WebSlideContainerEdgePart , WebFrontendSlideContainerEdgeFeatures {
    void enableSlideButton(boolean enable);

    WebFrontendParentComponentPart getParentComponentPart();
}

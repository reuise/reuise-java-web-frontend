package dev.reuise.web.frontend.slidecontainer;
import dev.reuise.web.core.slidecontainer.WebSlideContainerEdge;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponent;
public interface WebFrontendSlideContainerEdge extends WebSlideContainerEdge , WebFrontendParentComponent , WebFrontendComponent , WebFrontendSlideContainerEdgePart {
    WebFrontendSlideContainerEdge getComponent();
}

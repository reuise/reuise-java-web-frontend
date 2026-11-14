package dev.reuise.web.frontend.scrollablecontainer;
import dev.reuise.web.core.scrollablecontainer.WebScrollableContainerEdge;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponent;
public interface WebFrontendScrollableContainerEdge extends WebScrollableContainerEdge , WebFrontendParentComponent , WebFrontendScrollableContainerEdgePart , WebFrontendComponent {
    WebFrontendScrollableContainerEdge getComponent();
}

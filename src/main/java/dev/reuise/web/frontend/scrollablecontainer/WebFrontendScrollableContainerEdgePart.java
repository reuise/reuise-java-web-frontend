package dev.reuise.web.frontend.scrollablecontainer;
import dev.reuise.web.core.scrollablecontainer.WebScrollableContainerEdgePart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
public interface WebFrontendScrollableContainerEdgePart extends WebFrontendParentComponentPart , WebFrontendComponentPart , WebFrontendScrollableContainerEdgeFeatures , WebScrollableContainerEdgePart {
    void enableScrollButton(boolean enable);

    WebFrontendParentComponentPart getParentComponentPart();
}

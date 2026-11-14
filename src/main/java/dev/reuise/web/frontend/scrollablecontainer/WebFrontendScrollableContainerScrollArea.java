package dev.reuise.web.frontend.scrollablecontainer;
import dev.reuise.web.core.scrollablecontainer.WebScrollableContainerScrollArea;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponent;
public interface WebFrontendScrollableContainerScrollArea extends WebFrontendParentComponent , WebScrollableContainerScrollArea , WebFrontendComponent , WebFrontendScrollableContainerScrollAreaPart {
    WebFrontendScrollableContainerScrollArea getComponent();
}

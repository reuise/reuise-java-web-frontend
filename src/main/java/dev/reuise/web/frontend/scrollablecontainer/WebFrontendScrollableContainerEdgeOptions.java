package dev.reuise.web.frontend.scrollablecontainer;
import dev.reuise.web.core.scrollablecontainer.WebScrollableContainerEdgeOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendScrollableContainerEdgeOptions extends WebFrontendParentComponentOptions , WebFrontendComponentOptions , WebScrollableContainerEdgeOptions , WebFrontendBaseComponentPartOptions , WebFrontendScrollableContainerEdgePartOptions , WebFrontendParentComponentPartOptions {
    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}

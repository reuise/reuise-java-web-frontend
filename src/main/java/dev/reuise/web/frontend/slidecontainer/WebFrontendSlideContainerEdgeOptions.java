package dev.reuise.web.frontend.slidecontainer;
import dev.reuise.web.core.slidecontainer.WebSlideContainerEdgeOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendSlideContainerEdgeOptions extends WebFrontendParentComponentOptions , WebFrontendComponentOptions , WebFrontendSlideContainerEdgePartOptions , WebFrontendBaseComponentPartOptions , WebSlideContainerEdgeOptions , WebFrontendParentComponentPartOptions {
    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}

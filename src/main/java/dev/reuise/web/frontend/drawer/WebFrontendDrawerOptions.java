package dev.reuise.web.frontend.drawer;
import dev.reuise.web.core.drawer.WebDrawerOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.layout.WebFrontendContainerOptions;
import dev.reuise.web.frontend.layout.WebFrontendContainerPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendDrawerOptions extends WebFrontendContainerOptions , WebFrontendComponentOptions , WebFrontendBaseComponentPartOptions , WebDrawerOptions , WebFrontendContainerPartOptions , WebFrontendParentComponentPartOptions , WebFrontendDrawerPartOptions {
    WebFrontendContainerPartOptions getContainerPart();

    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}

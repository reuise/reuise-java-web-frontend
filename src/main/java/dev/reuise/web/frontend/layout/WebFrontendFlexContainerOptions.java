package dev.reuise.web.frontend.layout;
import dev.reuise.web.core.layout.WebFlexContainerOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendFlexContainerOptions extends WebFrontendContainerOptions , WebFlexContainerOptions , WebFrontendComponentOptions , WebFrontendBaseComponentPartOptions , WebFrontendFlexContainerPartOptions , WebFrontendContainerPartOptions , WebFrontendParentComponentPartOptions {
    WebFrontendContainerPartOptions getContainerPart();

    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}

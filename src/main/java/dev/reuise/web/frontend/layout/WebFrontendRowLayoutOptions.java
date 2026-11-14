package dev.reuise.web.frontend.layout;
import dev.reuise.web.core.layout.WebRowLayoutOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendRowLayoutOptions extends WebFrontendComponentOptions , WebFrontendRowLayoutPartOptions , WebFrontendFlexContainerOptions , WebFrontendBaseComponentPartOptions , WebFrontendFlexContainerPartOptions , WebFrontendContainerPartOptions , WebFrontendParentComponentPartOptions , WebRowLayoutOptions {
    WebFrontendFlexContainerPartOptions getFlexContainerPart();

    WebFrontendContainerPartOptions getContainerPart();

    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}

package dev.reuise.web.frontend.layout;
import dev.reuise.web.core.layout.WebFieldSetOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendFieldSetOptions extends WebFrontendContainerOptions , WebFieldSetOptions , WebFrontendComponentOptions , WebFrontendBaseComponentPartOptions , WebFrontendContainerPartOptions , WebFrontendParentComponentPartOptions , WebFrontendFieldSetPartOptions {
    WebFrontendContainerPartOptions getContainerPart();

    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}

package dev.reuise.web.frontend.applayout;
import dev.reuise.web.core.applayout.WebAppLayoutBodyOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.layout.WebFrontendContainerPartOptions;
import dev.reuise.web.frontend.layout.WebFrontendFlexContainerOptions;
import dev.reuise.web.frontend.layout.WebFrontendFlexContainerPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendAppLayoutBodyOptions extends WebFrontendAppLayoutBodyPartOptions , WebAppLayoutBodyOptions , WebFrontendComponentOptions , WebFrontendFlexContainerOptions , WebFrontendBaseComponentPartOptions , WebFrontendFlexContainerPartOptions , WebFrontendContainerPartOptions , WebFrontendParentComponentPartOptions {
    WebFrontendFlexContainerPartOptions getFlexContainerPart();

    WebFrontendContainerPartOptions getContainerPart();

    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}

package dev.reuise.web.frontend.card;
import dev.reuise.web.core.card.WebCardOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.layout.WebFrontendContainerPartOptions;
import dev.reuise.web.frontend.layout.WebFrontendFlexContainerPartOptions;
import dev.reuise.web.frontend.layout.WebFrontendSurfaceOptions;
import dev.reuise.web.frontend.layout.WebFrontendSurfacePartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendCardOptions extends WebFrontendCardPartOptions , WebFrontendComponentOptions , WebFrontendSurfaceOptions , WebCardOptions , WebFrontendBaseComponentPartOptions , WebFrontendFlexContainerPartOptions , WebFrontendSurfacePartOptions , WebFrontendContainerPartOptions , WebFrontendParentComponentPartOptions {
    WebFrontendSurfacePartOptions getSurfacePart();

    WebFrontendFlexContainerPartOptions getFlexContainerPart();

    WebFrontendContainerPartOptions getContainerPart();

    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}

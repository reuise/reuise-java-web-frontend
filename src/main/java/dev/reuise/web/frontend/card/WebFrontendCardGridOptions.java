package dev.reuise.web.frontend.card;
import dev.reuise.web.core.card.WebCardGridOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.layout.WebFrontendContainerOptions;
import dev.reuise.web.frontend.layout.WebFrontendContainerPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendCardGridOptions extends WebFrontendContainerOptions , WebFrontendComponentOptions , WebCardGridOptions , WebFrontendBaseComponentPartOptions , WebFrontendContainerPartOptions , WebFrontendCardGridPartOptions , WebFrontendParentComponentPartOptions {
    WebFrontendContainerPartOptions getContainerPart();

    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}

package dev.reuise.web.frontend.navigation;
import dev.reuise.web.core.navigation.WebNavigationTreeOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.accordion.WebFrontendAccordionOptions;
import dev.reuise.web.frontend.accordion.WebFrontendAccordionPartOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.layout.WebFrontendContainerPartOptions;
import dev.reuise.web.frontend.layout.WebFrontendFlexContainerPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendNavigationTreeOptions extends WebFrontendComponentOptions , WebNavigationTreeOptions , WebFrontendAccordionPartOptions , WebFrontendBaseComponentPartOptions , WebFrontendNavigationTreePartOptions , WebFrontendAccordionOptions , WebFrontendFlexContainerPartOptions , WebFrontendContainerPartOptions , WebFrontendParentComponentPartOptions {
    WebFrontendAccordionPartOptions getAccordionPart();

    WebFrontendFlexContainerPartOptions getFlexContainerPart();

    WebFrontendContainerPartOptions getContainerPart();

    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}

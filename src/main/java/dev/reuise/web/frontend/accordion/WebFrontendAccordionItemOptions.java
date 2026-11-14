package dev.reuise.web.frontend.accordion;
import dev.reuise.web.core.accordion.WebAccordionItemOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.layout.WebFrontendContainerPartOptions;
import dev.reuise.web.frontend.layout.WebFrontendFlexContainerOptions;
import dev.reuise.web.frontend.layout.WebFrontendFlexContainerPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendAccordionItemOptions extends WebFrontendComponentOptions , WebFrontendFlexContainerOptions , WebFrontendAccordionItemPartOptions , WebFrontendBaseComponentPartOptions , WebFrontendFlexContainerPartOptions , WebAccordionItemOptions , WebFrontendContainerPartOptions , WebFrontendParentComponentPartOptions {
    WebFrontendFlexContainerPartOptions getFlexContainerPart();

    WebFrontendContainerPartOptions getContainerPart();

    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}

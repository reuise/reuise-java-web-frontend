package dev.reuise.web.frontend.navigation;
import dev.reuise.web.core.navigation.WebNavigationTreeGroupOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.accordion.WebFrontendAccordionItemOptions;
import dev.reuise.web.frontend.accordion.WebFrontendAccordionItemPartOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.layout.WebFrontendContainerPartOptions;
import dev.reuise.web.frontend.layout.WebFrontendFlexContainerPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendNavigationTreeGroupOptions extends WebFrontendAccordionItemOptions , WebFrontendComponentOptions , WebFrontendNavigationTreeGroupPartOptions , WebFrontendAccordionItemPartOptions , WebFrontendBaseComponentPartOptions , WebFrontendFlexContainerPartOptions , WebNavigationTreeGroupOptions , WebFrontendContainerPartOptions , WebFrontendParentComponentPartOptions {
    WebFrontendAccordionItemPartOptions getAccordionItemPart();

    WebFrontendFlexContainerPartOptions getFlexContainerPart();

    WebFrontendContainerPartOptions getContainerPart();

    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}

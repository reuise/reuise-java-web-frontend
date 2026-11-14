package dev.reuise.web.frontend.selectmenu;
import dev.reuise.web.core.selectmenu.WebSelectMenuOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendSelectMenuOptions extends WebFrontendParentComponentOptions , WebFrontendComponentOptions , WebFrontendBaseComponentPartOptions , WebFrontendSelectMenuPartOptions , WebFrontendParentComponentPartOptions , WebSelectMenuOptions {
    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}

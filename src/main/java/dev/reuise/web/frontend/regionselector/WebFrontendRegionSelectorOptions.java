package dev.reuise.web.frontend.regionselector;
import dev.reuise.web.core.regionselector.WebRegionSelectorOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
import dev.reuise.web.frontend.selectmenu.WebFrontendSelectMenuOptions;
import dev.reuise.web.frontend.selectmenu.WebFrontendSelectMenuPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendRegionSelectorOptions extends WebFrontendComponentOptions , WebRegionSelectorOptions , WebFrontendBaseComponentPartOptions , WebFrontendSelectMenuOptions , WebFrontendRegionSelectorPartOptions , WebFrontendSelectMenuPartOptions , WebFrontendParentComponentPartOptions {
    WebFrontendSelectMenuPartOptions getSelectMenuPart();

    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}

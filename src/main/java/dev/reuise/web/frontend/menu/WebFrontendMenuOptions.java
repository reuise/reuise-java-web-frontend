package dev.reuise.web.frontend.menu;
import dev.reuise.web.core.menu.WebMenuOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendMenuOptions extends WebFrontendParentComponentOptions , WebFrontendComponentOptions , WebFrontendBaseComponentPartOptions , WebMenuOptions , WebFrontendMenuPartOptions , WebFrontendParentComponentPartOptions {
    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}

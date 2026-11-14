package dev.reuise.web.frontend.menu;
import dev.reuise.web.core.menu.WebMenuItemOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.list.WebFrontendBasicListItemPartOptions;
import dev.reuise.web.frontend.list.WebFrontendListItemOptions;
import dev.reuise.web.frontend.list.WebFrontendListItemPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendMenuItemOptions extends WebFrontendComponentOptions , WebFrontendListItemOptions , WebFrontendBasicListItemPartOptions , WebFrontendBaseComponentPartOptions , WebMenuItemOptions , WebFrontendListItemPartOptions , WebFrontendMenuItemPartOptions , WebFrontendParentComponentPartOptions {
    WebFrontendListItemPartOptions getListItemPart();

    WebFrontendBasicListItemPartOptions getBasicListItemPart();

    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}

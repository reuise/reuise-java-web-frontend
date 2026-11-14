package dev.reuise.web.frontend.menu;
import dev.reuise.web.core.menu.WebMenuDividerOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.list.WebFrontendBasicListItemPartOptions;
import dev.reuise.web.frontend.list.WebFrontendListItemPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendMenuDividerOptions extends WebFrontendMenuDividerPartOptions , WebFrontendComponentOptions , WebFrontendBasicListItemPartOptions , WebFrontendBaseComponentPartOptions , WebMenuDividerOptions , WebFrontendMenuItemOptions , WebFrontendListItemPartOptions , WebFrontendMenuItemPartOptions , WebFrontendParentComponentPartOptions {
    WebFrontendMenuItemPartOptions getMenuItemPart();

    WebFrontendListItemPartOptions getListItemPart();

    WebFrontendBasicListItemPartOptions getBasicListItemPart();

    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}

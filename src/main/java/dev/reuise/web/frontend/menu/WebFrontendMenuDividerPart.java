package dev.reuise.web.frontend.menu;
import dev.reuise.web.core.menu.WebMenuDividerPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
public interface WebFrontendMenuDividerPart extends WebFrontendComponentPart , WebFrontendMenuDividerFeatures , WebFrontendMenuItemPart , WebMenuDividerPart {
    WebFrontendMenuItemPart getMenuItemPart();
}

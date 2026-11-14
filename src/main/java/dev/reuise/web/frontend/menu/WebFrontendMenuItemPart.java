package dev.reuise.web.frontend.menu;
import dev.reuise.web.core.menu.WebMenuItemPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.list.WebFrontendListItemPart;
public interface WebFrontendMenuItemPart extends WebFrontendComponentPart , WebMenuItemPart , WebFrontendMenuItemFeatures , WebFrontendListItemPart {
    WebFrontendListItemPart getListItemPart();
}

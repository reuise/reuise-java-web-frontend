package dev.reuise.web.frontend.menu;
import dev.reuise.web.core.menu.WebMenuDivider;
import dev.reuise.web.frontend.WebFrontendComponent;
public interface WebFrontendMenuDivider extends WebMenuDivider , WebFrontendMenuDividerPart , WebFrontendComponent , WebFrontendMenuItem {
    WebFrontendMenuDivider getComponent();
}

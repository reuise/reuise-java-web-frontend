package dev.reuise.web.frontend.menu;
import dev.reuise.web.core.menu.WebMenuButtonItem;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.button.WebFrontendButton;
public interface WebFrontendMenuButtonItem extends WebMenuButtonItem , WebFrontendButton , WebFrontendComponent , WebFrontendMenuButtonItemPart {
    WebFrontendMenuButtonItem getComponent();
}

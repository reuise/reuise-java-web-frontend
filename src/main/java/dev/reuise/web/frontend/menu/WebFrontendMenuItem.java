package dev.reuise.web.frontend.menu;
import dev.reuise.web.core.menu.WebMenuItem;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.list.WebFrontendListItem;
public interface WebFrontendMenuItem extends WebMenuItem , WebFrontendListItem , WebFrontendMenuItemPart , WebFrontendComponent {
    WebFrontendMenuItem getComponent();
}

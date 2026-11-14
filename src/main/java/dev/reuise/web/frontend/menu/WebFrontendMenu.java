package dev.reuise.web.frontend.menu;
import dev.reuise.web.core.menu.WebMenu;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponent;
public interface WebFrontendMenu extends WebMenu , WebFrontendParentComponent , WebFrontendComponent , WebFrontendMenuPart {
    WebFrontendMenu getComponent();
}

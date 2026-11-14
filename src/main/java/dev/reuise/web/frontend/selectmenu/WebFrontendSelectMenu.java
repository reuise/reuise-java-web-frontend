package dev.reuise.web.frontend.selectmenu;
import dev.reuise.web.core.selectmenu.WebSelectMenu;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponent;
public interface WebFrontendSelectMenu extends WebFrontendParentComponent , WebFrontendSelectMenuPart , WebSelectMenu , WebFrontendComponent {
    WebFrontendSelectMenu getComponent();
}

package dev.reuise.web.frontend.regionselector;
import dev.reuise.web.core.regionselector.WebRegionSelector;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.selectmenu.WebFrontendSelectMenu;
public interface WebFrontendRegionSelector extends WebFrontendRegionSelectorPart , WebFrontendComponent , WebRegionSelector , WebFrontendSelectMenu {
    WebFrontendRegionSelector getComponent();
}

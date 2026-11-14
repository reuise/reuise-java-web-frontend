package dev.reuise.web.frontend.regionselector;
import dev.reuise.web.core.regionselector.WebRegionSelectorPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.selectmenu.WebFrontendSelectMenuPart;
public interface WebFrontendRegionSelectorPart extends WebFrontendComponentPart , WebFrontendSelectMenuPart , WebRegionSelectorPart , WebFrontendRegionSelectorFeatures {
    WebFrontendSelectMenuPart getSelectMenuPart();
}

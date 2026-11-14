package dev.reuise.web.frontend.regionselector;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.web.core.regionselector.WebRegionSelectorPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.selectmenu.WebFrontendSelectMenuPartOptions;
public interface WebFrontendRegionSelectorPartOptions extends WebRegionSelectorPartOptions {
    WebFrontendSelectMenuPartOptions getSelectMenuPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendRegionSelector getComponent();
}

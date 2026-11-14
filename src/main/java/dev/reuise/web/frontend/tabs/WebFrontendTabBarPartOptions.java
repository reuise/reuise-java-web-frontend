package dev.reuise.web.frontend.tabs;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.core.option.ComponentCreator;
import dev.reuise.web.core.tabs.WebTabBarPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
import dev.reuise.web.frontend.layout.WebFrontendContainerOptions;
import dev.reuise.web.frontend.layout.WebFrontendContainerPartOptions;
public interface WebFrontendTabBarPartOptions extends WebTabBarPartOptions {
    WebFrontendContainerPartOptions getContainerPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    WebFrontendTabBarPartOptions setContainerCreator(ComponentCreator<? extends WebFrontendContainer, ? extends WebFrontendContainerOptions> containerCreator);

    WebFrontendTabBarPartOptions setActiveIndicatorCreator(ComponentCreator<? extends WebFrontendContainer, ? extends WebFrontendContainerOptions> activeIndicatorCreator);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendTabBar getComponent();
}

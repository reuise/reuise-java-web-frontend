package dev.reuise.web.frontend.applayout;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.core.option.ComponentCreator;
import dev.reuise.web.core.applayout.WebAppLayoutPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
import dev.reuise.web.frontend.layout.WebFrontendContainerOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
import dev.reuise.web.frontend.splitcontainer.WebFrontendSplitContainer;
import dev.reuise.web.frontend.splitcontainer.WebFrontendSplitContainerOptions;
public interface WebFrontendAppLayoutPartOptions extends WebAppLayoutPartOptions {
    WebFrontendParentComponentPartOptions getParentComponentPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    WebFrontendAppLayoutPartOptions setDrawerScrimCreator(ComponentCreator<? extends WebFrontendContainer, ? extends WebFrontendContainerOptions> drawerScrimCreator);

    WebFrontendAppLayoutPartOptions setDrawerSplitCreator(ComponentCreator<? extends WebFrontendSplitContainer, ? extends WebFrontendSplitContainerOptions> drawerSplitCreator);

    WebFrontendAppLayoutPartOptions setTopAppBarSplitCreator(ComponentCreator<? extends WebFrontendSplitContainer, ? extends WebFrontendSplitContainerOptions> topAppBarSplitCreator);

    WebFrontendAppLayoutPartOptions setBodyCreator(ComponentCreator<? extends WebFrontendAppLayoutBody, ? extends WebFrontendAppLayoutBodyOptions> bodyCreator);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendAppLayout getComponent();
}

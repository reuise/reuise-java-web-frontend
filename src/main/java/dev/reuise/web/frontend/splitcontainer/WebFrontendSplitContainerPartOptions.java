package dev.reuise.web.frontend.splitcontainer;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.core.option.ComponentCreator;
import dev.reuise.web.core.splitcontainer.WebSplitContainerPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
import dev.reuise.web.frontend.layout.WebFrontendContainerOptions;
import dev.reuise.web.frontend.layout.WebFrontendContainerPartOptions;
public interface WebFrontendSplitContainerPartOptions extends WebSplitContainerPartOptions {
    WebFrontendContainerPartOptions getContainerPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    WebFrontendSplitContainerPartOptions setContainerCreator(ComponentCreator<? extends WebFrontendContainer, ? extends WebFrontendContainerOptions> containerCreator);

    WebFrontendSplitContainerPartOptions setStartPanelCreator(ComponentCreator<? extends WebFrontendSplitContainerPanel, ? extends WebFrontendSplitContainerPanelOptions> startPanelCreator);

    WebFrontendSplitContainerPartOptions setDividerCreator(ComponentCreator<? extends WebFrontendSplitContainerDivider, ? extends WebFrontendSplitContainerDividerOptions> dividerCreator);

    WebFrontendSplitContainerPartOptions setEndPanelCreator(ComponentCreator<? extends WebFrontendSplitContainerPanel, ? extends WebFrontendSplitContainerPanelOptions> endPanelCreator);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendSplitContainer getComponent();
}

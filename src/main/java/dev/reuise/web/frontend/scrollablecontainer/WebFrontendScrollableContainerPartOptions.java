package dev.reuise.web.frontend.scrollablecontainer;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.core.option.ComponentCreator;
import dev.reuise.web.core.scrollablecontainer.WebScrollableContainerPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
import dev.reuise.web.frontend.layout.WebFrontendContainerOptions;
import dev.reuise.web.frontend.layout.WebFrontendContainerPartOptions;
public interface WebFrontendScrollableContainerPartOptions extends WebScrollableContainerPartOptions {
    WebFrontendContainerPartOptions getContainerPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    WebFrontendScrollableContainerPartOptions setScrollAreaBeforeCreator(ComponentCreator<? extends WebFrontendContainer, ? extends WebFrontendContainerOptions> scrollAreaBeforeCreator);

    WebFrontendScrollableContainerPartOptions setScrollAreaCreator(ComponentCreator<? extends WebFrontendScrollableContainerScrollArea, ? extends WebFrontendScrollableContainerScrollAreaOptions> scrollAreaCreator);

    WebFrontendScrollableContainerPartOptions setScrollAreaAfterCreator(ComponentCreator<? extends WebFrontendContainer, ? extends WebFrontendContainerOptions> scrollAreaAfterCreator);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendScrollableContainer getComponent();
}

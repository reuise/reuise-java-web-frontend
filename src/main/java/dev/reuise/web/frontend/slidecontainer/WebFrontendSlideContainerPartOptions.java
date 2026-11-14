package dev.reuise.web.frontend.slidecontainer;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.core.option.ComponentCreator;
import dev.reuise.web.core.slidecontainer.WebSlideContainerPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
import dev.reuise.web.frontend.layout.WebFrontendContainerOptions;
import dev.reuise.web.frontend.layout.WebFrontendContainerPartOptions;
public interface WebFrontendSlideContainerPartOptions extends WebSlideContainerPartOptions {
    WebFrontendContainerPartOptions getContainerPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    WebFrontendSlideContainerPartOptions setSlideAreaBeforeCreator(ComponentCreator<? extends WebFrontendContainer, ? extends WebFrontendContainerOptions> slideAreaBeforeCreator);

    WebFrontendSlideContainerPartOptions setSlideAreaCreator(ComponentCreator<? extends WebFrontendContainer, ? extends WebFrontendContainerOptions> slideAreaCreator);

    WebFrontendSlideContainerPartOptions setSlideAreaAfterCreator(ComponentCreator<? extends WebFrontendContainer, ? extends WebFrontendContainerOptions> slideAreaAfterCreator);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendSlideContainer getComponent();
}

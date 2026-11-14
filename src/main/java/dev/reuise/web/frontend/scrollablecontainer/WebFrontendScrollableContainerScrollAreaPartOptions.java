package dev.reuise.web.frontend.scrollablecontainer;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.core.option.ComponentCreator;
import dev.reuise.web.core.scrollablecontainer.WebScrollableContainerScrollAreaPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
import dev.reuise.web.frontend.layout.WebFrontendContainerOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
public interface WebFrontendScrollableContainerScrollAreaPartOptions extends WebScrollableContainerScrollAreaPartOptions {
    WebFrontendParentComponentPartOptions getParentComponentPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    WebFrontendScrollableContainerScrollAreaPartOptions setScrollAreaTopFadeCreator(ComponentCreator<? extends WebFrontendContainer, ? extends WebFrontendContainerOptions> scrollAreaTopFadeCreator);

    WebFrontendScrollableContainerScrollAreaPartOptions setScrollAreaLeftFadeCreator(ComponentCreator<? extends WebFrontendContainer, ? extends WebFrontendContainerOptions> scrollAreaLeftFadeCreator);

    WebFrontendScrollableContainerScrollAreaPartOptions setScrollAreaContentCreator(ComponentCreator<? extends WebFrontendContainer, ? extends WebFrontendContainerOptions> scrollAreaContentCreator);

    WebFrontendScrollableContainerScrollAreaPartOptions setScrollAreaBottomFadeCreator(ComponentCreator<? extends WebFrontendContainer, ? extends WebFrontendContainerOptions> scrollAreaBottomFadeCreator);

    WebFrontendScrollableContainerScrollAreaPartOptions setScrollAreaRightFadeCreator(ComponentCreator<? extends WebFrontendContainer, ? extends WebFrontendContainerOptions> scrollAreaRightFadeCreator);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendScrollableContainerScrollArea getComponent();
}

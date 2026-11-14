package dev.reuise.web.frontend.slidecontainer;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.web.core.slidecontainer.WebSlideContainerEdgePartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
public interface WebFrontendSlideContainerEdgePartOptions extends WebSlideContainerEdgePartOptions {
    WebFrontendParentComponentPartOptions getParentComponentPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendSlideContainerEdge getComponent();
}

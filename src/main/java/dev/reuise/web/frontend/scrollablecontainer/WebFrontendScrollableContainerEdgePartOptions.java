package dev.reuise.web.frontend.scrollablecontainer;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.web.core.scrollablecontainer.WebScrollableContainerEdgePartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
public interface WebFrontendScrollableContainerEdgePartOptions extends WebScrollableContainerEdgePartOptions {
    WebFrontendParentComponentPartOptions getParentComponentPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendScrollableContainerEdge getComponent();
}

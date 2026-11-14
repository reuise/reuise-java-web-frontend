package dev.reuise.web.frontend.view;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.web.core.view.WebRouteLayoutPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.layout.WebFrontendContainerPartOptions;
public interface WebFrontendRouteLayoutPartOptions extends WebRouteLayoutPartOptions {
    WebFrontendContainerPartOptions getContainerPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendRouteLayout getComponent();
}

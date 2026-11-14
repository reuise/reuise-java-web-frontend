package dev.reuise.web.frontend.layout;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.web.core.layout.WebSurfacePartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
public interface WebFrontendSurfacePartOptions extends WebSurfacePartOptions {
    WebFrontendFlexContainerPartOptions getFlexContainerPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendSurface getComponent();
}

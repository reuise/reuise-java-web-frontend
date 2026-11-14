package dev.reuise.web.frontend.layout;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.web.core.layout.WebFlexContainerPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
public interface WebFrontendFlexContainerPartOptions extends WebFlexContainerPartOptions {
    WebFrontendContainerPartOptions getContainerPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendFlexContainer getComponent();
}

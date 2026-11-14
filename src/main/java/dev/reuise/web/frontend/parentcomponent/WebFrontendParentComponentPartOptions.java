package dev.reuise.web.frontend.parentcomponent;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.web.core.parentcomponent.WebParentComponentPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
public interface WebFrontendParentComponentPartOptions extends WebParentComponentPartOptions {
    WebFrontendBaseComponentPartOptions getBaseComponentPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendParentComponent getComponent();
}

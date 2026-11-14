package dev.reuise.web.frontend.bottomappbar;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.web.core.bottomappbar.WebBottomAppBarPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
public interface WebFrontendBottomAppBarPartOptions extends WebBottomAppBarPartOptions {
    WebFrontendBaseComponentPartOptions getBaseComponentPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendBottomAppBar getComponent();
}

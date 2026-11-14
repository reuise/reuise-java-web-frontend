package dev.reuise.web.frontend.button;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.web.core.button.WebButtonBarPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.layout.WebFrontendFlexContainerPartOptions;
public interface WebFrontendButtonBarPartOptions extends WebButtonBarPartOptions {
    WebFrontendFlexContainerPartOptions getFlexContainerPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendButtonBar getComponent();
}

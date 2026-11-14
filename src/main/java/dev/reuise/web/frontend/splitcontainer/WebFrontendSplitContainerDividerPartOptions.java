package dev.reuise.web.frontend.splitcontainer;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.web.core.splitcontainer.WebSplitContainerDividerPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.layout.WebFrontendContainerPartOptions;
public interface WebFrontendSplitContainerDividerPartOptions extends WebSplitContainerDividerPartOptions {
    WebFrontendContainerPartOptions getContainerPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendSplitContainerDivider getComponent();
}

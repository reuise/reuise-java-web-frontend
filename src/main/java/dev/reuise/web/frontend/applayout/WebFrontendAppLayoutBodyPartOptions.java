package dev.reuise.web.frontend.applayout;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.web.core.applayout.WebAppLayoutBodyPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.layout.WebFrontendFlexContainerPartOptions;
public interface WebFrontendAppLayoutBodyPartOptions extends WebAppLayoutBodyPartOptions {
    WebFrontendFlexContainerPartOptions getFlexContainerPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendAppLayoutBody getComponent();
}

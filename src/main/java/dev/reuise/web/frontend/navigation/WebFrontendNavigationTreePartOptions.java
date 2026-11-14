package dev.reuise.web.frontend.navigation;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.web.core.navigation.WebNavigationTreePartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.accordion.WebFrontendAccordionPartOptions;
public interface WebFrontendNavigationTreePartOptions extends WebNavigationTreePartOptions {
    WebFrontendAccordionPartOptions getAccordionPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendNavigationTree getComponent();
}

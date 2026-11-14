package dev.reuise.web.frontend.accordion;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.web.core.accordion.WebAccordionPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.layout.WebFrontendFlexContainerPartOptions;
public interface WebFrontendAccordionPartOptions extends WebAccordionPartOptions {
    WebFrontendFlexContainerPartOptions getFlexContainerPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendAccordion getComponent();
}

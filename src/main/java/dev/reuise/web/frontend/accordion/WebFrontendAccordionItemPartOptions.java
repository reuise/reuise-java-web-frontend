package dev.reuise.web.frontend.accordion;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.core.option.ComponentCreator;
import dev.reuise.web.core.accordion.WebAccordionItemPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.button.WebFrontendButton;
import dev.reuise.web.frontend.button.WebFrontendButtonOptions;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
import dev.reuise.web.frontend.layout.WebFrontendContainerOptions;
import dev.reuise.web.frontend.layout.WebFrontendFlexContainer;
import dev.reuise.web.frontend.layout.WebFrontendFlexContainerOptions;
import dev.reuise.web.frontend.layout.WebFrontendFlexContainerPartOptions;
public interface WebFrontendAccordionItemPartOptions extends WebAccordionItemPartOptions {
    WebFrontendFlexContainerPartOptions getFlexContainerPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    WebFrontendAccordionItemPartOptions setHeaderCreator(ComponentCreator<? extends WebFrontendFlexContainer, ? extends WebFrontendFlexContainerOptions> headerCreator);

    WebFrontendAccordionItemPartOptions setToggleCreator(ComponentCreator<? extends WebFrontendButton, ? extends WebFrontendButtonOptions> toggleCreator);

    WebFrontendAccordionItemPartOptions setContentCreator(ComponentCreator<? extends WebFrontendContainer, ? extends WebFrontendContainerOptions> contentCreator);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendAccordionItem getComponent();
}

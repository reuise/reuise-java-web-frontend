package dev.reuise.web.frontend.accordion;
import dev.reuise.web.core.accordion.WebAccordionItemPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.button.WebFrontendButton;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
import dev.reuise.web.frontend.layout.WebFrontendFlexContainer;
import dev.reuise.web.frontend.layout.WebFrontendFlexContainerPart;
public interface WebFrontendAccordionItemPart extends WebFrontendComponentPart , WebFrontendAccordionItemFeatures , WebAccordionItemPart , WebFrontendFlexContainerPart {
    WebFrontendFlexContainer getHeader();

    WebFrontendButton getToggle();

    WebFrontendContainer getContent();

    WebFrontendFlexContainerPart getFlexContainerPart();
}

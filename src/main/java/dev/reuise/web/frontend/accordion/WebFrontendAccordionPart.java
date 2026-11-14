package dev.reuise.web.frontend.accordion;
import dev.reuise.web.core.accordion.WebAccordionPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.layout.WebFrontendFlexContainerPart;
public interface WebFrontendAccordionPart extends WebFrontendComponentPart , WebAccordionPart , WebFrontendFlexContainerPart , WebFrontendAccordionFeatures {
    WebFrontendFlexContainerPart getFlexContainerPart();
}

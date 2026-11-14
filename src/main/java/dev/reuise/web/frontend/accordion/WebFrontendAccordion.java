package dev.reuise.web.frontend.accordion;
import dev.reuise.core.ComponentAnimation;
import dev.reuise.web.core.accordion.WebAccordion;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.layout.WebFrontendFlexContainer;
public interface WebFrontendAccordion extends WebAccordion , WebFrontendFlexContainer , WebFrontendAccordionPart , WebFrontendComponent {
    WebFrontendAccordion getComponent();

    WebFrontendAccordion setAnimation(ComponentAnimation animation);

    WebFrontendAccordion startAnimation();

    WebFrontendAccordion cancelAnimation();
}

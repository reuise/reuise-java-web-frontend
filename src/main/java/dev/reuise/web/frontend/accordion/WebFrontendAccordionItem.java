package dev.reuise.web.frontend.accordion;
import dev.reuise.core.ComponentAnimation;
import dev.reuise.web.core.accordion.WebAccordionItem;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.layout.WebFrontendFlexContainer;
public interface WebFrontendAccordionItem extends WebAccordionItem , WebFrontendFlexContainer , WebFrontendComponent , WebFrontendAccordionItemPart {
    WebFrontendAccordionItem getComponent();

    WebFrontendAccordionItem setAnimation(ComponentAnimation animation);

    WebFrontendAccordionItem startAnimation();

    WebFrontendAccordionItem cancelAnimation();
}

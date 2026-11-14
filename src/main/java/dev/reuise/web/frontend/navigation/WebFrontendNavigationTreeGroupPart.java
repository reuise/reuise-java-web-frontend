package dev.reuise.web.frontend.navigation;
import dev.reuise.web.core.navigation.WebNavigationTreeGroupPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.accordion.WebFrontendAccordionItemPart;
public interface WebFrontendNavigationTreeGroupPart extends WebFrontendComponentPart , WebNavigationTreeGroupPart , WebFrontendNavigationTreeGroupFeatures , WebFrontendAccordionItemPart {
    WebFrontendNavigationTreeLink getLink();

    WebFrontendNavigationTree getTree();

    WebFrontendAccordionItemPart getAccordionItemPart();
}

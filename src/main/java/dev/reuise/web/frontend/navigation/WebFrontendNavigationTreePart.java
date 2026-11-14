package dev.reuise.web.frontend.navigation;
import dev.reuise.web.core.navigation.WebNavigationTreePart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.accordion.WebFrontendAccordionPart;
public interface WebFrontendNavigationTreePart extends WebFrontendComponentPart , WebFrontendNavigationTreeFeatures , WebFrontendAccordionPart , WebNavigationTreePart {
    WebFrontendAccordionPart getAccordionPart();
}

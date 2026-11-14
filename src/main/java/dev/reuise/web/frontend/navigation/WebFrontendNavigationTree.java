package dev.reuise.web.frontend.navigation;
import dev.reuise.core.ComponentAnimation;
import dev.reuise.web.core.navigation.WebNavigationTree;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.accordion.WebFrontendAccordion;
public interface WebFrontendNavigationTree extends WebNavigationTree , WebFrontendAccordion , WebFrontendComponent , WebFrontendNavigationTreePart {
    WebFrontendNavigationTree getComponent();

    WebFrontendNavigationTree setAnimation(ComponentAnimation animation);

    WebFrontendNavigationTree startAnimation();

    WebFrontendNavigationTree cancelAnimation();
}

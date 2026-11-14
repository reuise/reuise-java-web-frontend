package dev.reuise.web.frontend.navigation;
import dev.reuise.core.ComponentAnimation;
import dev.reuise.web.core.navigation.WebNavigationTreeGroup;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.accordion.WebFrontendAccordionItem;
public interface WebFrontendNavigationTreeGroup extends WebFrontendNavigationTreeGroupPart , WebFrontendAccordionItem , WebNavigationTreeGroup , WebFrontendComponent {
    WebFrontendNavigationTreeGroup getComponent();

    WebFrontendNavigationTreeGroup setAnimation(ComponentAnimation animation);

    WebFrontendNavigationTreeGroup startAnimation();

    WebFrontendNavigationTreeGroup cancelAnimation();
}

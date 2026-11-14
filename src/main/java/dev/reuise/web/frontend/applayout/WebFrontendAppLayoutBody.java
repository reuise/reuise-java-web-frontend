package dev.reuise.web.frontend.applayout;
import dev.reuise.core.ComponentAnimation;
import dev.reuise.web.core.applayout.WebAppLayoutBody;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.layout.WebFrontendFlexContainer;
public interface WebFrontendAppLayoutBody extends WebFrontendAppLayoutBodyPart , WebFrontendFlexContainer , WebAppLayoutBody , WebFrontendComponent {
    WebFrontendAppLayoutBody getComponent();

    WebFrontendAppLayoutBody setAnimation(ComponentAnimation animation);

    WebFrontendAppLayoutBody startAnimation();

    WebFrontendAppLayoutBody cancelAnimation();
}

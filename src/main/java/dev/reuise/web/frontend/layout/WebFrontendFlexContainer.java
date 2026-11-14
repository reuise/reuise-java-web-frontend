package dev.reuise.web.frontend.layout;
import dev.reuise.core.ComponentAnimation;
import dev.reuise.web.core.layout.WebFlexContainer;
import dev.reuise.web.frontend.WebFrontendComponent;
public interface WebFrontendFlexContainer extends WebFrontendContainer , WebFlexContainer , WebFrontendFlexContainerPart , WebFrontendComponent {
    WebFrontendFlexContainer getComponent();

    WebFrontendFlexContainer setAnimation(ComponentAnimation animation);

    WebFrontendFlexContainer startAnimation();

    WebFrontendFlexContainer cancelAnimation();
}

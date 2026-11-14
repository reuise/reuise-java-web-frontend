package dev.reuise.web.frontend.layout;
import dev.reuise.core.ComponentAnimation;
import dev.reuise.web.core.layout.WebContainer;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponent;
public interface WebFrontendContainer extends WebFrontendContainerPart , WebFrontendParentComponent , WebContainer , WebFrontendComponent {
    WebFrontendContainer getComponent();

    WebFrontendContainer setAnimation(ComponentAnimation animation);

    WebFrontendContainer startAnimation();

    WebFrontendContainer cancelAnimation();
}

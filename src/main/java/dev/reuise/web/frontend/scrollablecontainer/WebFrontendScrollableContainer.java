package dev.reuise.web.frontend.scrollablecontainer;
import dev.reuise.core.ComponentAnimation;
import dev.reuise.web.core.scrollablecontainer.WebScrollableContainer;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
public interface WebFrontendScrollableContainer extends WebFrontendContainer , WebScrollableContainer , WebFrontendComponent , WebFrontendScrollableContainerPart {
    WebFrontendScrollableContainer getComponent();

    WebFrontendScrollableContainer setAnimation(ComponentAnimation animation);

    WebFrontendScrollableContainer startAnimation();

    WebFrontendScrollableContainer cancelAnimation();
}

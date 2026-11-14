package dev.reuise.web.frontend.slidecontainer;
import dev.reuise.core.ComponentAnimation;
import dev.reuise.web.core.slidecontainer.WebSlideContainer;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
public interface WebFrontendSlideContainer extends WebFrontendContainer , WebSlideContainer , WebFrontendComponent , WebFrontendSlideContainerPart {
    WebFrontendSlideContainer getComponent();

    WebFrontendSlideContainer setAnimation(ComponentAnimation animation);

    WebFrontendSlideContainer startAnimation();

    WebFrontendSlideContainer cancelAnimation();
}

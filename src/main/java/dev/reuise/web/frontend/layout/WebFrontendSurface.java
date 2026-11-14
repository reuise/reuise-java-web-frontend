package dev.reuise.web.frontend.layout;
import dev.reuise.core.ComponentAnimation;
import dev.reuise.web.core.layout.WebSurface;
import dev.reuise.web.frontend.WebFrontendComponent;
public interface WebFrontendSurface extends WebFrontendFlexContainer , WebSurface , WebFrontendComponent , WebFrontendSurfacePart {
    WebFrontendSurface getComponent();

    WebFrontendSurface setAnimation(ComponentAnimation animation);

    WebFrontendSurface startAnimation();

    WebFrontendSurface cancelAnimation();
}

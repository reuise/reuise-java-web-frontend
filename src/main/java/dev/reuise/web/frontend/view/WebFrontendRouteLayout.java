package dev.reuise.web.frontend.view;
import dev.reuise.core.ComponentAnimation;
import dev.reuise.web.core.view.WebRouteLayout;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
public interface WebFrontendRouteLayout extends WebFrontendContainer , WebRouteLayout , WebFrontendComponent , WebFrontendRouteLayoutPart {
    WebFrontendRouteLayout getComponent();

    WebFrontendRouteLayout setAnimation(ComponentAnimation animation);

    WebFrontendRouteLayout startAnimation();

    WebFrontendRouteLayout cancelAnimation();
}

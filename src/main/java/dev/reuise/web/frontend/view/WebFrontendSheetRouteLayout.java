package dev.reuise.web.frontend.view;
import dev.reuise.core.ComponentAnimation;
import dev.reuise.web.core.view.WebSheetRouteLayout;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.layout.WebFrontendSheetLayout;
public interface WebFrontendSheetRouteLayout extends WebSheetRouteLayout , WebFrontendSheetLayout , WebFrontendSheetRouteLayoutPart , WebFrontendComponent {
    WebFrontendSheetRouteLayout getComponent();

    WebFrontendSheetRouteLayout setAnimation(ComponentAnimation animation);

    WebFrontendSheetRouteLayout startAnimation();

    WebFrontendSheetRouteLayout cancelAnimation();
}

package dev.reuise.web.frontend.drawer;
import dev.reuise.core.ComponentAnimation;
import dev.reuise.web.core.drawer.WebDrawer;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
public interface WebFrontendDrawer extends WebFrontendContainer , WebFrontendDrawerPart , WebDrawer , WebFrontendComponent {
    WebFrontendDrawer getComponent();

    WebFrontendDrawer setAnimation(ComponentAnimation animation);

    WebFrontendDrawer startAnimation();

    WebFrontendDrawer cancelAnimation();
}

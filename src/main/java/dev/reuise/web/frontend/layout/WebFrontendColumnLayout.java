package dev.reuise.web.frontend.layout;
import dev.reuise.core.ComponentAnimation;
import dev.reuise.web.core.layout.WebColumnLayout;
import dev.reuise.web.frontend.WebFrontendComponent;
public interface WebFrontendColumnLayout extends WebFrontendColumnLayoutPart , WebColumnLayout , WebFrontendFlexContainer , WebFrontendComponent {
    WebFrontendColumnLayout getComponent();

    WebFrontendColumnLayout setAnimation(ComponentAnimation animation);

    WebFrontendColumnLayout startAnimation();

    WebFrontendColumnLayout cancelAnimation();
}

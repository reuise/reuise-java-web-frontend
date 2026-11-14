package dev.reuise.web.frontend.layout;
import dev.reuise.core.ComponentAnimation;
import dev.reuise.web.core.layout.WebRowLayout;
import dev.reuise.web.frontend.WebFrontendComponent;
public interface WebFrontendRowLayout extends WebFrontendRowLayoutPart , WebRowLayout , WebFrontendFlexContainer , WebFrontendComponent {
    WebFrontendRowLayout getComponent();

    WebFrontendRowLayout setAnimation(ComponentAnimation animation);

    WebFrontendRowLayout startAnimation();

    WebFrontendRowLayout cancelAnimation();
}

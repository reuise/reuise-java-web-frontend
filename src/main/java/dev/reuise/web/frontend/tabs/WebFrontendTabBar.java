package dev.reuise.web.frontend.tabs;
import dev.reuise.core.ComponentAnimation;
import dev.reuise.web.core.tabs.WebTabBar;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
public interface WebFrontendTabBar extends WebFrontendContainer , WebFrontendTabBarPart , WebTabBar , WebFrontendComponent {
    WebFrontendTabBar getComponent();

    WebFrontendTabBar setAnimation(ComponentAnimation animation);

    WebFrontendTabBar startAnimation();

    WebFrontendTabBar cancelAnimation();
}

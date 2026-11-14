package dev.reuise.web.frontend.menu;
import dev.reuise.core.ComponentAnimation;
import dev.reuise.web.core.menu.WebMenuButton;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
public interface WebFrontendMenuButton extends WebFrontendContainer , WebFrontendMenuButtonPart , WebFrontendComponent , WebMenuButton {
    WebFrontendMenuButton getComponent();

    WebFrontendMenuButton setAnimation(ComponentAnimation animation);

    WebFrontendMenuButton startAnimation();

    WebFrontendMenuButton cancelAnimation();
}

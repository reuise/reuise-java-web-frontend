package dev.reuise.web.frontend.button;
import dev.reuise.core.ComponentAnimation;
import dev.reuise.web.core.button.WebButtonBar;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.layout.WebFrontendFlexContainer;
public interface WebFrontendButtonBar extends WebFrontendFlexContainer , WebFrontendComponent , WebButtonBar , WebFrontendButtonBarPart {
    WebFrontendButtonBar getComponent();

    WebFrontendButtonBar setAnimation(ComponentAnimation animation);

    WebFrontendButtonBar startAnimation();

    WebFrontendButtonBar cancelAnimation();
}

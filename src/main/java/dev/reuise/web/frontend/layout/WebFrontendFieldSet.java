package dev.reuise.web.frontend.layout;
import dev.reuise.core.ComponentAnimation;
import dev.reuise.web.core.layout.WebFieldSet;
import dev.reuise.web.frontend.WebFrontendComponent;
public interface WebFrontendFieldSet extends WebFrontendContainer , WebFieldSet , WebFrontendComponent , WebFrontendFieldSetPart {
    WebFrontendFieldSet getComponent();

    WebFrontendFieldSet setAnimation(ComponentAnimation animation);

    WebFrontendFieldSet startAnimation();

    WebFrontendFieldSet cancelAnimation();
}

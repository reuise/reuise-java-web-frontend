package dev.reuise.web.frontend.text;
import dev.reuise.core.ComponentAnimation;
import dev.reuise.web.core.text.WebHeading;
import dev.reuise.web.frontend.WebFrontendComponent;
public interface WebFrontendHeading extends WebFrontendText , WebFrontendHeadingPart , WebHeading , WebFrontendComponent {
    WebFrontendHeading getComponent();

    WebFrontendHeading setAnimation(ComponentAnimation animation);

    WebFrontendHeading startAnimation();

    WebFrontendHeading cancelAnimation();
}

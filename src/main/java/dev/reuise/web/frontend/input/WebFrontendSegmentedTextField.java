package dev.reuise.web.frontend.input;
import dev.reuise.core.ComponentAnimation;
import dev.reuise.web.core.input.WebSegmentedTextField;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.layout.WebFrontendRowLayout;
public interface WebFrontendSegmentedTextField extends WebFrontendRowLayout , WebFrontendComponent , WebFrontendSegmentedTextFieldPart , WebSegmentedTextField {
    WebFrontendSegmentedTextField getComponent();

    WebFrontendSegmentedTextField setAnimation(ComponentAnimation animation);

    WebFrontendSegmentedTextField startAnimation();

    WebFrontendSegmentedTextField cancelAnimation();
}

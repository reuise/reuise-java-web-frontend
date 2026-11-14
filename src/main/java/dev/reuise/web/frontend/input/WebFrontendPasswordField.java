package dev.reuise.web.frontend.input;
import dev.reuise.web.core.input.WebPasswordField;
import dev.reuise.web.frontend.WebFrontendComponent;
public interface WebFrontendPasswordField extends WebPasswordField , WebFrontendPasswordFieldPart , WebFrontendComponent , WebFrontendTextField {
    WebFrontendPasswordField getComponent();
}

package dev.reuise.web.frontend.input;
import dev.reuise.web.core.input.WebTextField;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponent;
public interface WebFrontendTextField extends WebFrontendTextFieldPart , WebFrontendParentComponent , WebTextField , WebFrontendComponent {
    WebFrontendTextField getComponent();
}

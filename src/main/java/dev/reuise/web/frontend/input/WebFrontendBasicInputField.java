package dev.reuise.web.frontend.input;
import dev.reuise.web.core.input.WebBasicInputField;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponent;
public interface WebFrontendBasicInputField extends WebFrontendBaseComponent , WebFrontendBasicInputFieldPart , WebFrontendComponent , WebBasicInputField {
    WebFrontendBasicInputField getComponent();
}

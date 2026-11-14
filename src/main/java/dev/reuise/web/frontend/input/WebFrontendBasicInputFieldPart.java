package dev.reuise.web.frontend.input;
import dev.reuise.web.core.input.WebBasicInputFieldPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPart;
public interface WebFrontendBasicInputFieldPart extends WebFrontendComponentPart , WebFrontendBasicInputFieldFeatures , WebFrontendBaseComponentPart , WebBasicInputFieldPart {
    WebFrontendBaseComponentPart getBaseComponentPart();
}

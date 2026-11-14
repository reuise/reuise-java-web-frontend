package dev.reuise.web.frontend.input;
import dev.reuise.web.core.input.WebPasswordFieldPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
public interface WebFrontendPasswordFieldPart extends WebFrontendTextFieldPart , WebFrontendComponentPart , WebFrontendPasswordFieldFeatures , WebPasswordFieldPart {
    WebFrontendTextFieldPart getTextFieldPart();
}

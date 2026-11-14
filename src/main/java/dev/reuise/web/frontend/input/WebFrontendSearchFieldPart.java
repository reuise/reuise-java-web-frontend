package dev.reuise.web.frontend.input;
import dev.reuise.web.core.input.WebSearchFieldPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
public interface WebFrontendSearchFieldPart extends WebFrontendTextFieldPart , WebSearchFieldPart , WebFrontendComponentPart , WebFrontendSearchFieldFeatures {
    WebFrontendTextFieldPart getTextFieldPart();
}

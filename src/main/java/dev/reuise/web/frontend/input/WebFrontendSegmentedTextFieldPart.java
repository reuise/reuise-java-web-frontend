package dev.reuise.web.frontend.input;
import dev.reuise.web.core.input.WebSegmentedTextFieldPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.layout.WebFrontendRowLayoutPart;
public interface WebFrontendSegmentedTextFieldPart extends WebFrontendRowLayoutPart , WebFrontendComponentPart , WebSegmentedTextFieldPart , WebFrontendSegmentedTextFieldFeatures {
    WebFrontendRowLayoutPart getRowLayoutPart();
}

package dev.reuise.web.frontend.text;
import dev.reuise.web.core.text.WebInlineTextPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
public interface WebFrontendInlineTextPart extends WebFrontendComponentPart , WebFrontendInlineTextFeatures , WebInlineTextPart , WebFrontendTextPart {
    WebFrontendTextPart getTextPart();
}

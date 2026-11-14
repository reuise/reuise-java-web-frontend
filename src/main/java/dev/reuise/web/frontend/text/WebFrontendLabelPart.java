package dev.reuise.web.frontend.text;
import dev.reuise.web.core.text.WebLabelPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
public interface WebFrontendLabelPart extends WebFrontendComponentPart , WebFrontendLabelFeatures , WebLabelPart , WebFrontendInlineTextPart {
    WebFrontendInlineTextPart getInlineTextPart();
}

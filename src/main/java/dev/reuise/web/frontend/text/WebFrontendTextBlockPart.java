package dev.reuise.web.frontend.text;
import dev.reuise.web.core.text.WebTextBlockPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
public interface WebFrontendTextBlockPart extends WebFrontendComponentPart , WebTextBlockPart , WebFrontendTextPart , WebFrontendTextBlockFeatures {
    WebFrontendTextPart getTextPart();
}

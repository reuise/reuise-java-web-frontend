package dev.reuise.web.frontend.text;
import dev.reuise.web.core.text.WebHeadingPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
public interface WebFrontendHeadingPart extends WebFrontendComponentPart , WebHeadingPart , WebFrontendTextPart , WebFrontendHeadingFeatures {
    WebFrontendTextPart getTextPart();
}

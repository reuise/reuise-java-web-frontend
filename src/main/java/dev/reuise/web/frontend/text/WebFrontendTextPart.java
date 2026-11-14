package dev.reuise.web.frontend.text;
import dev.reuise.web.core.text.WebTextPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
public interface WebFrontendTextPart extends WebTextPart , WebFrontendParentComponentPart , WebFrontendComponentPart , WebFrontendTextFeatures {
    WebFrontendParentComponentPart getParentComponentPart();
}

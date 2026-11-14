package dev.reuise.web.frontend.text;
import dev.reuise.web.core.text.WebRotatingTextPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPart;
public interface WebFrontendRotatingTextPart extends WebFrontendComponentPart , WebFrontendBaseComponentPart , WebRotatingTextPart , WebFrontendRotatingTextFeatures {
    void dispose();

    WebFrontendBaseComponentPart getBaseComponentPart();
}

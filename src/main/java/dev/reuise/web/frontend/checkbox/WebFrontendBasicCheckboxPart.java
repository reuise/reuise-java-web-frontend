package dev.reuise.web.frontend.checkbox;
import dev.reuise.web.core.checkbox.WebBasicCheckboxPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPart;
public interface WebFrontendBasicCheckboxPart extends WebFrontendComponentPart , WebFrontendBaseComponentPart , WebBasicCheckboxPart , WebFrontendBasicCheckboxFeatures {
    WebFrontendBaseComponentPart getBaseComponentPart();
}

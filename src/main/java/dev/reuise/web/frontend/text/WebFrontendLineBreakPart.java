package dev.reuise.web.frontend.text;
import dev.reuise.web.core.text.WebLineBreakPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPart;
public interface WebFrontendLineBreakPart extends WebFrontendComponentPart , WebLineBreakPart , WebFrontendBaseComponentPart , WebFrontendLineBreakFeatures {
    WebFrontendBaseComponentPart getBaseComponentPart();
}

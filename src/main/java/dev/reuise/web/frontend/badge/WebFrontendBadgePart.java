package dev.reuise.web.frontend.badge;
import dev.reuise.web.core.badge.WebBadgePart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPart;
public interface WebFrontendBadgePart extends WebFrontendComponentPart , WebBadgePart , WebFrontendBaseComponentPart , WebFrontendBadgeFeatures {
    WebFrontendBaseComponentPart getBaseComponentPart();
}

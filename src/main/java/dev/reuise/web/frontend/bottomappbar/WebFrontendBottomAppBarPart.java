package dev.reuise.web.frontend.bottomappbar;
import dev.reuise.web.core.bottomappbar.WebBottomAppBarPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPart;
public interface WebFrontendBottomAppBarPart extends WebFrontendComponentPart , WebFrontendBottomAppBarFeatures , WebFrontendBaseComponentPart , WebBottomAppBarPart {
    WebFrontendBaseComponentPart getBaseComponentPart();
}

package dev.reuise.web.frontend.parentcomponent;
import dev.reuise.core.CoreComponent;
import dev.reuise.web.core.parentcomponent.WebParentComponentPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPart;
public interface WebFrontendParentComponentPart extends WebParentComponentPart , WebFrontendComponentPart , WebFrontendParentComponentFeatures , WebFrontendBaseComponentPart {
    WebFrontendParentComponentPart rehydrate(CoreComponent child);

    WebFrontendBaseComponentPart getBaseComponentPart();
}

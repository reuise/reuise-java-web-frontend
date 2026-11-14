package dev.reuise.web.frontend.badge;
import dev.reuise.web.core.badge.WebBadgeOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendBadgeOptions extends WebBadgeOptions , WebFrontendComponentOptions , WebFrontendBaseComponentPartOptions , WebFrontendBaseComponentOptions , WebFrontendBadgePartOptions {
    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}

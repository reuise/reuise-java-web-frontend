package dev.reuise.web.frontend.parentcomponent;
import dev.reuise.web.core.parentcomponent.WebParentComponentOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendParentComponentOptions extends WebFrontendComponentOptions , WebParentComponentOptions , WebFrontendBaseComponentPartOptions , WebFrontendBaseComponentOptions , WebFrontendParentComponentPartOptions {
    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}

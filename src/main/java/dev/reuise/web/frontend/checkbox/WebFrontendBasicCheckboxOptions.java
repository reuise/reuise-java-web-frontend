package dev.reuise.web.frontend.checkbox;
import dev.reuise.web.core.checkbox.WebBasicCheckboxOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendBasicCheckboxOptions extends WebBasicCheckboxOptions , WebFrontendComponentOptions , WebFrontendBaseComponentPartOptions , WebFrontendBaseComponentOptions , WebFrontendBasicCheckboxPartOptions {
    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}

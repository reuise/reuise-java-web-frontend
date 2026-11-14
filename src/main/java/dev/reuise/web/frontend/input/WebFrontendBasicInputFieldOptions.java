package dev.reuise.web.frontend.input;
import dev.reuise.web.core.input.WebBasicInputFieldOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendBasicInputFieldOptions extends WebFrontendComponentOptions , WebBasicInputFieldOptions , WebFrontendBaseComponentPartOptions , WebFrontendBaseComponentOptions , WebFrontendBasicInputFieldPartOptions {
    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}

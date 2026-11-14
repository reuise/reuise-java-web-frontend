package dev.reuise.web.frontend.input;
import dev.reuise.web.core.input.WebPasswordFieldOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendPasswordFieldOptions extends WebFrontendComponentOptions , WebFrontendTextFieldPartOptions , WebFrontendTextFieldOptions , WebFrontendBaseComponentPartOptions , WebPasswordFieldOptions , WebFrontendPasswordFieldPartOptions , WebFrontendParentComponentPartOptions {
    WebFrontendTextFieldPartOptions getTextFieldPart();

    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}

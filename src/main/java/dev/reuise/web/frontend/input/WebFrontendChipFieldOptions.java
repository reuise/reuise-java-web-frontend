package dev.reuise.web.frontend.input;
import dev.reuise.web.core.input.WebChipFieldOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendChipFieldOptions extends WebChipFieldOptions , WebFrontendComponentOptions , WebFrontendTextFieldPartOptions , WebFrontendTextFieldOptions , WebFrontendChipFieldPartOptions , WebFrontendBaseComponentPartOptions , WebFrontendParentComponentPartOptions {
    WebFrontendTextFieldPartOptions getTextFieldPart();

    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}

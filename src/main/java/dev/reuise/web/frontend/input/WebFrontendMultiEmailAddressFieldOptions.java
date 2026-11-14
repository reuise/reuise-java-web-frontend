package dev.reuise.web.frontend.input;
import dev.reuise.web.core.input.WebMultiEmailAddressFieldOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendMultiEmailAddressFieldOptions extends WebFrontendComponentOptions , WebMultiEmailAddressFieldOptions , WebFrontendTextFieldPartOptions , WebFrontendChipFieldOptions , WebFrontendMultiEmailAddressFieldPartOptions , WebFrontendChipFieldPartOptions , WebFrontendBaseComponentPartOptions , WebFrontendParentComponentPartOptions {
    WebFrontendChipFieldPartOptions getChipFieldPart();

    WebFrontendTextFieldPartOptions getTextFieldPart();

    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}

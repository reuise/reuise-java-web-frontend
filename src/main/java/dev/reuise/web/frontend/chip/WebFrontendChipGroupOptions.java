package dev.reuise.web.frontend.chip;
import dev.reuise.web.core.chip.WebChipGroupOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.layout.WebFrontendContainerPartOptions;
import dev.reuise.web.frontend.layout.WebFrontendFieldSetOptions;
import dev.reuise.web.frontend.layout.WebFrontendFieldSetPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendChipGroupOptions extends WebChipGroupOptions , WebFrontendFieldSetOptions , WebFrontendChipGroupPartOptions , WebFrontendComponentOptions , WebFrontendBaseComponentPartOptions , WebFrontendContainerPartOptions , WebFrontendParentComponentPartOptions , WebFrontendFieldSetPartOptions {
    WebFrontendFieldSetPartOptions getFieldSetPart();

    WebFrontendContainerPartOptions getContainerPart();

    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}

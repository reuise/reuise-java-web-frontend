package dev.reuise.web.frontend.chip;
import dev.reuise.web.core.chip.WebFilterChipOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendFilterChipOptions extends WebFrontendComponentOptions , WebFrontendChipPartOptions , WebFrontendChipOptions , WebFilterChipOptions , WebFrontendFilterChipPartOptions , WebFrontendBaseComponentPartOptions , WebFrontendParentComponentPartOptions {
    WebFrontendChipPartOptions getChipPart();

    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}

package dev.reuise.web.frontend.input;
import dev.reuise.web.core.input.WebSegmentedTextFieldOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.layout.WebFrontendContainerPartOptions;
import dev.reuise.web.frontend.layout.WebFrontendFlexContainerPartOptions;
import dev.reuise.web.frontend.layout.WebFrontendRowLayoutOptions;
import dev.reuise.web.frontend.layout.WebFrontendRowLayoutPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendSegmentedTextFieldOptions extends WebSegmentedTextFieldOptions , WebFrontendComponentOptions , WebFrontendRowLayoutPartOptions , WebFrontendRowLayoutOptions , WebFrontendSegmentedTextFieldPartOptions , WebFrontendBaseComponentPartOptions , WebFrontendFlexContainerPartOptions , WebFrontendContainerPartOptions , WebFrontendParentComponentPartOptions {
    WebFrontendRowLayoutPartOptions getRowLayoutPart();

    WebFrontendFlexContainerPartOptions getFlexContainerPart();

    WebFrontendContainerPartOptions getContainerPart();

    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}

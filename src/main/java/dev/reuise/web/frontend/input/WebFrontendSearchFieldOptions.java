package dev.reuise.web.frontend.input;
import dev.reuise.web.core.input.WebSearchFieldOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendSearchFieldOptions extends WebFrontendComponentOptions , WebFrontendSearchFieldPartOptions , WebFrontendTextFieldPartOptions , WebFrontendTextFieldOptions , WebFrontendBaseComponentPartOptions , WebFrontendParentComponentPartOptions , WebSearchFieldOptions {
    WebFrontendTextFieldPartOptions getTextFieldPart();

    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}

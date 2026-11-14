package dev.reuise.web.frontend.text;
import dev.reuise.web.core.text.WebIconLabelOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendIconLabelOptions extends WebFrontendParentComponentOptions , WebFrontendComponentOptions , WebFrontendIconLabelPartOptions , WebFrontendBaseComponentPartOptions , WebFrontendParentComponentPartOptions , WebIconLabelOptions {
    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}

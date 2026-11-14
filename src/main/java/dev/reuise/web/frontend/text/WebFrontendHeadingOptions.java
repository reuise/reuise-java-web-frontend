package dev.reuise.web.frontend.text;
import dev.reuise.web.core.text.WebHeadingOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendHeadingOptions extends WebFrontendComponentOptions , WebFrontendBaseComponentPartOptions , WebFrontendTextPartOptions , WebFrontendTextOptions , WebHeadingOptions , WebFrontendParentComponentPartOptions , WebFrontendHeadingPartOptions {
    WebFrontendTextPartOptions getTextPart();

    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}

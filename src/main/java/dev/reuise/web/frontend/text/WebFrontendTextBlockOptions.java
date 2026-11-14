package dev.reuise.web.frontend.text;
import dev.reuise.web.core.text.WebTextBlockOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendTextBlockOptions extends WebFrontendComponentOptions , WebFrontendTextBlockPartOptions , WebFrontendBaseComponentPartOptions , WebFrontendTextPartOptions , WebFrontendTextOptions , WebTextBlockOptions , WebFrontendParentComponentPartOptions {
    WebFrontendTextPartOptions getTextPart();

    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}

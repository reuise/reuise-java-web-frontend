package dev.reuise.web.frontend.text;
import dev.reuise.web.core.text.WebInlineTextOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendInlineTextOptions extends WebFrontendComponentOptions , WebInlineTextOptions , WebFrontendBaseComponentPartOptions , WebFrontendInlineTextPartOptions , WebFrontendTextPartOptions , WebFrontendTextOptions , WebFrontendParentComponentPartOptions {
    WebFrontendTextPartOptions getTextPart();

    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}

package dev.reuise.web.frontend.text;
import dev.reuise.web.core.text.WebLabelOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendLabelOptions extends WebLabelOptions , WebFrontendInlineTextOptions , WebFrontendComponentOptions , WebFrontendLabelPartOptions , WebFrontendBaseComponentPartOptions , WebFrontendInlineTextPartOptions , WebFrontendTextPartOptions , WebFrontendParentComponentPartOptions {
    WebFrontendInlineTextPartOptions getInlineTextPart();

    WebFrontendTextPartOptions getTextPart();

    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}

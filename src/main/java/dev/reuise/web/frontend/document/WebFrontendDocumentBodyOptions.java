package dev.reuise.web.frontend.document;
import dev.reuise.web.core.document.WebDocumentBodyOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendDocumentBodyOptions extends WebFrontendParentComponentOptions , WebFrontendComponentOptions , WebFrontendDocumentBodyPartOptions , WebFrontendBaseComponentPartOptions , WebDocumentBodyOptions , WebFrontendParentComponentPartOptions {
    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}

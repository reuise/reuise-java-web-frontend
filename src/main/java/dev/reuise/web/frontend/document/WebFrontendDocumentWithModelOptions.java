package dev.reuise.web.frontend.document;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendDocumentWithModelOptions<M> extends WebFrontendComponentOptions , WebFrontendBaseComponentPartOptions , WebFrontendDocumentOptions , WebFrontendDocumentPartOptions , WebFrontendDocumentWithModelPartOptions<M> , WebFrontendParentComponentPartOptions {
    WebFrontendDocumentPartOptions getDocumentPart();

    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}

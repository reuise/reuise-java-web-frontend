package dev.reuise.web.frontend.dropzone;
import dev.reuise.web.core.dropzone.WebDropZoneOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendDropZoneOptions extends WebFrontendDropZonePartOptions , WebFrontendParentComponentOptions , WebFrontendComponentOptions , WebFrontendBaseComponentPartOptions , WebDropZoneOptions , WebFrontendParentComponentPartOptions {
    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}

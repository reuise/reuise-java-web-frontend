package dev.reuise.web.frontend.dropzone;
import dev.reuise.web.core.dropzone.WebDropZone;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponent;
public interface WebFrontendDropZone extends WebDropZone , WebFrontendParentComponent , WebFrontendDropZonePart , WebFrontendComponent {
    WebFrontendDropZone getComponent();
}

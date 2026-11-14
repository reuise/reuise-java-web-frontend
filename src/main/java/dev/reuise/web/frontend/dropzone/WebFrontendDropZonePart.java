package dev.reuise.web.frontend.dropzone;
import dev.reuise.web.core.dropzone.WebDropZonePart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
public interface WebFrontendDropZonePart extends WebFrontendParentComponentPart , WebFrontendComponentPart , WebDropZonePart , WebFrontendDropZoneFeatures {
    WebFrontendParentComponentPart getParentComponentPart();
}

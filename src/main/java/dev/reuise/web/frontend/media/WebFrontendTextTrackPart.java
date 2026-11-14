package dev.reuise.web.frontend.media;
import dev.reuise.web.core.media.WebTextTrackPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
public interface WebFrontendTextTrackPart extends WebFrontendParentComponentPart , WebFrontendComponentPart , WebTextTrackPart , WebFrontendTextTrackFeatures {
    WebFrontendParentComponentPart getParentComponentPart();
}

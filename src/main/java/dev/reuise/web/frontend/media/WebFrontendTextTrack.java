package dev.reuise.web.frontend.media;
import dev.reuise.web.core.media.WebTextTrack;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponent;
public interface WebFrontendTextTrack extends WebFrontendParentComponent , WebTextTrack , WebFrontendComponent , WebFrontendTextTrackPart {
    WebFrontendTextTrack getComponent();
}

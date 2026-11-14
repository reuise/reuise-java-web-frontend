package dev.reuise.web.frontend.media;
import dev.reuise.web.core.media.WebVideoPlayerPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
public interface WebFrontendVideoPlayerPart extends WebVideoPlayerPart , WebFrontendComponentPart , WebFrontendMediaPlayerPart , WebFrontendVideoPlayerFeatures {
    WebFrontendMediaPlayerPart getMediaPlayerPart();
}

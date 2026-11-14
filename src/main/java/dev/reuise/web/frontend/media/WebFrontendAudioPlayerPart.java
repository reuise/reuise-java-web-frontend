package dev.reuise.web.frontend.media;
import dev.reuise.web.core.media.WebAudioPlayerPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
public interface WebFrontendAudioPlayerPart extends WebFrontendComponentPart , WebFrontendMediaPlayerPart , WebAudioPlayerPart , WebFrontendAudioPlayerFeatures {
    WebFrontendMediaPlayerPart getMediaPlayerPart();
}

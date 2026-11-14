package dev.reuise.web.frontend.media;
import dev.reuise.web.core.media.WebMediaPlayerPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
public interface WebFrontendMediaPlayerPart extends WebFrontendParentComponentPart , WebFrontendComponentPart , WebFrontendMediaPlayerFeatures , WebMediaPlayerPart {
    void load();

    void stop();

    void play();

    void pause();

    WebFrontendParentComponentPart getParentComponentPart();
}

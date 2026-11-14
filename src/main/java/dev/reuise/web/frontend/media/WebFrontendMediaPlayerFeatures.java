package dev.reuise.web.frontend.media;
import dev.reuise.web.core.media.WebMediaPlayerFeatures;
public interface WebFrontendMediaPlayerFeatures extends WebMediaPlayerFeatures {
    Double getCurrentTime();

    WebFrontendMediaPlayerFeatures setCurrentTime(Double currentTime);

    boolean isPaused();

    WebFrontendMediaPlayerFeatures setPaused(Boolean paused);

    Double getDuration();

    WebFrontendMediaPlayerFeatures setDuration(Double duration);
}

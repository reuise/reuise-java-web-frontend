package dev.reuise.web.frontend.media;
import dev.reuise.web.core.media.WebVideoPlayer;
import dev.reuise.web.frontend.WebFrontendComponent;
public interface WebFrontendVideoPlayer extends WebFrontendMediaPlayer , WebFrontendComponent , WebVideoPlayer , WebFrontendVideoPlayerPart {
    WebFrontendVideoPlayer getComponent();
}

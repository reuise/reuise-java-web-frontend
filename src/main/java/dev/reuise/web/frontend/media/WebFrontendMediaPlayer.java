package dev.reuise.web.frontend.media;
import dev.reuise.web.core.media.WebMediaPlayer;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponent;
public interface WebFrontendMediaPlayer extends WebFrontendParentComponent , WebFrontendMediaPlayerPart , WebMediaPlayer , WebFrontendComponent {
    WebFrontendMediaPlayer getComponent();
}

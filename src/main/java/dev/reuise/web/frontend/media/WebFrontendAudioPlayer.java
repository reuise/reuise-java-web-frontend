package dev.reuise.web.frontend.media;
import dev.reuise.web.core.media.WebAudioPlayer;
import dev.reuise.web.frontend.WebFrontendComponent;
public interface WebFrontendAudioPlayer extends WebFrontendMediaPlayer , WebFrontendAudioPlayerPart , WebAudioPlayer , WebFrontendComponent {
    WebFrontendAudioPlayer getComponent();
}

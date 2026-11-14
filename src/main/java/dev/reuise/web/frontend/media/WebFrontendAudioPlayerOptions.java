package dev.reuise.web.frontend.media;
import dev.reuise.web.core.media.WebAudioPlayerOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendAudioPlayerOptions extends WebAudioPlayerOptions , WebFrontendComponentOptions , WebFrontendBaseComponentPartOptions , WebFrontendMediaPlayerPartOptions , WebFrontendMediaPlayerOptions , WebFrontendAudioPlayerPartOptions , WebFrontendParentComponentPartOptions {
    WebFrontendMediaPlayerPartOptions getMediaPlayerPart();

    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}

package dev.reuise.web.frontend.media;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.web.core.media.WebAudioPlayerPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
public interface WebFrontendAudioPlayerPartOptions extends WebAudioPlayerPartOptions {
    WebFrontendMediaPlayerPartOptions getMediaPlayerPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendAudioPlayer getComponent();
}

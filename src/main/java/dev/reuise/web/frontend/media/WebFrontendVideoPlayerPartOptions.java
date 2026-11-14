package dev.reuise.web.frontend.media;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.web.core.media.WebVideoPlayerPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
public interface WebFrontendVideoPlayerPartOptions extends WebVideoPlayerPartOptions {
    WebFrontendMediaPlayerPartOptions getMediaPlayerPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendVideoPlayer getComponent();
}

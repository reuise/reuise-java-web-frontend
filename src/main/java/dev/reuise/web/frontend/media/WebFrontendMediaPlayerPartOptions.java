package dev.reuise.web.frontend.media;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.core.option.ComponentOption;
import dev.reuise.web.core.media.WebMediaPlayerPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
public interface WebFrontendMediaPlayerPartOptions extends WebMediaPlayerPartOptions {
    WebFrontendParentComponentPartOptions getParentComponentPart();

    Double getCurrentTime();

    ComponentOption<Double> getCurrentTimeOption();

    WebFrontendMediaPlayerPartOptions setCurrentTime(Double currentTime);

    boolean isPaused();

    ComponentOption<Boolean> getPausedOption();

    WebFrontendMediaPlayerPartOptions setPaused(Boolean paused);

    Double getDuration();

    ComponentOption<Double> getDurationOption();

    WebFrontendMediaPlayerPartOptions setDuration(Double duration);

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendMediaPlayer getComponent();
}

package dev.reuise.web.frontend.avatar;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.core.option.ComponentCreator;
import dev.reuise.web.core.avatar.WebAvatarPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.badge.WebFrontendBadge;
import dev.reuise.web.frontend.badge.WebFrontendBadgeOptions;
import dev.reuise.web.frontend.image.WebFrontendImage;
import dev.reuise.web.frontend.image.WebFrontendImageOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
public interface WebFrontendAvatarPartOptions extends WebAvatarPartOptions {
    WebFrontendParentComponentPartOptions getParentComponentPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    WebFrontendAvatarPartOptions setImageCreator(ComponentCreator<? extends WebFrontendImage, ? extends WebFrontendImageOptions> imageCreator);

    WebFrontendAvatarPartOptions setBadgeCreator(ComponentCreator<? extends WebFrontendBadge, ? extends WebFrontendBadgeOptions> badgeCreator);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendAvatar getComponent();
}

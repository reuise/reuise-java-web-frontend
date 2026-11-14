package dev.reuise.web.frontend.tabs;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.core.option.ComponentCreator;
import dev.reuise.web.core.tabs.WebTabPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.badge.WebFrontendBadge;
import dev.reuise.web.frontend.badge.WebFrontendBadgeOptions;
import dev.reuise.web.frontend.icon.WebFrontendIcon;
import dev.reuise.web.frontend.icon.WebFrontendIconOptions;
import dev.reuise.web.frontend.link.WebFrontendLink;
import dev.reuise.web.frontend.link.WebFrontendLinkOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
import dev.reuise.web.frontend.text.WebFrontendInlineText;
import dev.reuise.web.frontend.text.WebFrontendInlineTextOptions;
public interface WebFrontendTabPartOptions extends WebTabPartOptions {
    WebFrontendParentComponentPartOptions getParentComponentPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    WebFrontendTabPartOptions setLinkCreator(ComponentCreator<? extends WebFrontendLink, ? extends WebFrontendLinkOptions> linkCreator);

    WebFrontendTabPartOptions setBadgeCreator(ComponentCreator<? extends WebFrontendBadge, ? extends WebFrontendBadgeOptions> badgeCreator);

    WebFrontendTabPartOptions setIconCreator(ComponentCreator<? extends WebFrontendIcon, ? extends WebFrontendIconOptions> iconCreator);

    WebFrontendTabPartOptions setLabelContainerCreator(ComponentCreator<? extends WebFrontendInlineText, ? extends WebFrontendInlineTextOptions> labelContainerCreator);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendTab getComponent();
}

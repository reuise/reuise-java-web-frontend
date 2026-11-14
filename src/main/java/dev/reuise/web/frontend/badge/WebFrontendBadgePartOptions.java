package dev.reuise.web.frontend.badge;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.web.core.badge.WebBadgePartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
public interface WebFrontendBadgePartOptions extends WebBadgePartOptions {
    WebFrontendBaseComponentPartOptions getBaseComponentPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendBadge getComponent();
}

package dev.reuise.web.frontend.link;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.web.core.link.WebNavigationLinkPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
public interface WebFrontendNavigationLinkPartOptions extends WebNavigationLinkPartOptions {
    WebFrontendLinkPartOptions getLinkPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendNavigationLink getComponent();
}

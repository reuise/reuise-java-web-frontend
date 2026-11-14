package dev.reuise.web.frontend.navigation;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.core.option.ComponentCreator;
import dev.reuise.web.core.navigation.WebNavigationTreeLinkPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.link.WebFrontendNavigationLinkPartOptions;
import dev.reuise.web.frontend.list.WebFrontendListItem;
import dev.reuise.web.frontend.list.WebFrontendListItemOptions;
public interface WebFrontendNavigationTreeLinkPartOptions extends WebNavigationTreeLinkPartOptions {
    WebFrontendNavigationLinkPartOptions getNavigationLinkPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    WebFrontendNavigationTreeLinkPartOptions setItemCreator(ComponentCreator<? extends WebFrontendListItem, ? extends WebFrontendListItemOptions> itemCreator);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendNavigationTreeLink getComponent();
}

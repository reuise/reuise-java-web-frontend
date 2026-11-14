package dev.reuise.web.frontend.menu;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.web.core.menu.WebMenuItemPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.list.WebFrontendListItemPartOptions;
public interface WebFrontendMenuItemPartOptions extends WebMenuItemPartOptions {
    WebFrontendListItemPartOptions getListItemPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendMenuItem getComponent();
}

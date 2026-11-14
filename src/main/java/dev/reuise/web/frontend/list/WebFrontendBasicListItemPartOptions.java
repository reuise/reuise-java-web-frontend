package dev.reuise.web.frontend.list;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.core.option.ComponentCreator;
import dev.reuise.web.core.list.WebBasicListItemPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.link.WebFrontendLink;
import dev.reuise.web.frontend.link.WebFrontendLinkOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
public interface WebFrontendBasicListItemPartOptions extends WebBasicListItemPartOptions {
    WebFrontendParentComponentPartOptions getParentComponentPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    WebFrontendBasicListItemPartOptions setLinkCreator(ComponentCreator<? extends WebFrontendLink, ? extends WebFrontendLinkOptions> linkCreator);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendBasicListItem getComponent();
}

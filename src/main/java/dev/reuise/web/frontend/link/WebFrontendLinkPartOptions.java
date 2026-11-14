package dev.reuise.web.frontend.link;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.core.option.ComponentCreator;
import dev.reuise.web.core.link.WebLinkPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.icon.WebFrontendIcon;
import dev.reuise.web.frontend.icon.WebFrontendIconOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
public interface WebFrontendLinkPartOptions extends WebLinkPartOptions {
    WebFrontendParentComponentPartOptions getParentComponentPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    WebFrontendLinkPartOptions setStartIconCreator(ComponentCreator<? extends WebFrontendIcon, ? extends WebFrontendIconOptions> startIconCreator);

    WebFrontendLinkPartOptions setEndIconCreator(ComponentCreator<? extends WebFrontendIcon, ? extends WebFrontendIconOptions> endIconCreator);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendLink getComponent();
}

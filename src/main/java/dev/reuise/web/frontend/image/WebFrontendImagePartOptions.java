package dev.reuise.web.frontend.image;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.core.option.ComponentCreator;
import dev.reuise.web.core.image.WebImagePartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.link.WebFrontendLink;
import dev.reuise.web.frontend.link.WebFrontendLinkOptions;
public interface WebFrontendImagePartOptions extends WebImagePartOptions {
    WebFrontendBaseComponentPartOptions getBaseComponentPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    WebFrontendImagePartOptions setLinkCreator(ComponentCreator<? extends WebFrontendLink, ? extends WebFrontendLinkOptions> linkCreator);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendImage getComponent();
}

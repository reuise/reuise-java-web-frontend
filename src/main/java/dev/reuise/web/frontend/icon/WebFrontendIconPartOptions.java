package dev.reuise.web.frontend.icon;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.core.option.ComponentCreator;
import dev.reuise.web.core.icon.WebIconPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.graphics.svg.WebFrontendSvg;
import dev.reuise.web.frontend.graphics.svg.WebFrontendSvgOptions;
import dev.reuise.web.frontend.image.WebFrontendImage;
import dev.reuise.web.frontend.image.WebFrontendImageOptions;
import dev.reuise.web.frontend.link.WebFrontendLink;
import dev.reuise.web.frontend.link.WebFrontendLinkOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
public interface WebFrontendIconPartOptions extends WebIconPartOptions {
    WebFrontendParentComponentPartOptions getParentComponentPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    WebFrontendIconPartOptions setSvgCreator(ComponentCreator<? extends WebFrontendSvg, ? extends WebFrontendSvgOptions> svgCreator);

    WebFrontendIconPartOptions setLinkCreator(ComponentCreator<? extends WebFrontendLink, ? extends WebFrontendLinkOptions> linkCreator);

    WebFrontendIconPartOptions setImageCreator(ComponentCreator<? extends WebFrontendImage, ? extends WebFrontendImageOptions> imageCreator);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendIcon getComponent();
}

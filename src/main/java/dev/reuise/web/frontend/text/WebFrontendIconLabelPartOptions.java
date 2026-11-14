package dev.reuise.web.frontend.text;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.core.option.ComponentCreator;
import dev.reuise.web.core.text.WebIconLabelPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.icon.WebFrontendIcon;
import dev.reuise.web.frontend.icon.WebFrontendIconOptions;
import dev.reuise.web.frontend.link.WebFrontendLink;
import dev.reuise.web.frontend.link.WebFrontendLinkOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
public interface WebFrontendIconLabelPartOptions extends WebIconLabelPartOptions {
    WebFrontendParentComponentPartOptions getParentComponentPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    WebFrontendIconLabelPartOptions setLinkCreator(ComponentCreator<? extends WebFrontendLink, ? extends WebFrontendLinkOptions> linkCreator);

    WebFrontendIconLabelPartOptions setStartIconCreator(ComponentCreator<? extends WebFrontendIcon, ? extends WebFrontendIconOptions> startIconCreator);

    WebFrontendIconLabelPartOptions setLabelContainerCreator(ComponentCreator<? extends WebFrontendInlineText, ? extends WebFrontendInlineTextOptions> labelContainerCreator);

    WebFrontendIconLabelPartOptions setEndIconCreator(ComponentCreator<? extends WebFrontendIcon, ? extends WebFrontendIconOptions> endIconCreator);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendIconLabel getComponent();
}

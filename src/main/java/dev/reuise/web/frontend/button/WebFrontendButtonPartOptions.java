package dev.reuise.web.frontend.button;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.core.option.ComponentCreator;
import dev.reuise.web.core.button.WebButtonPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.icon.WebFrontendIcon;
import dev.reuise.web.frontend.icon.WebFrontendIconOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
import dev.reuise.web.frontend.text.WebFrontendInlineText;
import dev.reuise.web.frontend.text.WebFrontendInlineTextOptions;
public interface WebFrontendButtonPartOptions extends WebButtonPartOptions {
    WebFrontendParentComponentPartOptions getParentComponentPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    WebFrontendButtonPartOptions setStartIconCreator(ComponentCreator<? extends WebFrontendIcon, ? extends WebFrontendIconOptions> startIconCreator);

    WebFrontendButtonPartOptions setLabelContainerCreator(ComponentCreator<? extends WebFrontendInlineText, ? extends WebFrontendInlineTextOptions> labelContainerCreator);

    WebFrontendButtonPartOptions setEndIconCreator(ComponentCreator<? extends WebFrontendIcon, ? extends WebFrontendIconOptions> endIconCreator);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendButton getComponent();
}

package dev.reuise.web.frontend.divider;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.core.option.ComponentCreator;
import dev.reuise.web.core.divider.WebDividerPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
import dev.reuise.web.frontend.layout.WebFrontendContainerOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
import dev.reuise.web.frontend.text.WebFrontendInlineText;
import dev.reuise.web.frontend.text.WebFrontendInlineTextOptions;
public interface WebFrontendDividerPartOptions extends WebDividerPartOptions {
    WebFrontendParentComponentPartOptions getParentComponentPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    WebFrontendDividerPartOptions setStartLineCreator(ComponentCreator<? extends WebFrontendContainer, ? extends WebFrontendContainerOptions> startLineCreator);

    WebFrontendDividerPartOptions setLabelContainerCreator(ComponentCreator<? extends WebFrontendInlineText, ? extends WebFrontendInlineTextOptions> labelContainerCreator);

    WebFrontendDividerPartOptions setEndLineCreator(ComponentCreator<? extends WebFrontendContainer, ? extends WebFrontendContainerOptions> endLineCreator);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendDivider getComponent();
}

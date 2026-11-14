package dev.reuise.web.frontend.list;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.core.option.ComponentCreator;
import dev.reuise.web.core.list.WebListItemPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.checkbox.WebFrontendCheckbox;
import dev.reuise.web.frontend.checkbox.WebFrontendCheckboxOptions;
import dev.reuise.web.frontend.icon.WebFrontendIcon;
import dev.reuise.web.frontend.icon.WebFrontendIconOptions;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
import dev.reuise.web.frontend.layout.WebFrontendContainerOptions;
import dev.reuise.web.frontend.text.WebFrontendInlineText;
import dev.reuise.web.frontend.text.WebFrontendInlineTextOptions;
public interface WebFrontendListItemPartOptions extends WebListItemPartOptions {
    WebFrontendBasicListItemPartOptions getBasicListItemPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    WebFrontendListItemPartOptions setCheckboxCreator(ComponentCreator<? extends WebFrontendCheckbox, ? extends WebFrontendCheckboxOptions> checkboxCreator);

    WebFrontendListItemPartOptions setStartIconCreator(ComponentCreator<? extends WebFrontendIcon, ? extends WebFrontendIconOptions> startIconCreator);

    WebFrontendListItemPartOptions setTextContainerCreator(ComponentCreator<? extends WebFrontendContainer, ? extends WebFrontendContainerOptions> textContainerCreator);

    WebFrontendListItemPartOptions setLabelContainerCreator(ComponentCreator<? extends WebFrontendInlineText, ? extends WebFrontendInlineTextOptions> labelContainerCreator);

    WebFrontendListItemPartOptions setSecondaryLabelContainerCreator(ComponentCreator<? extends WebFrontendInlineText, ? extends WebFrontendInlineTextOptions> secondaryLabelContainerCreator);

    WebFrontendListItemPartOptions setEndIconCreator(ComponentCreator<? extends WebFrontendIcon, ? extends WebFrontendIconOptions> endIconCreator);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendListItem getComponent();
}

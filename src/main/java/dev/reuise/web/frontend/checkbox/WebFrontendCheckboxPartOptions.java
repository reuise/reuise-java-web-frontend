package dev.reuise.web.frontend.checkbox;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.core.checkbox.CheckboxSize;
import dev.reuise.core.option.ComponentCreator;
import dev.reuise.web.core.checkbox.WebCheckboxPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
import dev.reuise.web.frontend.text.WebFrontendLabel;
import dev.reuise.web.frontend.text.WebFrontendLabelOptions;
// Size here??
public interface WebFrontendCheckboxPartOptions extends WebCheckboxPartOptions {
    WebFrontendParentComponentPartOptions getParentComponentPart();

    CheckboxSize getSize();

    WebFrontendCheckboxPartOptions setSize(CheckboxSize size);

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    WebFrontendCheckboxPartOptions setCheckboxCreator(ComponentCreator<? extends WebFrontendBasicCheckbox, ? extends WebFrontendBasicCheckboxOptions> checkboxCreator);

    WebFrontendCheckboxPartOptions setLabelContainerCreator(ComponentCreator<? extends WebFrontendLabel, ? extends WebFrontendLabelOptions> labelContainerCreator);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendCheckbox getComponent();
}

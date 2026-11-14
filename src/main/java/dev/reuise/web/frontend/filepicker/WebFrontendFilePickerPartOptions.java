package dev.reuise.web.frontend.filepicker;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.web.core.filepicker.WebFilePickerPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
public interface WebFrontendFilePickerPartOptions extends WebFilePickerPartOptions {
    WebFrontendBaseComponentPartOptions getBaseComponentPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendFilePicker getComponent();
}

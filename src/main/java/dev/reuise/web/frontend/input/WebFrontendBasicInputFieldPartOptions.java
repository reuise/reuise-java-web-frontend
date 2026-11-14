package dev.reuise.web.frontend.input;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.web.core.input.WebBasicInputFieldPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
public interface WebFrontendBasicInputFieldPartOptions extends WebBasicInputFieldPartOptions {
    WebFrontendBaseComponentPartOptions getBaseComponentPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendBasicInputField getComponent();
}

package dev.reuise.web.frontend.basecomponent;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.core.option.ComponentOption;
import dev.reuise.web.core.basecomponent.WebBaseComponentPartOptions;
import dev.reuise.web.frontend.ElementDataParser;
import dev.reuise.web.frontend.ElementProvider;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
public interface WebFrontendBaseComponentPartOptions extends WebBaseComponentPartOptions {
    ElementProvider getElementProvider();

    ComponentOption<ElementProvider> getElementProviderOption();

    WebFrontendBaseComponentPartOptions setElementProvider(ElementProvider elementProvider);

    ElementDataParser getElementDataParser();

    ComponentOption<ElementDataParser> getElementDataParserOption();

    WebFrontendBaseComponentPartOptions setElementDataParser(ElementDataParser elementDataParser);

    boolean isResizeEventsEnabled();

    ComponentOption<Boolean> getResizeEventsEnabledOption();

    WebFrontendBaseComponentPartOptions setResizeEventsEnabled(Boolean resizeEventsEnabled);

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    WebFrontendBaseComponentPartOptions setRehydration(Element element);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendBaseComponent getComponent();
}

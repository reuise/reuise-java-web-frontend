package dev.reuise.web.frontend.basecomponent;
import akasha.Element;
import dev.reuise.web.core.basecomponent.WebBaseComponentFeatures;
import dev.reuise.web.frontend.ElementDataParser;
import dev.reuise.web.frontend.ElementProvider;
public interface WebFrontendBaseComponentFeatures extends WebBaseComponentFeatures {
    ElementProvider getElementProvider();

    WebFrontendBaseComponentFeatures setElementProvider(ElementProvider elementProvider);

    ElementDataParser getElementDataParser();

    WebFrontendBaseComponentFeatures setElementDataParser(ElementDataParser elementDataParser);

    boolean isResizeEventsEnabled();

    WebFrontendBaseComponentFeatures setResizeEventsEnabled(Boolean resizeEventsEnabled);

    WebFrontendBaseComponentFeatures setRehydration(Element element);
}

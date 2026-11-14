package dev.reuise.web.frontend.basecomponent;
import akasha.Element;
import akasha.EventListener;
import akasha.HTMLElement;
import dev.reuise.core.Rect;
import dev.reuise.core.event.EventType;
import dev.reuise.web.core.basecomponent.WebBaseComponentPart;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import java.util.Set;
public interface WebFrontendBaseComponentPart extends WebFrontendComponentPart , WebFrontendBaseComponentFeatures , WebBaseComponentPart {
    Element getElement();

    HTMLElement getHtmlElement();

    Rect getBoundingBox();

    HTMLElement createOrRehydrateElement(String tagName, String selector);

    WebFrontendBaseComponentPart on(EventType type, EventListener listener);

    WebFrontendBaseComponentPart on(Set<EventType> types, EventListener listener);

    void dispatchEvent(EventType type);

    void click();

    WebFrontendComponentFactory getComponentFactory();
}

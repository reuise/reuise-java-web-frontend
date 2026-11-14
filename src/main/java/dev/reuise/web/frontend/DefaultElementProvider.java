package dev.reuise.web.frontend;

import dev.reuise.web.frontend.basecomponent.RehydrationFailedException;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentOptions;
import akasha.Element;
import akasha.WindowGlobal;

public class DefaultElementProvider implements ElementProvider {
    private String selector;
    private Element parent;

    public DefaultElementProvider() {
    }

    public DefaultElementProvider(String selector, Element parent) {
        this.selector = selector;
        this.parent = parent;
    }

    public DefaultElementProvider(String selector) {
        this(selector, null);
    }

    @Override
    public Element getElement(WebFrontendComponentOptions options) throws RehydrationFailedException {
        if(selector == null) {
            String xmlNamespace = options.getXmlNamespace();
            if(xmlNamespace != null && !xmlNamespace.isEmpty()) return WindowGlobal.document().createElementNS(xmlNamespace, options.getTagName());
            return WindowGlobal.document().createElement(options.getTagName());
        }

        Element el = null;
        if(parent != null) {
            el = parent.querySelector(":scope > "+selector);
            if(el == null) el = parent.querySelector(":scope "+selector);   //todo: replace with bfs
        }
        else el = WindowGlobal.document().body.querySelector(selector);

        if(el == null && options.isRequiredLayoutComponent()) throw new RehydrationFailedException(selector, parent);
        return el;
    }

    public String getSelector() {
        return selector;
    }

    public void setSelector(String selector) {
        this.selector = selector;
    }
    
    public Element getParent() {
        return parent;
    }

    public void setParent(Element parent) {
        this.parent = parent;
    }    
}

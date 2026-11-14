package dev.reuise.web.frontend.basecomponent;

import akasha.Element;
import akasha.HTMLElement;

public class RehydrationFailedException extends Exception {
    private String selector;
    private Element parent;

    public RehydrationFailedException(String selector, Element parent) {
        super("Failed to rehydrate component with query \""+selector+"\" in "+(parent != null ? parent.toString() : "body")+".");
        this.selector = selector;
        this.parent = parent;
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

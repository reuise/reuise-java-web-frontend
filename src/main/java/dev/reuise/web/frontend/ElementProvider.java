package dev.reuise.web.frontend;

import dev.reuise.web.frontend.basecomponent.RehydrationFailedException;
import akasha.Element;

public interface ElementProvider {
    public Element getElement(WebFrontendComponentOptions options) throws RehydrationFailedException;
}

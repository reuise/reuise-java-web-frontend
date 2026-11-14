package dev.reuise.web.frontend.graphics.svg;
import dev.reuise.web.core.graphics.svg.WebSvgPath;
import dev.reuise.web.frontend.WebFrontendComponent;
public interface WebFrontendSvgPath extends WebFrontendSvgPathPart , WebSvgPath , WebFrontendComponent , WebFrontendSvgShape {
    WebFrontendSvgPath getComponent();
}

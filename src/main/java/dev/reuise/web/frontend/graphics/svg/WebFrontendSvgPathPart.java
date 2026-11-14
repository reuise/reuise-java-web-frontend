package dev.reuise.web.frontend.graphics.svg;
import dev.reuise.web.core.graphics.svg.WebSvgPathPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
public interface WebFrontendSvgPathPart extends WebFrontendComponentPart , WebSvgPathPart , WebFrontendSvgPathFeatures , WebFrontendSvgShapePart {
    WebFrontendSvgShapePart getSvgShapePart();
}

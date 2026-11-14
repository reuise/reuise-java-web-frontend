package dev.reuise.web.frontend.graphics.svg;
import dev.reuise.web.core.graphics.svg.WebSvgRectPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
public interface WebFrontendSvgRectPart extends WebFrontendComponentPart , WebFrontendSvgRectFeatures , WebSvgRectPart , WebFrontendSvgShapePart {
    WebFrontendSvgShapePart getSvgShapePart();
}

package dev.reuise.web.frontend.graphics.svg;
import dev.reuise.web.core.graphics.svg.WebSvgShapePart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
public interface WebFrontendSvgShapePart extends WebFrontendComponentPart , WebFrontendSvgPart , WebFrontendSvgShapeFeatures , WebSvgShapePart {
    WebFrontendSvgPart getSvgPart();
}

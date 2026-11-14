package dev.reuise.web.frontend.graphics.svg;
import dev.reuise.web.core.graphics.svg.WebSvgRectOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendSvgRectOptions extends WebSvgRectOptions , WebFrontendSvgShapeOptions , WebFrontendComponentOptions , WebFrontendSvgRectPartOptions , WebFrontendSvgShapePartOptions , WebFrontendBaseComponentPartOptions , WebFrontendParentComponentPartOptions , WebFrontendSvgPartOptions {
    WebFrontendSvgShapePartOptions getSvgShapePart();

    WebFrontendSvgPartOptions getSvgPart();

    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}

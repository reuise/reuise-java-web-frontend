package dev.reuise.web.frontend.graphics.svg;
import dev.reuise.web.core.graphics.svg.WebSvgShape;
import dev.reuise.web.frontend.WebFrontendComponent;
public interface WebFrontendSvgShape extends WebSvgShape , WebFrontendSvg , WebFrontendComponent , WebFrontendSvgShapePart {
    WebFrontendSvgShape getComponent();
}

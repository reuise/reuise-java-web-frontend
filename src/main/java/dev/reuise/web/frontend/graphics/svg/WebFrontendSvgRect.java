package dev.reuise.web.frontend.graphics.svg;
import dev.reuise.web.core.graphics.svg.WebSvgRect;
import dev.reuise.web.frontend.WebFrontendComponent;
public interface WebFrontendSvgRect extends WebFrontendSvgRectPart , WebSvgRect , WebFrontendComponent , WebFrontendSvgShape {
    WebFrontendSvgRect getComponent();
}

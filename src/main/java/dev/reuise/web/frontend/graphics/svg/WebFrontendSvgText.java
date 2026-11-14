package dev.reuise.web.frontend.graphics.svg;
import dev.reuise.web.core.graphics.svg.WebSvgText;
import dev.reuise.web.frontend.WebFrontendComponent;
public interface WebFrontendSvgText extends WebFrontendSvgTextPart , WebFrontendSvg , WebSvgText , WebFrontendComponent {
    WebFrontendSvgText getComponent();
}

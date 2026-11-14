package dev.reuise.web.frontend.graphics.svg;
import dev.reuise.web.core.graphics.svg.WebSvg;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponent;
public interface WebFrontendSvg extends WebSvg , WebFrontendParentComponent , WebFrontendSvgPart , WebFrontendComponent {
    WebFrontendSvg getComponent();
}

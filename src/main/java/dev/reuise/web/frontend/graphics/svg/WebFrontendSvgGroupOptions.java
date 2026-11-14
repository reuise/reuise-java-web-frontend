package dev.reuise.web.frontend.graphics.svg;
import dev.reuise.web.core.graphics.svg.WebSvgGroupOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendSvgGroupOptions extends WebFrontendComponentOptions , WebFrontendSvgOptions , WebSvgGroupOptions , WebFrontendBaseComponentPartOptions , WebFrontendSvgGroupPartOptions , WebFrontendParentComponentPartOptions , WebFrontendSvgPartOptions {
    WebFrontendSvgPartOptions getSvgPart();

    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}

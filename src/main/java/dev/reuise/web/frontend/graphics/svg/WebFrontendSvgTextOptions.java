package dev.reuise.web.frontend.graphics.svg;
import dev.reuise.web.core.graphics.svg.WebSvgTextOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendSvgTextOptions extends WebFrontendComponentOptions , WebFrontendSvgOptions , WebSvgTextOptions , WebFrontendBaseComponentPartOptions , WebFrontendSvgTextPartOptions , WebFrontendParentComponentPartOptions , WebFrontendSvgPartOptions {
    WebFrontendSvgPartOptions getSvgPart();

    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}

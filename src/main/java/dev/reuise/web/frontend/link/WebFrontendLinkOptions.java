package dev.reuise.web.frontend.link;
import dev.reuise.web.core.link.WebLinkOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendLinkOptions extends WebFrontendParentComponentOptions , WebFrontendComponentOptions , WebFrontendBaseComponentPartOptions , WebFrontendLinkPartOptions , WebFrontendParentComponentPartOptions , WebLinkOptions {
    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}

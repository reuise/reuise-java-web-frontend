package dev.reuise.web.frontend.link;
import dev.reuise.web.core.link.WebNavigationLinkOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendNavigationLinkOptions extends WebFrontendComponentOptions , WebFrontendNavigationLinkPartOptions , WebFrontendLinkOptions , WebFrontendBaseComponentPartOptions , WebNavigationLinkOptions , WebFrontendLinkPartOptions , WebFrontendParentComponentPartOptions {
    WebFrontendLinkPartOptions getLinkPart();

    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}

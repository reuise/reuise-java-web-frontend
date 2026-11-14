package dev.reuise.web.frontend.navigation;
import dev.reuise.web.core.navigation.WebNavigationTreeLinkOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.link.WebFrontendLinkPartOptions;
import dev.reuise.web.frontend.link.WebFrontendNavigationLinkOptions;
import dev.reuise.web.frontend.link.WebFrontendNavigationLinkPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendNavigationTreeLinkOptions extends WebFrontendComponentOptions , WebNavigationTreeLinkOptions , WebFrontendNavigationTreeLinkPartOptions , WebFrontendNavigationLinkPartOptions , WebFrontendBaseComponentPartOptions , WebFrontendLinkPartOptions , WebFrontendNavigationLinkOptions , WebFrontendParentComponentPartOptions {
    WebFrontendNavigationLinkPartOptions getNavigationLinkPart();

    WebFrontendLinkPartOptions getLinkPart();

    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}

package dev.reuise.web.frontend.avatar;
import dev.reuise.web.core.avatar.WebAvatarOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendAvatarOptions extends WebFrontendParentComponentOptions , WebFrontendComponentOptions , WebFrontendAvatarPartOptions , WebFrontendBaseComponentPartOptions , WebAvatarOptions , WebFrontendParentComponentPartOptions {
    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}

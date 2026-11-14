package dev.reuise.web.frontend.avatar;
import dev.reuise.web.core.avatar.WebAvatar;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponent;
public interface WebFrontendAvatar extends WebFrontendParentComponent , WebFrontendAvatarPart , WebAvatar , WebFrontendComponent {
    WebFrontendAvatar getComponent();
}

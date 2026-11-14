package dev.reuise.web.frontend.avatar;
import dev.reuise.web.core.avatar.WebAvatarPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.badge.WebFrontendBadge;
import dev.reuise.web.frontend.image.WebFrontendImage;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
public interface WebFrontendAvatarPart extends WebFrontendParentComponentPart , WebFrontendComponentPart , WebFrontendAvatarFeatures , WebAvatarPart {
    WebFrontendImage getImage();

    WebFrontendBadge getBadge();

    WebFrontendParentComponentPart getParentComponentPart();
}

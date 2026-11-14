package dev.reuise.web.frontend.tabs;
import dev.reuise.web.core.tabs.WebTabPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.badge.WebFrontendBadge;
import dev.reuise.web.frontend.icon.WebFrontendIcon;
import dev.reuise.web.frontend.link.WebFrontendLink;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
import dev.reuise.web.frontend.text.WebFrontendInlineText;
public interface WebFrontendTabPart extends WebFrontendParentComponentPart , WebFrontendComponentPart , WebTabPart , WebFrontendTabFeatures {
    WebFrontendLink getLink();

    WebFrontendBadge getBadge();

    WebFrontendIcon getIcon();

    WebFrontendInlineText getLabelContainer();

    WebFrontendParentComponentPart getParentComponentPart();
}

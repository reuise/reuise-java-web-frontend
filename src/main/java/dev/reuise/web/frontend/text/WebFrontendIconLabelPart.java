package dev.reuise.web.frontend.text;
import dev.reuise.web.core.text.WebIconLabelPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.icon.WebFrontendIcon;
import dev.reuise.web.frontend.link.WebFrontendLink;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
public interface WebFrontendIconLabelPart extends WebFrontendIconLabelFeatures , WebFrontendParentComponentPart , WebFrontendComponentPart , WebIconLabelPart {
    WebFrontendLink getLink();

    WebFrontendIcon getStartIcon();

    WebFrontendInlineText getLabelContainer();

    WebFrontendIcon getEndIcon();

    WebFrontendParentComponentPart getParentComponentPart();
}

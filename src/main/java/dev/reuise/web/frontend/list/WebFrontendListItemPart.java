package dev.reuise.web.frontend.list;
import dev.reuise.web.core.list.WebListItemPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.checkbox.WebFrontendCheckbox;
import dev.reuise.web.frontend.icon.WebFrontendIcon;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
import dev.reuise.web.frontend.text.WebFrontendInlineText;
public interface WebFrontendListItemPart extends WebListItemPart , WebFrontendComponentPart , WebFrontendBasicListItemPart , WebFrontendListItemFeatures {
    WebFrontendCheckbox getCheckbox();

    WebFrontendIcon getStartIcon();

    WebFrontendContainer getTextContainer();

    WebFrontendInlineText getLabelContainer();

    WebFrontendInlineText getSecondaryLabelContainer();

    WebFrontendIcon getEndIcon();

    WebFrontendBasicListItemPart getBasicListItemPart();
}

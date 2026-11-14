package dev.reuise.web.frontend.divider;
import dev.reuise.web.core.divider.WebDividerPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
import dev.reuise.web.frontend.text.WebFrontendInlineText;
public interface WebFrontendDividerPart extends WebFrontendParentComponentPart , WebFrontendComponentPart , WebDividerPart , WebFrontendDividerFeatures {
    WebFrontendContainer getStartLine();

    WebFrontendInlineText getLabelContainer();

    WebFrontendContainer getEndLine();

    WebFrontendParentComponentPart getParentComponentPart();
}

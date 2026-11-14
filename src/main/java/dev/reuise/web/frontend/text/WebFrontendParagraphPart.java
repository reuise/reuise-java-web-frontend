package dev.reuise.web.frontend.text;
import dev.reuise.web.core.text.WebParagraphPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
public interface WebFrontendParagraphPart extends WebFrontendParentComponentPart , WebFrontendComponentPart , WebParagraphPart , WebFrontendParagraphFeatures {
    WebFrontendParentComponentPart getParentComponentPart();
}

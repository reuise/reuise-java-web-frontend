package dev.reuise.web.frontend.card;
import dev.reuise.web.core.card.WebCardPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.image.WebFrontendImage;
import dev.reuise.web.frontend.layout.WebFrontendFlexContainer;
import dev.reuise.web.frontend.layout.WebFrontendSurfacePart;
import dev.reuise.web.frontend.link.WebFrontendLink;
import dev.reuise.web.frontend.text.WebFrontendTextBlock;
public interface WebFrontendCardPart extends WebFrontendComponentPart , WebCardPart , WebFrontendCardFeatures , WebFrontendSurfacePart {
    WebFrontendLink getMediaLink();

    WebFrontendFlexContainer getMediaContainer();

    WebFrontendImage getImage();

    WebFrontendFlexContainer getTextContent();

    WebFrontendFlexContainer getHeadline();

    WebFrontendLink getHeadingLink();

    WebFrontendTextBlock getHeadingContainer();

    WebFrontendTextBlock getSubHeadingContainer();

    WebFrontendTextBlock getTextContainer();

    WebFrontendFlexContainer getActionsContainer();

    WebFrontendSurfacePart getSurfacePart();
}

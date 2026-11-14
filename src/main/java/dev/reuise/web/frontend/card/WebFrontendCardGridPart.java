package dev.reuise.web.frontend.card;
import dev.reuise.web.core.card.WebCardGridPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
import dev.reuise.web.frontend.layout.WebFrontendContainerPart;
public interface WebFrontendCardGridPart extends WebFrontendComponentPart , WebFrontendContainerPart , WebFrontendCardGridFeatures , WebCardGridPart {
    WebFrontendContainer getScrim();

    WebFrontendContainer getCardContainer();

    WebFrontendContainerPart getContainerPart();
}

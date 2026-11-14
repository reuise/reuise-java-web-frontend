package dev.reuise.web.frontend.topappbar;
import dev.reuise.web.core.topappbar.WebTopAppBarPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.button.WebFrontendIconButton;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
public interface WebFrontendTopAppBarPart extends WebFrontendParentComponentPart , WebFrontendComponentPart , WebTopAppBarPart , WebFrontendTopAppBarFeatures {
    WebFrontendContainer getContainer();

    WebFrontendIconButton getNavigationButton();

    WebFrontendContainer getTitleContainer();

    WebFrontendContainer getActionsContainer();

    WebFrontendParentComponentPart getParentComponentPart();
}

package dev.reuise.web.frontend.table;
import dev.reuise.web.core.table.WebTableHeaderCellPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.button.WebFrontendIconButton;
import dev.reuise.web.frontend.menu.WebFrontendMenu;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
import dev.reuise.web.frontend.text.WebFrontendInlineText;
public interface WebFrontendTableHeaderCellPart extends WebFrontendParentComponentPart , WebFrontendComponentPart , WebTableHeaderCellPart , WebFrontendTableHeaderCellFeatures {
    WebFrontendInlineText getLabelContainer();

    WebFrontendMenu getMenu();

    WebFrontendIconButton getMenuButton();

    WebFrontendParentComponentPart getParentComponentPart();
}

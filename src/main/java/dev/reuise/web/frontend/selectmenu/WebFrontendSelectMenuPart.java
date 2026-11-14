package dev.reuise.web.frontend.selectmenu;
import dev.reuise.core.input.TextFieldSize;
import dev.reuise.web.core.selectmenu.WebSelectMenuPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.input.WebFrontendTextField;
import dev.reuise.web.frontend.menu.WebFrontendMenu;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
// Placeholder here??
// Label here??
// Autocomplete here??
// ReadOnly here??
// Size here??
public interface WebFrontendSelectMenuPart extends WebFrontendParentComponentPart , WebFrontendComponentPart , WebFrontendSelectMenuFeatures , WebSelectMenuPart {
    String getPlaceholder();

    WebFrontendSelectMenuPart setPlaceholder(String placeholder);

    String getLabel();

    WebFrontendSelectMenuPart setLabel(String label);

    String getAutocomplete();

    WebFrontendSelectMenuPart setAutocomplete(String autocomplete);

    boolean isReadOnly();

    WebFrontendSelectMenuPart setReadOnly(Boolean readOnly);

    TextFieldSize getSize();

    WebFrontendSelectMenuPart setSize(TextFieldSize size);

    WebFrontendTextField getTextField();

    WebFrontendMenu getMenu();

    WebFrontendParentComponentPart getParentComponentPart();
}

package dev.reuise.web.frontend.selectmenu;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.core.input.TextFieldSize;
import dev.reuise.core.option.ComponentCreator;
import dev.reuise.web.core.selectmenu.WebSelectMenuPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.input.WebFrontendTextField;
import dev.reuise.web.frontend.input.WebFrontendTextFieldOptions;
import dev.reuise.web.frontend.menu.WebFrontendMenu;
import dev.reuise.web.frontend.menu.WebFrontendMenuOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Placeholder here??
// Label here??
// Autocomplete here??
// ReadOnly here??
// Size here??
public interface WebFrontendSelectMenuPartOptions extends WebSelectMenuPartOptions {
    WebFrontendParentComponentPartOptions getParentComponentPart();

    String getPlaceholder();

    WebFrontendSelectMenuPartOptions setPlaceholder(String placeholder);

    String getLabel();

    WebFrontendSelectMenuPartOptions setLabel(String label);

    String getAutocomplete();

    WebFrontendSelectMenuPartOptions setAutocomplete(String autocomplete);

    boolean isReadOnly();

    WebFrontendSelectMenuPartOptions setReadOnly(Boolean readOnly);

    TextFieldSize getSize();

    WebFrontendSelectMenuPartOptions setSize(TextFieldSize size);

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    WebFrontendSelectMenuPartOptions setTextFieldCreator(ComponentCreator<? extends WebFrontendTextField, ? extends WebFrontendTextFieldOptions> textFieldCreator);

    WebFrontendSelectMenuPartOptions setMenuCreator(ComponentCreator<? extends WebFrontendMenu, ? extends WebFrontendMenuOptions> menuCreator);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendSelectMenu getComponent();
}

package dev.reuise.web.frontend.table;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.core.option.ComponentCreator;
import dev.reuise.web.core.table.WebCheckboxTableCellPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.checkbox.WebFrontendCheckbox;
import dev.reuise.web.frontend.checkbox.WebFrontendCheckboxOptions;
public interface WebFrontendCheckboxTableCellPartOptions extends WebCheckboxTableCellPartOptions {
    WebFrontendTableCellPartOptions getTableCellPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    WebFrontendCheckboxTableCellPartOptions setCheckboxCreator(ComponentCreator<? extends WebFrontendCheckbox, ? extends WebFrontendCheckboxOptions> checkboxCreator);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendCheckboxTableCell getComponent();
}

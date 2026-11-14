package dev.reuise.web.frontend.table;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.core.option.ComponentCreator;
import dev.reuise.web.core.table.WebTableHeaderPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
public interface WebFrontendTableHeaderPartOptions extends WebTableHeaderPartOptions {
    WebFrontendParentComponentPartOptions getParentComponentPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    WebFrontendTableHeaderPartOptions setRowCreator(ComponentCreator<? extends WebFrontendTableHeaderRow, ? extends WebFrontendTableHeaderRowOptions> rowCreator);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendTableHeader getComponent();
}

package dev.reuise.web.frontend.table;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.core.option.ComponentCreator;
import dev.reuise.web.core.table.WebTablePartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
import dev.reuise.web.frontend.layout.WebFrontendContainerOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
public interface WebFrontendTablePartOptions extends WebTablePartOptions {
    WebFrontendParentComponentPartOptions getParentComponentPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    WebFrontendTablePartOptions setTableCreator(ComponentCreator<? extends WebFrontendContainer, ? extends WebFrontendContainerOptions> tableCreator);

    WebFrontendTablePartOptions setColumnGroupCreator(ComponentCreator<? extends WebFrontendTableColumnGroup, ? extends WebFrontendTableColumnGroupOptions> columnGroupCreator);

    WebFrontendTablePartOptions setHeaderCreator(ComponentCreator<? extends WebFrontendTableHeader, ? extends WebFrontendTableHeaderOptions> headerCreator);

    WebFrontendTablePartOptions setBodyCreator(ComponentCreator<? extends WebFrontendTableBody, ? extends WebFrontendTableBodyOptions> bodyCreator);

    WebFrontendTablePartOptions setFooterCreator(ComponentCreator<? extends WebFrontendTableFooter, ? extends WebFrontendTableFooterOptions> footerCreator);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendTable getComponent();
}

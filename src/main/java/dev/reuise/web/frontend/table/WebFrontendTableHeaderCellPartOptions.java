package dev.reuise.web.frontend.table;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.core.option.ComponentCreator;
import dev.reuise.web.core.table.WebTableHeaderCellPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.button.WebFrontendIconButton;
import dev.reuise.web.frontend.button.WebFrontendIconButtonOptions;
import dev.reuise.web.frontend.menu.WebFrontendMenu;
import dev.reuise.web.frontend.menu.WebFrontendMenuOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
import dev.reuise.web.frontend.text.WebFrontendInlineText;
import dev.reuise.web.frontend.text.WebFrontendInlineTextOptions;
public interface WebFrontendTableHeaderCellPartOptions extends WebTableHeaderCellPartOptions {
    WebFrontendParentComponentPartOptions getParentComponentPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    WebFrontendTableHeaderCellPartOptions setLabelContainerCreator(ComponentCreator<? extends WebFrontendInlineText, ? extends WebFrontendInlineTextOptions> labelContainerCreator);

    WebFrontendTableHeaderCellPartOptions setMenuCreator(ComponentCreator<? extends WebFrontendMenu, ? extends WebFrontendMenuOptions> menuCreator);

    WebFrontendTableHeaderCellPartOptions setMenuButtonCreator(ComponentCreator<? extends WebFrontendIconButton, ? extends WebFrontendIconButtonOptions> menuButtonCreator);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendTableHeaderCell getComponent();
}

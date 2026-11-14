package dev.reuise.web.frontend.navigation;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.core.option.ComponentCreator;
import dev.reuise.web.core.navigation.WebNavigationTreeGroupPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.accordion.WebFrontendAccordionItemPartOptions;
public interface WebFrontendNavigationTreeGroupPartOptions extends WebNavigationTreeGroupPartOptions {
    WebFrontendAccordionItemPartOptions getAccordionItemPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    WebFrontendNavigationTreeGroupPartOptions setLinkCreator(ComponentCreator<? extends WebFrontendNavigationTreeLink, ? extends WebFrontendNavigationTreeLinkOptions> linkCreator);

    WebFrontendNavigationTreeGroupPartOptions setTreeCreator(ComponentCreator<? extends WebFrontendNavigationTree, ? extends WebFrontendNavigationTreeOptions> treeCreator);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendNavigationTreeGroup getComponent();
}

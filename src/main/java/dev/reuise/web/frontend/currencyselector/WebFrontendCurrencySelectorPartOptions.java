package dev.reuise.web.frontend.currencyselector;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.web.core.currencyselector.WebCurrencySelectorPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.selectmenu.WebFrontendSelectMenuPartOptions;
public interface WebFrontendCurrencySelectorPartOptions extends WebCurrencySelectorPartOptions {
    WebFrontendSelectMenuPartOptions getSelectMenuPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendCurrencySelector getComponent();
}

package dev.reuise.web.frontend.currencyselector;
import dev.reuise.web.core.currencyselector.WebCurrencySelector;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.selectmenu.WebFrontendSelectMenu;
public interface WebFrontendCurrencySelector extends WebFrontendCurrencySelectorPart , WebCurrencySelector , WebFrontendComponent , WebFrontendSelectMenu {
    WebFrontendCurrencySelector getComponent();
}

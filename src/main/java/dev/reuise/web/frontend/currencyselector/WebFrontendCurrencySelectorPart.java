package dev.reuise.web.frontend.currencyselector;
import dev.reuise.web.core.currencyselector.WebCurrencySelectorPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.selectmenu.WebFrontendSelectMenuPart;
public interface WebFrontendCurrencySelectorPart extends WebCurrencySelectorPart , WebFrontendCurrencySelectorFeatures , WebFrontendComponentPart , WebFrontendSelectMenuPart {
    WebFrontendSelectMenuPart getSelectMenuPart();
}

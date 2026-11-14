package dev.reuise.web.frontend.currencyselector;
import dev.reuise.web.core.currencyselector.WebCurrencySelectorOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
import dev.reuise.web.frontend.selectmenu.WebFrontendSelectMenuOptions;
import dev.reuise.web.frontend.selectmenu.WebFrontendSelectMenuPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendCurrencySelectorOptions extends WebFrontendComponentOptions , WebFrontendBaseComponentPartOptions , WebFrontendSelectMenuOptions , WebCurrencySelectorOptions , WebFrontendCurrencySelectorPartOptions , WebFrontendSelectMenuPartOptions , WebFrontendParentComponentPartOptions {
    WebFrontendSelectMenuPartOptions getSelectMenuPart();

    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}

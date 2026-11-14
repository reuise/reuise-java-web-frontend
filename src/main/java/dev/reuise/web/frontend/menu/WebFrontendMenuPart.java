package dev.reuise.web.frontend.menu;
import akasha.HTMLElement;
import dev.reuise.web.core.menu.WebMenuPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.list.WebFrontendListView;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
public interface WebFrontendMenuPart extends WebFrontendMenuFeatures , WebFrontendParentComponentPart , WebFrontendComponentPart , WebMenuPart {
    void open(HTMLElement element);

    WebFrontendListView getList();

    WebFrontendParentComponentPart getParentComponentPart();
}

package dev.reuise.web.frontend.view;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.core.option.ComponentOption;
import dev.reuise.web.core.view.WebViewPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.layout.WebFrontendFlexContainerPartOptions;
public interface WebFrontendViewPartOptions extends WebViewPartOptions {
    WebFrontendFlexContainerPartOptions getFlexContainerPart();

    String getUrl();

    ComponentOption<String> getUrlOption();

    WebFrontendViewPartOptions setUrl(String url);

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendView getComponent();
}

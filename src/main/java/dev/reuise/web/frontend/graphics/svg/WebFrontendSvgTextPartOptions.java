package dev.reuise.web.frontend.graphics.svg;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.web.core.graphics.svg.WebSvgTextPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
public interface WebFrontendSvgTextPartOptions extends WebSvgTextPartOptions {
    WebFrontendSvgPartOptions getSvgPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendSvgText getComponent();
}

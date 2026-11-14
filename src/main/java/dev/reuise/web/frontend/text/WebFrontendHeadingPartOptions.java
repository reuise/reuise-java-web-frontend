package dev.reuise.web.frontend.text;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.web.core.text.WebHeadingPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
public interface WebFrontendHeadingPartOptions extends WebHeadingPartOptions {
    WebFrontendTextPartOptions getTextPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendHeading getComponent();
}

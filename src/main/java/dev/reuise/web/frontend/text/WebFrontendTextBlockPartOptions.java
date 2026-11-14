package dev.reuise.web.frontend.text;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.web.core.text.WebTextBlockPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
public interface WebFrontendTextBlockPartOptions extends WebTextBlockPartOptions {
    WebFrontendTextPartOptions getTextPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendTextBlock getComponent();
}

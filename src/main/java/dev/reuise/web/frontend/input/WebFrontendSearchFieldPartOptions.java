package dev.reuise.web.frontend.input;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.web.core.input.WebSearchFieldPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
public interface WebFrontendSearchFieldPartOptions extends WebSearchFieldPartOptions {
    WebFrontendTextFieldPartOptions getTextFieldPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendSearchField getComponent();
}

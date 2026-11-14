package dev.reuise.web.frontend.text;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.web.core.text.WebLabelPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
public interface WebFrontendLabelPartOptions extends WebLabelPartOptions {
    WebFrontendInlineTextPartOptions getInlineTextPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendLabel getComponent();
}

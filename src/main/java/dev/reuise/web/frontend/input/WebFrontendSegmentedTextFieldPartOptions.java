package dev.reuise.web.frontend.input;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.web.core.input.WebSegmentedTextFieldPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.layout.WebFrontendRowLayoutPartOptions;
public interface WebFrontendSegmentedTextFieldPartOptions extends WebSegmentedTextFieldPartOptions {
    WebFrontendRowLayoutPartOptions getRowLayoutPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendSegmentedTextField getComponent();
}

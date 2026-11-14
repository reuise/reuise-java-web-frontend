package dev.reuise.web.frontend.dialog;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.web.core.dialog.WebMessageDialogPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
public interface WebFrontendMessageDialogPartOptions extends WebMessageDialogPartOptions {
    WebFrontendDialogPartOptions getDialogPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendMessageDialog getComponent();
}

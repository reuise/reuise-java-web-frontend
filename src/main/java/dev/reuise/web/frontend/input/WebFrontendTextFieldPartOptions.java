package dev.reuise.web.frontend.input;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.core.input.InputValidator;
import dev.reuise.core.option.ComponentCreator;
import dev.reuise.web.core.input.WebTextFieldPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.icon.WebFrontendIcon;
import dev.reuise.web.frontend.icon.WebFrontendIconOptions;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
import dev.reuise.web.frontend.layout.WebFrontendContainerOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
import dev.reuise.web.frontend.text.WebFrontendInlineText;
import dev.reuise.web.frontend.text.WebFrontendInlineTextOptions;
import dev.reuise.web.frontend.text.WebFrontendLabel;
import dev.reuise.web.frontend.text.WebFrontendLabelOptions;
import java.util.List;
// Value here??
// Placeholder here??
// Pattern here??
// Multiline here??
// MinLines here??
// MaxLines here??
// ReadOnly here??
// Autocomplete here??
// Validators here??
// Required here??
// Error here??
public interface WebFrontendTextFieldPartOptions extends WebTextFieldPartOptions {
    WebFrontendParentComponentPartOptions getParentComponentPart();

    String getValue();

    WebFrontendTextFieldPartOptions setValue(String value);

    String getPlaceholder();

    WebFrontendTextFieldPartOptions setPlaceholder(String placeholder);

    String getPattern();

    WebFrontendTextFieldPartOptions setPattern(String pattern);

    boolean isMultiline();

    WebFrontendTextFieldPartOptions setMultiline(Boolean multiline);

    Integer getMinLines();

    WebFrontendTextFieldPartOptions setMinLines(Integer minLines);

    Integer getMaxLines();

    WebFrontendTextFieldPartOptions setMaxLines(Integer maxLines);

    boolean isReadOnly();

    WebFrontendTextFieldPartOptions setReadOnly(Boolean readOnly);

    String getAutocomplete();

    WebFrontendTextFieldPartOptions setAutocomplete(String autocomplete);

    List<InputValidator> getValidators();

    WebFrontendTextFieldPartOptions setValidators(List<InputValidator> validators);

    WebFrontendTextFieldPartOptions addValidator(InputValidator validator);

    WebFrontendTextFieldPartOptions setValidator(InputValidator validator);

    WebFrontendTextFieldPartOptions removeValidator(InputValidator validator);

    WebFrontendTextFieldPartOptions clearValidators();

    boolean isRequired();

    WebFrontendTextFieldPartOptions setRequired(Boolean required);

    boolean isError();

    WebFrontendTextFieldPartOptions setError(Boolean error);

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    WebFrontendTextFieldPartOptions setLabelContainerCreator(ComponentCreator<? extends WebFrontendLabel, ? extends WebFrontendLabelOptions> labelContainerCreator);

    WebFrontendTextFieldPartOptions setInputContainerCreator(ComponentCreator<? extends WebFrontendContainer, ? extends WebFrontendContainerOptions> inputContainerCreator);

    WebFrontendTextFieldPartOptions setStartIconCreator(ComponentCreator<? extends WebFrontendIcon, ? extends WebFrontendIconOptions> startIconCreator);

    WebFrontendTextFieldPartOptions setInputCreator(ComponentCreator<? extends WebFrontendBasicInputField, ? extends WebFrontendBasicInputFieldOptions> inputCreator);

    WebFrontendTextFieldPartOptions setEndIconCreator(ComponentCreator<? extends WebFrontendIcon, ? extends WebFrontendIconOptions> endIconCreator);

    WebFrontendTextFieldPartOptions setSupportingTextContainerCreator(ComponentCreator<? extends WebFrontendInlineText, ? extends WebFrontendInlineTextOptions> supportingTextContainerCreator);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendTextField getComponent();
}

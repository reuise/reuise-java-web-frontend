package dev.reuise.web.frontend.input;
import dev.reuise.core.input.InputValidator;
import dev.reuise.web.core.input.WebTextFieldPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.icon.WebFrontendIcon;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
import dev.reuise.web.frontend.text.WebFrontendInlineText;
import dev.reuise.web.frontend.text.WebFrontendLabel;
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
public interface WebFrontendTextFieldPart extends WebFrontendParentComponentPart , WebFrontendComponentPart , WebFrontendTextFieldFeatures , WebTextFieldPart {
    String getValue();

    WebFrontendTextFieldPart setValue(String value);

    String getPlaceholder();

    WebFrontendTextFieldPart setPlaceholder(String placeholder);

    String getPattern();

    WebFrontendTextFieldPart setPattern(String pattern);

    boolean isMultiline();

    WebFrontendTextFieldPart setMultiline(Boolean multiline);

    Integer getMinLines();

    WebFrontendTextFieldPart setMinLines(Integer minLines);

    Integer getMaxLines();

    WebFrontendTextFieldPart setMaxLines(Integer maxLines);

    boolean isReadOnly();

    WebFrontendTextFieldPart setReadOnly(Boolean readOnly);

    String getAutocomplete();

    WebFrontendTextFieldPart setAutocomplete(String autocomplete);

    List<InputValidator> getValidators();

    WebFrontendTextFieldPart setValidators(List<InputValidator> validators);

    WebFrontendTextFieldPart addValidator(InputValidator validator);

    WebFrontendTextFieldPart setValidator(InputValidator validator);

    WebFrontendTextFieldPart removeValidator(InputValidator validator);

    WebFrontendTextFieldPart clearValidators();

    boolean isRequired();

    WebFrontendTextFieldPart setRequired(Boolean required);

    boolean isError();

    WebFrontendTextFieldPart setError(Boolean error);

    WebFrontendLabel getLabelContainer();

    WebFrontendContainer getInputContainer();

    WebFrontendIcon getStartIcon();

    WebFrontendBasicInputField getInput();

    WebFrontendIcon getEndIcon();

    WebFrontendInlineText getSupportingTextContainer();

    WebFrontendParentComponentPart getParentComponentPart();
}

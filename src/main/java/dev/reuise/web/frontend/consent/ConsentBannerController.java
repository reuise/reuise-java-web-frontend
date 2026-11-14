package dev.reuise.web.frontend.consent;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

import akasha.KeyboardEvent;
import dev.reuise.core.consent.ConsentCategory;
import dev.reuise.core.consent.ConsentPreferences;
import dev.reuise.core.event.Event;
import dev.reuise.core.layout.FlexDirection;
import dev.reuise.web.frontend.checkbox.WebFrontendCheckbox;
import dev.reuise.web.frontend.dialog.WebFrontendDialog;
import dev.reuise.web.frontend.layout.WebFrontendFlexContainer;

/**
 * Connects a consent banner to application-owned preferences and persistence.
 * The application must also enforce the resulting choices before loading
 * optional cookies or other storage.
 *
 * Attach once after creating or hydrating the banner. Construct the same
 * categories on the client and restore any saved choices before attaching.
 * The callback receives an immutable snapshot when a visitor makes a choice;
 * returning normally indicates that the application accepted the update.
 * Call {@link #openPreferences()} from a persistent privacy-settings link to
 * let visitors change their choices after the banner is dismissed.
 */
public final class ConsentBannerController {
    private static final String ATTACHED_ATTRIBUTE = "data-reuise-consent-controller";
    private final WebFrontendConsentBanner banner;
    private final WebFrontendDialog dialog;
    private final WebFrontendFlexContainer categoryList;
    private final ConsentPreferences preferences;
    private final Consumer<Map<String, Boolean>> onSave;
    private final Map<String, WebFrontendCheckbox> controls = new LinkedHashMap<>();
    private boolean returnToHiddenBanner;

    public ConsentBannerController(WebFrontendConsentBanner banner, ConsentPreferences preferences,
            Consumer<Map<String, Boolean>> onSave) {
        this.banner = Objects.requireNonNull(banner, "banner");
        this.preferences = Objects.requireNonNull(preferences, "preferences");
        this.onSave = Objects.requireNonNull(onSave, "onSave");
        if (banner.hasAttribute(ATTACHED_ATTRIBUTE)) {
            throw new IllegalStateException("A consent controller is already attached");
        }
        dialog = banner.getPreferencesDialog();
        var categoryOptions = banner.getComponentFactory().createFlexContainerOptions();
        categoryOptions.setDirection(FlexDirection.COLUMN);
        categoryList = banner.getComponentFactory().createFlexContainer(categoryOptions);
        dialog.getBody().add(categoryList);
        dialog.setAttribute("role", "dialog");
        dialog.setAria("label", banner.getPreferencesTitle());
        dialog.getAcceptButton().setLabel("Save preferences");
        dialog.getCancelButton().setLabel("Cancel");
        dialog.setAcceptHandler(event -> {
            savePreferences();
            return true;
        });
        dialog.setCancelHandler(event -> {
            cancelPreferences();
            return true;
        });
        dialog.getScrim().on(Event.CLICK, event -> cancelPreferences());
        dialog.getElement().addEventListener("keydown", event -> {
            if (event instanceof KeyboardEvent && "Escape".equals(((KeyboardEvent) event).key())) {
                event.preventDefault();
                event.stopPropagation();
                dialog.close();
                cancelPreferences();
            }
        });
        banner.getAcceptButton().on(Event.CLICK, event -> save(preferences.copy().acceptAll()));
        banner.getRejectButton().on(Event.CLICK, event -> save(preferences.copy().rejectOptional()));
        banner.getPreferencesButton().on(Event.CLICK, event -> openPreferences());
        banner.setAttribute(ATTACHED_ATTRIBUTE, "true");
    }

    public ConsentBannerController setDialogLabels(String saveLabel, String cancelLabel) {
        dialog.getAcceptButton().setLabel(Objects.requireNonNull(saveLabel, "saveLabel"));
        dialog.getCancelButton().setLabel(Objects.requireNonNull(cancelLabel, "cancelLabel"));
        return this;
    }

    /**
     * Opens the preferences editor, including after the notice was dismissed.
     */
    public void openPreferences() {
        returnToHiddenBanner = !banner.isVisible();
        banner.setVisible(true);
        categoryList.removeAll();
        controls.clear();
        var factory = banner.getComponentFactory();
        for (ConsentCategory category : preferences.getCategories()) {
            var options = factory.createCheckboxOptions();
            options.setLabel(category.getLabel());
            options.setChecked(Boolean.TRUE.equals(preferences.getChoice(category.getId())));
            WebFrontendCheckbox checkbox = factory.createCheckbox(options);
            String id = checkbox.getCheckbox().getUniqueId();
            checkbox.getCheckbox().setId(id);
            checkbox.getLabelContainer().setAttribute("for", id);
            if (category.isRequired()) checkbox.getCheckbox().setEnabled(false);
            categoryList.add(checkbox);
            if (!category.getDescription().isEmpty()) {
                var descriptionOptions = factory.createParagraphOptions();
                descriptionOptions.setText(category.getDescription());
                var description = factory.createParagraph(descriptionOptions);
                String descriptionId = description.getUniqueId();
                description.setId(descriptionId);
                checkbox.getCheckbox().setAria("describedby", descriptionId);
                categoryList.add(description);
            }
            controls.put(category.getId(), checkbox);
        }
        dialog.setAria("label", banner.getPreferencesTitle());
        dialog.open();
        dialog.getAcceptButton().setFocused(true);
    }

    private void savePreferences() {
        ConsentPreferences draft = preferences.copy();
        for (ConsentCategory category : draft.getCategories()) {
            if (!category.isRequired()) {
                draft.setChoice(category.getId(), controls.get(category.getId()).isChecked());
            }
        }
        save(draft);
    }

    private void cancelPreferences() {
        if (returnToHiddenBanner) banner.setVisible(false);
        else banner.getPreferencesButton().setFocused(true);
    }

    private void save(ConsentPreferences draft) {
        Map<String, Boolean> snapshot = draft.getChoices();
        onSave.accept(snapshot);
        preferences.restoreChoices(snapshot);
        banner.setVisible(false);
    }
}

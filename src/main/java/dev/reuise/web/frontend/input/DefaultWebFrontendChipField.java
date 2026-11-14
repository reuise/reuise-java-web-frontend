package dev.reuise.web.frontend.input;
import akasha.CustomEvent;
import akasha.DataTransfer;
import akasha.Element;
import akasha.EventListener;
import akasha.HTMLElement;
import akasha.HTMLInputElement;
import akasha.KeyboardEvent;
import akasha.clipboard.ClipboardEvent;
import dev.reuise.core.ComponentPart;
import dev.reuise.core.ComponentType;
import dev.reuise.core.CoreComponent;
import dev.reuise.core.CoreComponentOptions;
import dev.reuise.core.Interaction;
import dev.reuise.core.Rect;
import dev.reuise.core.RootComponent;
import dev.reuise.core.State;
import dev.reuise.core.chip.CoreFilterChip;
import dev.reuise.core.event.EventType;
import dev.reuise.core.input.CoreTextFieldOptions;
import dev.reuise.core.option.OptionApplicator;
import dev.reuise.core.theme.Theme;
import dev.reuise.web.core.WebRootComponent;
import dev.reuise.web.core.input.DefaultWebChipFieldPart;
import dev.reuise.web.frontend.ElementDataParser;
import dev.reuise.web.frontend.ElementProvider;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.WebFrontendComponentType;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPart;
import dev.reuise.web.frontend.chip.WebFrontendChipGroup;
import dev.reuise.web.frontend.chip.WebFrontendFilterChip;
import dev.reuise.web.frontend.icon.WebFrontendIcon;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
import dev.reuise.web.frontend.text.WebFrontendInlineText;
import dev.reuise.web.frontend.text.WebFrontendLabel;
import dev.reuise.webstyles.Style;
import dev.reuise.webstyles.StyleBuilder;
import dev.reuise.webstyles.StyleSheetFactory;
import java.util.Collection;
import java.util.Set;
import jsinterop.base.Any;
// Option: Size - CORE
// Option: SupportingText - CORE
// Option: Label - CORE
// Option: LabelPlacement - CORE
// Option: Children - CORE
// Option: ElementProvider - WEB_FRONTEND
// Option: ElementDataParser - WEB_FRONTEND
// Option: ResizeEventsEnabled - WEB_FRONTEND
// Option: Id - WEB
// Option: TagName - WEB
// Option: XmlNamespace - WEB
// Option: Tooltip - WEB
// Option: BaseStyleClass - WEB
// Option: Attributes - WEB
// Option: StyleClasses - WEB
// Option: Data - WEB
// Option: Style - WEB
// Option: InlineStyle - WEB
// Option: Rehydration - WEB
// Option: ContentEditable - WEB
// Option: StoreInElementOptions - WEB
// Option: Mounted - CORE
// Option: Margin - CORE
// Option: MarginTop - CORE
// Option: MarginRight - CORE
// Option: MarginBottom - CORE
// Option: MarginLeft - CORE
// Option: Width - CORE
// Option: MinWidth - CORE
// Option: MaxWidth - CORE
// Option: Height - CORE
// Option: MinHeight - CORE
// Option: MaxHeight - CORE
// Option: RequiredLayoutComponent - CORE
// Option: Parent - CORE
// Option: LocaleContext - CORE
// Option: LinkUrlResolver - CORE
// Option: Wrapper - CORE
// Option: Theme - CORE
// Option: Visible - CORE
// Option: Enabled - CORE
// Option: Focused - CORE
// Option: Debug - CORE
// Option: DebugId - CORE
// base comp: textField
// add composition for textField: validate
// add composition for textField: clear
// add composition for textField: hasValue
// base comp: parentComponent
// base comp: baseComponent
// add composition for baseComponent: getElement
// add composition for baseComponent: getHtmlElement
// add composition for baseComponent: getBoundingBox
// add composition for baseComponent: createOrRehydrateElement
// add composition for baseComponent: on
// add composition for baseComponent: on
// add composition for baseComponent: dispatchEvent
// add composition for baseComponent: click
// add composition for baseComponent: isRehydrated
// add composition for baseComponent: getComputedStyle
// add composition for baseComponent: addOrRemoveStyleClass
// add composition for baseComponent: hasStyleClass
// add composition for baseComponent: removeStyleClass
// add composition for baseComponent: setAttribute
// add composition for baseComponent: removeAttribute
// add composition for baseComponent: getAttribute
// add composition for baseComponent: hasAttribute
// add composition for baseComponent: setData
// add composition for baseComponent: getData
// add composition for baseComponent: hasData
// add composition for baseComponent: setAria
// add composition for baseComponent: getAria
// add composition for baseComponent: hasAria
// add composition for baseComponent: getUniqueId
// add composition for baseComponent: getUniqueStyleClass
// add composition for baseComponent: getStyleSheetId
// add composition for baseComponent: getStyleStates
// add composition for baseComponent: setStyleSheetFactory
// add composition for baseComponent: getStyle
// add composition for baseComponent: hasWrapper
// add composition for baseComponent: isInitialized
// add composition for baseComponent: log
// add composition for baseComponent: removeFromParent
public abstract class DefaultWebFrontendChipField<S extends DefaultWebFrontendChipField<S, O>, O extends WebFrontendChipFieldOptions> extends DefaultWebChipFieldPart<S, O> implements WebFrontendChipField , WebFrontendComponentType<S, O> {
    @Override
    protected CoreFilterChip createChip(String label) {
        WebFrontendFilterChip newChip = ((WebFrontendFilterChip) (super.createChip(label)));
        newChip.getHtmlElement().addEventListener("change", e -> {
            Any selectedDetail = ((CustomEvent) (e)).detail().asPropertyMap().getAsAny("selected");
            boolean selected = selectedDetail.asBoolean();
            if (!selected)
                this.chipGroup.removeChip(newChip);

        });
        return newChip;
    }

    protected final WebFrontendTextFieldPart textFieldPart;

    protected final WebFrontendParentComponentPart parentComponentPart;

    protected final WebFrontendBaseComponentPart baseComponentPart;

    protected DefaultWebFrontendChipField(O options) {
        super(options);
        if (options.getComponent() == null)
            options.setComponent(self());

        textFieldPart = options.getComponentFactory().createTextField(((CoreTextFieldOptions) (options.getTextFieldPart())));
        parentComponentPart = textFieldPart.getParentComponentPart();
        baseComponentPart = parentComponentPart.getBaseComponentPart();
        addPart(ComponentPart.Type.BASE, textFieldPart);
    }

    @Override
    public S setError(String message) {
        this.textFieldPart.setError(message);
        return self();
    }

    public boolean validate() {
        return textFieldPart.validate();
    }

    public void clear() {
        textFieldPart.clear();
    }

    public boolean hasValue() {
        return textFieldPart.hasValue();
    }

    public WebFrontendTextFieldPart getTextFieldPart() {
        return textFieldPart;
    }

    @Override
    public RootComponent getRootComponent() {
        return textFieldPart.getRootComponent();
    }

    @Override
    public void setRootComponent(RootComponent rootComponent) {
        super.setRootComponent(rootComponent);
        this.textFieldPart.setRootComponent(rootComponent);
        if (chipGroup != null)
            chipGroup.setRootComponent(rootComponent);

    }

    @Override
    public Theme getTheme() {
        return textFieldPart.getTheme();
    }

    @Override
    public S setTheme(Theme theme) {
        super.setTheme(theme);
        if (chipGroup != null)
            chipGroup.setTheme(theme);

        this.textFieldPart.setTheme(theme);
        return self();
    }

    @Override
    public WebFrontendLabel getLabelContainer() {
        return textFieldPart.getLabelContainer();
    }

    @Override
    public WebFrontendContainer getInputContainer() {
        return textFieldPart.getInputContainer();
    }

    @Override
    public WebFrontendIcon getStartIcon() {
        return textFieldPart.getStartIcon();
    }

    @Override
    public WebFrontendBasicInputField getInput() {
        return textFieldPart.getInput();
    }

    @Override
    public WebFrontendIcon getEndIcon() {
        return textFieldPart.getEndIcon();
    }

    @Override
    public WebFrontendInlineText getSupportingTextContainer() {
        return textFieldPart.getSupportingTextContainer();
    }

    @Override
    public S rehydrate(CoreComponent child) {
        this.textFieldPart.rehydrate(child);
        child.setParent(self());
        child.setRootComponent(getRootComponent());
        return self();
    }

    public WebFrontendParentComponentPart getParentComponentPart() {
        return parentComponentPart;
    }

    @Override
    public ElementProvider getElementProvider() {
        return baseComponentPart.getElementProvider();
    }

    @Override
    public S setElementProvider(ElementProvider elementProvider) {
        this.baseComponentPart.setElementProvider(elementProvider);
        return self();
    }

    @Override
    public ElementDataParser getElementDataParser() {
        return baseComponentPart.getElementDataParser();
    }

    @Override
    public S setElementDataParser(ElementDataParser elementDataParser) {
        this.baseComponentPart.setElementDataParser(elementDataParser);
        return self();
    }

    @Override
    public boolean isResizeEventsEnabled() {
        return baseComponentPart.isResizeEventsEnabled();
    }

    @Override
    public S setResizeEventsEnabled(Boolean resizeEventsEnabled) {
        this.baseComponentPart.setResizeEventsEnabled(resizeEventsEnabled);
        return self();
    }

    @Override
    public S setRehydration(Element element) {
        this.baseComponentPart.setRehydration(element);
        return self();
    }

    @Override
    public S setRehydration(String rehydration, Boolean canFail) {
        this.baseComponentPart.setRehydration(rehydration, canFail);
        return self();
    }

    @Override
    public S setRehydration(String selector, CoreComponent parent) {
        this.baseComponentPart.setRehydration(selector, parent);
        return self();
    }

    @Override
    public S setRehydration(String selector, CoreComponent parent, Boolean canFail) {
        this.baseComponentPart.setRehydration(selector, parent, canFail);
        return self();
    }

    public Element getElement() {
        return textFieldPart.getElement();
    }

    public HTMLElement getHtmlElement() {
        return textFieldPart.getHtmlElement();
    }

    public Rect getBoundingBox() {
        return textFieldPart.getBoundingBox();
    }

    public HTMLElement createOrRehydrateElement(String tagName, String selector) {
        return textFieldPart.createOrRehydrateElement(tagName, selector);
    }

    public S on(EventType type, EventListener listener) {
        textFieldPart.on(type, listener);
        return self();
    }

    public S on(Set<EventType> types, EventListener listener) {
        textFieldPart.on(types, listener);
        return self();
    }

    public void dispatchEvent(EventType type) {
        textFieldPart.dispatchEvent(type);
    }

    public void click() {
        textFieldPart.click();
    }

    public boolean isRehydrated() {
        if (textFieldPart == null)
            return false;

        return textFieldPart.isRehydrated();
    }

    public Style getComputedStyle() {
        return textFieldPart.getComputedStyle();
    }

    public S addOrRemoveStyleClass(String styleClass, boolean add) {
        textFieldPart.addOrRemoveStyleClass(styleClass, add);
        return self();
    }

    public boolean hasStyleClass(String styleClass) {
        return textFieldPart.hasStyleClass(styleClass);
    }

    public S removeStyleClass(String styleClass) {
        textFieldPart.removeStyleClass(styleClass);
        return self();
    }

    public S setAttribute(String attribute, String value) {
        textFieldPart.setAttribute(attribute, value);
        return self();
    }

    public S setAttribute(String attribute) {
        textFieldPart.setAttribute(attribute);
        return self();
    }

    public S removeAttribute(String attribute) {
        textFieldPart.removeAttribute(attribute);
        return self();
    }

    public String getAttribute(String attribute) {
        return textFieldPart.getAttribute(attribute);
    }

    public boolean hasAttribute(String attribute) {
        return textFieldPart.hasAttribute(attribute);
    }

    public S setData(String data, String value) {
        textFieldPart.setData(data, value);
        return self();
    }

    public String getData(String data) {
        return textFieldPart.getData(data);
    }

    public boolean hasData(String data) {
        return textFieldPart.hasData(data);
    }

    public S setAria(String attribute, String value) {
        textFieldPart.setAria(attribute, value);
        return self();
    }

    public String getAria(String attribute) {
        return textFieldPart.getAria(attribute);
    }

    public boolean hasAria(String attribute) {
        return textFieldPart.hasAria(attribute);
    }

    public String getUniqueId() {
        return textFieldPart.getUniqueId();
    }

    public String getUniqueStyleClass() {
        return textFieldPart.getUniqueStyleClass();
    }

    public String getStyleSheetId() {
        return textFieldPart.getStyleSheetId();
    }

    public String getStyleSheetId(State state) {
        return textFieldPart.getStyleSheetId(state);
    }

    public Set<State> getStyleStates() {
        return textFieldPart.getStyleStates();
    }

    public void setStyleSheetFactory(StyleSheetFactory styleSheetFactory) {
        textFieldPart.setStyleSheetFactory(styleSheetFactory);
    }

    public Style getStyle(State state, Interaction interaction) {
        return textFieldPart.getStyle(state, interaction);
    }

    public Style getStyle(Interaction interaction) {
        return textFieldPart.getStyle(interaction);
    }

    public boolean hasWrapper() {
        return textFieldPart.hasWrapper();
    }

    public boolean isInitialized() {
        return textFieldPart.isInitialized();
    }

    public void log(Object obj) {
        textFieldPart.log(obj);
    }

    public void removeFromParent() {
        textFieldPart.removeFromParent();
    }

    @Override
    public WebFrontendComponentFactory getComponentFactory() {
        return ((WebFrontendComponentFactory) (baseComponentPart.getComponentFactory()));
    }

    public WebFrontendBaseComponentPart getBaseComponentPart() {
        return baseComponentPart;
    }

    @Override
    public void addPart(ComponentPart.Type type, ComponentPart part) {
        baseComponentPart.addPart(type, part);
    }

    @Override
    public <C extends ComponentType<?, T>, T extends CoreComponentOptions> void initialize(C component, T options) {
        setupReferences();
        baseComponentPart.initialize(component, options);
    }

    @Override
    public WebFrontendChipField getComponent() {
        return ((WebFrontendChipField) (baseComponentPart.getComponent()));
    }

    public boolean onPreInitialize(O options) {
        if ((options != null) && options.isRehydrated())
            options.rehydrate(getElement());

        if (!super.onPreInitialize(options))
            return false;

        return true;
    }

    public void onInitialize(O options) {
        super.onInitialize(options);
    }

    // Implementation
    // Implementation
    public void onCreate(O options) {
        super.onCreate(options);
        WebFrontendContainer inputContainer = getTextFieldPart().getInputContainer();
        WebFrontendBasicInputField input = getTextFieldPart().getInput();
        HTMLInputElement inputEl = ((HTMLInputElement) (input.getHtmlElement()));
        if ((inputContainer != null) && (input != null)) {
            input.getHtmlElement().addEventListener("keydown", e -> {
                KeyboardEvent keyEvent = ((KeyboardEvent) (e));
                if ("Enter".equals(keyEvent.key())) {
                    setValue(inputEl.value);
                } else if (this.delimiters.contains(keyEvent.key())) {
                    e.preventDefault();
                    setValue(inputEl.value);
                } else if ("Backspace".equals(keyEvent.key()) && inputEl.value.isEmpty()) {
                    this.chipGroup.removeLastChip();
                }
            });
            input.getHtmlElement().addEventListener("paste", e -> {
                e.preventDefault();
                ClipboardEvent clipboardEvent = ((ClipboardEvent) (e));
                DataTransfer clipboardData = clipboardEvent.clipboardData();
                String text = (clipboardData != null) ? clipboardData.getData("text") : null;
                setValue(text);
            });
            input.getHtmlElement().addEventListener("blur", e -> setValue(inputEl.value));
        }
    }

    public void applyOptions(O options, OptionApplicator applicator, Collection<State> states) {
        super.applyOptions(options, applicator, states);
    }

    public void onInitializeComponentType(RootComponent rootComponent) {
        if (isRehydrated() || ((WebRootComponent) (rootComponent)).isComponentTypeRegistered(getComponent().getClass()))
            return;

        super.onInitializeComponentType(rootComponent);
        textFieldPart.onInitializeComponentType(rootComponent);
        onInitializeCommonStyle(((WebRootComponent) (rootComponent)).getCommonStyles());
    }

    @Override
    public WebFrontendChipGroup getChipGroup() {
        return ((WebFrontendChipGroup) (super.getChipGroup()));
    }

    public void onInitializeCommonStyle(StyleBuilder commonStyles) {
        super.onInitializeCommonStyle(commonStyles);
    }
}

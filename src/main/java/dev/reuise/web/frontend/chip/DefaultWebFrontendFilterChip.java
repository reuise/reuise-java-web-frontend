package dev.reuise.web.frontend.chip;
import akasha.CustomEvent;
import akasha.CustomEventInit;
import akasha.Element;
import akasha.EventListener;
import akasha.HTMLElement;
import dev.reuise.core.ComponentPart;
import dev.reuise.core.ComponentType;
import dev.reuise.core.CoreComponent;
import dev.reuise.core.CoreComponentOptions;
import dev.reuise.core.Interaction;
import dev.reuise.core.Rect;
import dev.reuise.core.RootComponent;
import dev.reuise.core.State;
import dev.reuise.core.chip.CoreChipOptions;
import dev.reuise.core.event.EventType;
import dev.reuise.core.option.OptionApplicator;
import dev.reuise.core.theme.Theme;
import dev.reuise.web.core.WebRootComponent;
import dev.reuise.web.core.chip.DefaultWebFilterChipPart;
import dev.reuise.web.frontend.ElementDataParser;
import dev.reuise.web.frontend.ElementProvider;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.WebFrontendComponentType;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPart;
import dev.reuise.web.frontend.icon.WebFrontendIcon;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
import dev.reuise.web.frontend.text.WebFrontendLabel;
import dev.reuise.webstyles.Style;
import dev.reuise.webstyles.StyleBuilder;
import dev.reuise.webstyles.StyleSheetFactory;
import java.util.Collection;
import java.util.Set;
import jsinterop.base.JsPropertyMap;
// Option: Label - CORE
// Option: Value - CORE
// Option: Size - CORE
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
// base comp: chip
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
public abstract class DefaultWebFrontendFilterChip<S extends DefaultWebFrontendFilterChip<S, O>, O extends WebFrontendFilterChipOptions> extends DefaultWebFilterChipPart<S, O> implements WebFrontendFilterChip , WebFrontendComponentType<S, O> {
    protected final WebFrontendChipPart chipPart;

    protected final WebFrontendParentComponentPart parentComponentPart;

    protected final WebFrontendBaseComponentPart baseComponentPart;

    protected DefaultWebFrontendFilterChip(O options) {
        super(options);
        if (options.getComponent() == null)
            options.setComponent(self());

        chipPart = options.getComponentFactory().createChip(((CoreChipOptions) (options.getChipPart())));
        parentComponentPart = chipPart.getParentComponentPart();
        baseComponentPart = parentComponentPart.getBaseComponentPart();
        addPart(ComponentPart.Type.BASE, chipPart);
    }

    public WebFrontendChipPart getChipPart() {
        return chipPart;
    }

    @Override
    public RootComponent getRootComponent() {
        return chipPart.getRootComponent();
    }

    @Override
    public void setRootComponent(RootComponent rootComponent) {
        this.chipPart.setRootComponent(rootComponent);
    }

    @Override
    public Theme getTheme() {
        return chipPart.getTheme();
    }

    @Override
    public S setTheme(Theme theme) {
        this.chipPart.setTheme(theme);
        return self();
    }

    @Override
    public WebFrontendIcon getStartIcon() {
        return chipPart.getStartIcon();
    }

    @Override
    public WebFrontendLabel getLabelContainer() {
        return chipPart.getLabelContainer();
    }

    @Override
    public WebFrontendIcon getEndIcon() {
        return chipPart.getEndIcon();
    }

    @Override
    public S rehydrate(CoreComponent child) {
        this.chipPart.rehydrate(child);
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
        return chipPart.getElement();
    }

    public HTMLElement getHtmlElement() {
        return chipPart.getHtmlElement();
    }

    public Rect getBoundingBox() {
        return chipPart.getBoundingBox();
    }

    public HTMLElement createOrRehydrateElement(String tagName, String selector) {
        return chipPart.createOrRehydrateElement(tagName, selector);
    }

    public S on(EventType type, EventListener listener) {
        chipPart.on(type, listener);
        return self();
    }

    public S on(Set<EventType> types, EventListener listener) {
        chipPart.on(types, listener);
        return self();
    }

    public void dispatchEvent(EventType type) {
        chipPart.dispatchEvent(type);
    }

    public void click() {
        chipPart.click();
    }

    public boolean isRehydrated() {
        if (chipPart == null)
            return false;

        return chipPart.isRehydrated();
    }

    public Style getComputedStyle() {
        return chipPart.getComputedStyle();
    }

    public S addOrRemoveStyleClass(String styleClass, boolean add) {
        chipPart.addOrRemoveStyleClass(styleClass, add);
        return self();
    }

    public boolean hasStyleClass(String styleClass) {
        return chipPart.hasStyleClass(styleClass);
    }

    public S removeStyleClass(String styleClass) {
        chipPart.removeStyleClass(styleClass);
        return self();
    }

    public S setAttribute(String attribute, String value) {
        chipPart.setAttribute(attribute, value);
        return self();
    }

    public S setAttribute(String attribute) {
        chipPart.setAttribute(attribute);
        return self();
    }

    public S removeAttribute(String attribute) {
        chipPart.removeAttribute(attribute);
        return self();
    }

    public String getAttribute(String attribute) {
        return chipPart.getAttribute(attribute);
    }

    public boolean hasAttribute(String attribute) {
        return chipPart.hasAttribute(attribute);
    }

    public S setData(String data, String value) {
        chipPart.setData(data, value);
        return self();
    }

    public String getData(String data) {
        return chipPart.getData(data);
    }

    public boolean hasData(String data) {
        return chipPart.hasData(data);
    }

    public S setAria(String attribute, String value) {
        chipPart.setAria(attribute, value);
        return self();
    }

    public String getAria(String attribute) {
        return chipPart.getAria(attribute);
    }

    public boolean hasAria(String attribute) {
        return chipPart.hasAria(attribute);
    }

    public String getUniqueId() {
        return chipPart.getUniqueId();
    }

    public String getUniqueStyleClass() {
        return chipPart.getUniqueStyleClass();
    }

    public String getStyleSheetId() {
        return chipPart.getStyleSheetId();
    }

    public String getStyleSheetId(State state) {
        return chipPart.getStyleSheetId(state);
    }

    public Set<State> getStyleStates() {
        return chipPart.getStyleStates();
    }

    public void setStyleSheetFactory(StyleSheetFactory styleSheetFactory) {
        chipPart.setStyleSheetFactory(styleSheetFactory);
    }

    public Style getStyle(State state, Interaction interaction) {
        return chipPart.getStyle(state, interaction);
    }

    public Style getStyle(Interaction interaction) {
        return chipPart.getStyle(interaction);
    }

    public boolean hasWrapper() {
        return chipPart.hasWrapper();
    }

    public boolean isInitialized() {
        return chipPart.isInitialized();
    }

    public void log(Object obj) {
        chipPart.log(obj);
    }

    public void removeFromParent() {
        chipPart.removeFromParent();
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
    public WebFrontendFilterChip getComponent() {
        return ((WebFrontendFilterChip) (baseComponentPart.getComponent()));
    }

    public boolean onPreInitialize(O options) {
        if ((options != null) && options.isRehydrated())
            options.rehydrate(getElement());

        if (!super.onPreInitialize(options))
            return false;

        return true;
    }

    // Implementation
    // Implementation
    // Implementation
    public void onInitialize(O options) {
        super.onInitialize(options);
        if (isHasRemoveIcon()) {
            WebFrontendIcon endIcon = getEndIcon();
            if (endIcon != null) {
                endIcon.getHtmlElement().addEventListener("click", e -> {
                    setSelected(!isSelected());
                    CustomEvent changeEvent = new CustomEvent("change", CustomEventInit.of().detail(JsPropertyMap.of("selected", !isSelected())));
                    getElement().dispatchEvent(changeEvent);
                });
            }
        } else {
            getHtmlElement().addEventListener("click", e -> {
                setSelected(!isSelected());
                CustomEvent changeEvent = new CustomEvent("change", CustomEventInit.of().detail(JsPropertyMap.of("selected", !isSelected())));
                getElement().dispatchEvent(changeEvent);
            });
        }
    }

    public void onCreate(O options) {
        super.onCreate(options);
    }

    public void applyOptions(O options, OptionApplicator applicator, Collection<State> states) {
        super.applyOptions(options, applicator, states);
    }

    public void onInitializeComponentType(RootComponent rootComponent) {
        if (isRehydrated() || ((WebRootComponent) (rootComponent)).isComponentTypeRegistered(getComponent().getClass()))
            return;

        super.onInitializeComponentType(rootComponent);
        chipPart.onInitializeComponentType(rootComponent);
        onInitializeCommonStyle(((WebRootComponent) (rootComponent)).getCommonStyles());
    }

    public void onInitializeCommonStyle(StyleBuilder commonStyles) {
        super.onInitializeCommonStyle(commonStyles);
    }
}

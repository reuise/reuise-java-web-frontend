package dev.reuise.web.frontend.text;
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
import dev.reuise.core.basecomponent.CoreBaseComponentOptions;
import dev.reuise.core.event.EventType;
import dev.reuise.core.option.OptionApplicator;
import dev.reuise.core.theme.Theme;
import dev.reuise.web.core.WebRootComponent;
import dev.reuise.web.core.text.DefaultWebLineBreakPart;
import dev.reuise.web.frontend.ElementDataParser;
import dev.reuise.web.frontend.ElementProvider;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.WebFrontendComponentType;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPart;
import dev.reuise.webstyles.Style;
import dev.reuise.webstyles.StyleBuilder;
import dev.reuise.webstyles.StyleSheetFactory;
import java.util.Collection;
import java.util.Set;
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
public abstract class DefaultWebFrontendLineBreak<S extends DefaultWebFrontendLineBreak<S, O>, O extends WebFrontendLineBreakOptions> extends DefaultWebLineBreakPart<S, O> implements WebFrontendComponentType<S, O> , WebFrontendLineBreak {
    protected final WebFrontendBaseComponentPart baseComponentPart;

    protected DefaultWebFrontendLineBreak(O options) {
        super(options);
        if (options.getComponent() == null)
            options.setComponent(self());

        baseComponentPart = options.getComponentFactory().createBaseComponent(((CoreBaseComponentOptions) (options.getBaseComponentPart())));
        addPart(ComponentPart.Type.BASE, baseComponentPart);
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
        return baseComponentPart.getElement();
    }

    public HTMLElement getHtmlElement() {
        return baseComponentPart.getHtmlElement();
    }

    public Rect getBoundingBox() {
        return baseComponentPart.getBoundingBox();
    }

    public HTMLElement createOrRehydrateElement(String tagName, String selector) {
        return baseComponentPart.createOrRehydrateElement(tagName, selector);
    }

    public S on(EventType type, EventListener listener) {
        baseComponentPart.on(type, listener);
        return self();
    }

    public S on(Set<EventType> types, EventListener listener) {
        baseComponentPart.on(types, listener);
        return self();
    }

    public void dispatchEvent(EventType type) {
        baseComponentPart.dispatchEvent(type);
    }

    public void click() {
        baseComponentPart.click();
    }

    public boolean isRehydrated() {
        if (baseComponentPart == null)
            return false;

        return baseComponentPart.isRehydrated();
    }

    public Style getComputedStyle() {
        return baseComponentPart.getComputedStyle();
    }

    public S addOrRemoveStyleClass(String styleClass, boolean add) {
        baseComponentPart.addOrRemoveStyleClass(styleClass, add);
        return self();
    }

    public boolean hasStyleClass(String styleClass) {
        return baseComponentPart.hasStyleClass(styleClass);
    }

    public S removeStyleClass(String styleClass) {
        baseComponentPart.removeStyleClass(styleClass);
        return self();
    }

    public S setAttribute(String attribute, String value) {
        baseComponentPart.setAttribute(attribute, value);
        return self();
    }

    public S setAttribute(String attribute) {
        baseComponentPart.setAttribute(attribute);
        return self();
    }

    public S removeAttribute(String attribute) {
        baseComponentPart.removeAttribute(attribute);
        return self();
    }

    public String getAttribute(String attribute) {
        return baseComponentPart.getAttribute(attribute);
    }

    public boolean hasAttribute(String attribute) {
        return baseComponentPart.hasAttribute(attribute);
    }

    public S setData(String data, String value) {
        baseComponentPart.setData(data, value);
        return self();
    }

    public String getData(String data) {
        return baseComponentPart.getData(data);
    }

    public boolean hasData(String data) {
        return baseComponentPart.hasData(data);
    }

    public S setAria(String attribute, String value) {
        baseComponentPart.setAria(attribute, value);
        return self();
    }

    public String getAria(String attribute) {
        return baseComponentPart.getAria(attribute);
    }

    public boolean hasAria(String attribute) {
        return baseComponentPart.hasAria(attribute);
    }

    public String getUniqueId() {
        return baseComponentPart.getUniqueId();
    }

    public String getUniqueStyleClass() {
        return baseComponentPart.getUniqueStyleClass();
    }

    public String getStyleSheetId() {
        return baseComponentPart.getStyleSheetId();
    }

    public String getStyleSheetId(State state) {
        return baseComponentPart.getStyleSheetId(state);
    }

    public Set<State> getStyleStates() {
        return baseComponentPart.getStyleStates();
    }

    public void setStyleSheetFactory(StyleSheetFactory styleSheetFactory) {
        baseComponentPart.setStyleSheetFactory(styleSheetFactory);
    }

    public Style getStyle(State state, Interaction interaction) {
        return baseComponentPart.getStyle(state, interaction);
    }

    public Style getStyle(Interaction interaction) {
        return baseComponentPart.getStyle(interaction);
    }

    public boolean hasWrapper() {
        return baseComponentPart.hasWrapper();
    }

    public boolean isInitialized() {
        return baseComponentPart.isInitialized();
    }

    public void log(Object obj) {
        baseComponentPart.log(obj);
    }

    public void removeFromParent() {
        baseComponentPart.removeFromParent();
    }

    @Override
    public WebFrontendComponentFactory getComponentFactory() {
        return ((WebFrontendComponentFactory) (baseComponentPart.getComponentFactory()));
    }

    public WebFrontendBaseComponentPart getBaseComponentPart() {
        return baseComponentPart;
    }

    @Override
    public RootComponent getRootComponent() {
        return baseComponentPart.getRootComponent();
    }

    @Override
    public void setRootComponent(RootComponent rootComponent) {
        this.baseComponentPart.setRootComponent(rootComponent);
    }

    @Override
    public Theme getTheme() {
        return baseComponentPart.getTheme();
    }

    @Override
    public S setTheme(Theme theme) {
        this.baseComponentPart.setTheme(theme);
        return self();
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
    public WebFrontendLineBreak getComponent() {
        return ((WebFrontendLineBreak) (baseComponentPart.getComponent()));
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
        baseComponentPart.onInitializeComponentType(rootComponent);
        onInitializeCommonStyle(((WebRootComponent) (rootComponent)).getCommonStyles());
    }

    public void onInitializeCommonStyle(StyleBuilder commonStyles) {
        super.onInitializeCommonStyle(commonStyles);
    }
}

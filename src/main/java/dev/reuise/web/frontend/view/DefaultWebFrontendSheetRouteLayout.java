package dev.reuise.web.frontend.view;
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
import dev.reuise.core.event.EventType;
import dev.reuise.core.layout.BackdropFilter;
import dev.reuise.core.layout.CoreSheetLayoutOptions;
import dev.reuise.core.option.OptionApplicator;
import dev.reuise.core.theme.Theme;
import dev.reuise.core.view.SheetSize;
import dev.reuise.web.core.WebRootComponent;
import dev.reuise.web.core.view.DefaultWebSheetRouteLayoutPart;
import dev.reuise.web.frontend.ElementDataParser;
import dev.reuise.web.frontend.ElementProvider;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.WebFrontendComponentType;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPart;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
import dev.reuise.web.frontend.layout.WebFrontendContainerPart;
import dev.reuise.web.frontend.layout.WebFrontendSheetLayoutPart;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
import dev.reuise.web.frontend.splitcontainer.WebFrontendSplitContainerDivider;
import dev.reuise.web.frontend.splitcontainer.WebFrontendSplitContainerPanel;
import dev.reuise.web.frontend.splitcontainer.WebFrontendSplitContainerPart;
import dev.reuise.webstyles.Style;
import dev.reuise.webstyles.StyleBuilder;
import dev.reuise.webstyles.StyleSheetFactory;
import java.util.Collection;
import java.util.Set;
// Option: Direction - CORE
// Option: ReverseDirection - CORE
// Option: Resizable - CORE
// Option: SplitPosition - CORE
// Option: MinSplitPosition - CORE
// Option: MaxSplitPosition - CORE
// Option: Animation - WEB
// Option: Padding - CORE
// Option: PaddingTop - CORE
// Option: PaddingRight - CORE
// Option: PaddingBottom - CORE
// Option: PaddingLeft - CORE
// Option: Position - CORE
// Option: Inset - CORE
// Option: BackdropFilter - CORE
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
// base comp: sheetLayout
// add composition for sheetLayout: setSheetSize
// add composition for sheetLayout: setMinSheetSize
// add composition for sheetLayout: setMaxSheetSize
// base comp: splitContainer
// base comp: container
// add composition for container: startAnimation
// add composition for container: cancelAnimation
// add composition for container: addMarkdown
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
public abstract class DefaultWebFrontendSheetRouteLayout<S extends DefaultWebFrontendSheetRouteLayout<S, O>, O extends WebFrontendSheetRouteLayoutOptions> extends DefaultWebSheetRouteLayoutPart<S, O> implements WebFrontendComponentType<S, O> , WebFrontendSheetRouteLayout {
    protected final WebFrontendSheetLayoutPart sheetLayoutPart;

    protected final WebFrontendSplitContainerPart splitContainerPart;

    protected final WebFrontendContainerPart containerPart;

    protected final WebFrontendParentComponentPart parentComponentPart;

    protected final WebFrontendBaseComponentPart baseComponentPart;

    protected DefaultWebFrontendSheetRouteLayout(O options) {
        super(options);
        if (options.getComponent() == null)
            options.setComponent(self());

        sheetLayoutPart = options.getComponentFactory().createSheetLayout(((CoreSheetLayoutOptions) (options.getSheetLayoutPart())));
        splitContainerPart = sheetLayoutPart.getSplitContainerPart();
        containerPart = splitContainerPart.getContainerPart();
        parentComponentPart = containerPart.getParentComponentPart();
        baseComponentPart = parentComponentPart.getBaseComponentPart();
        addPart(ComponentPart.Type.BASE, sheetLayoutPart);
    }

    public S setSheetSize(Object sheetSize) {
        sheetLayoutPart.setSheetSize(sheetSize);
        return self();
    }

    public S setSheetSize(SheetSize sheetSize) {
        sheetLayoutPart.setSheetSize(sheetSize);
        return self();
    }

    public S setMinSheetSize(Object minSheetSize) {
        sheetLayoutPart.setMinSheetSize(minSheetSize);
        return self();
    }

    public S setMaxSheetSize(Object maxSheetSize) {
        sheetLayoutPart.setMaxSheetSize(maxSheetSize);
        return self();
    }

    public WebFrontendSheetLayoutPart getSheetLayoutPart() {
        return sheetLayoutPart;
    }

    @Override
    public RootComponent getRootComponent() {
        return sheetLayoutPart.getRootComponent();
    }

    @Override
    public void setRootComponent(RootComponent rootComponent) {
        super.setRootComponent(rootComponent);
        this.sheetLayoutPart.setRootComponent(rootComponent);
        if (routeLayout != null)
            routeLayout.setRootComponent(rootComponent);

    }

    @Override
    public Theme getTheme() {
        return sheetLayoutPart.getTheme();
    }

    @Override
    public S setTheme(Theme theme) {
        super.setTheme(theme);
        if (routeLayout != null)
            routeLayout.setTheme(theme);

        this.sheetLayoutPart.setTheme(theme);
        return self();
    }

    @Override
    public S rehydrate(CoreComponent child) {
        this.sheetLayoutPart.rehydrate(child);
        child.setParent(self());
        child.setRootComponent(getRootComponent());
        return self();
    }

    public WebFrontendSplitContainerPart getSplitContainerPart() {
        return splitContainerPart;
    }

    @Override
    public WebFrontendContainer getContainer() {
        return splitContainerPart.getContainer();
    }

    @Override
    public WebFrontendSplitContainerPanel getStartPanel() {
        return splitContainerPart.getStartPanel();
    }

    @Override
    public WebFrontendSplitContainerDivider getDivider() {
        return splitContainerPart.getDivider();
    }

    @Override
    public WebFrontendSplitContainerPanel getEndPanel() {
        return splitContainerPart.getEndPanel();
    }

    @Override
    public S setBackdropFilter(BackdropFilter backdropFilter, Object value) {
        this.containerPart.setBackdropFilter(backdropFilter, value);
        return self();
    }

    public S startAnimation() {
        sheetLayoutPart.startAnimation();
        return self();
    }

    public S cancelAnimation() {
        sheetLayoutPart.cancelAnimation();
        return self();
    }

    public S addMarkdown(String markdown) {
        sheetLayoutPart.addMarkdown(markdown);
        return self();
    }

    public WebFrontendContainerPart getContainerPart() {
        return containerPart;
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
        return sheetLayoutPart.getElement();
    }

    public HTMLElement getHtmlElement() {
        return sheetLayoutPart.getHtmlElement();
    }

    public Rect getBoundingBox() {
        return sheetLayoutPart.getBoundingBox();
    }

    public HTMLElement createOrRehydrateElement(String tagName, String selector) {
        return sheetLayoutPart.createOrRehydrateElement(tagName, selector);
    }

    public S on(EventType type, EventListener listener) {
        sheetLayoutPart.on(type, listener);
        return self();
    }

    public S on(Set<EventType> types, EventListener listener) {
        sheetLayoutPart.on(types, listener);
        return self();
    }

    public void dispatchEvent(EventType type) {
        sheetLayoutPart.dispatchEvent(type);
    }

    public void click() {
        sheetLayoutPart.click();
    }

    public boolean isRehydrated() {
        if (sheetLayoutPart == null)
            return false;

        return sheetLayoutPart.isRehydrated();
    }

    public Style getComputedStyle() {
        return sheetLayoutPart.getComputedStyle();
    }

    public S addOrRemoveStyleClass(String styleClass, boolean add) {
        sheetLayoutPart.addOrRemoveStyleClass(styleClass, add);
        return self();
    }

    public boolean hasStyleClass(String styleClass) {
        return sheetLayoutPart.hasStyleClass(styleClass);
    }

    public S removeStyleClass(String styleClass) {
        sheetLayoutPart.removeStyleClass(styleClass);
        return self();
    }

    public S setAttribute(String attribute, String value) {
        sheetLayoutPart.setAttribute(attribute, value);
        return self();
    }

    public S setAttribute(String attribute) {
        sheetLayoutPart.setAttribute(attribute);
        return self();
    }

    public S removeAttribute(String attribute) {
        sheetLayoutPart.removeAttribute(attribute);
        return self();
    }

    public String getAttribute(String attribute) {
        return sheetLayoutPart.getAttribute(attribute);
    }

    public boolean hasAttribute(String attribute) {
        return sheetLayoutPart.hasAttribute(attribute);
    }

    public S setData(String data, String value) {
        sheetLayoutPart.setData(data, value);
        return self();
    }

    public String getData(String data) {
        return sheetLayoutPart.getData(data);
    }

    public boolean hasData(String data) {
        return sheetLayoutPart.hasData(data);
    }

    public S setAria(String attribute, String value) {
        sheetLayoutPart.setAria(attribute, value);
        return self();
    }

    public String getAria(String attribute) {
        return sheetLayoutPart.getAria(attribute);
    }

    public boolean hasAria(String attribute) {
        return sheetLayoutPart.hasAria(attribute);
    }

    public String getUniqueId() {
        return sheetLayoutPart.getUniqueId();
    }

    public String getUniqueStyleClass() {
        return sheetLayoutPart.getUniqueStyleClass();
    }

    public String getStyleSheetId() {
        return sheetLayoutPart.getStyleSheetId();
    }

    public String getStyleSheetId(State state) {
        return sheetLayoutPart.getStyleSheetId(state);
    }

    public Set<State> getStyleStates() {
        return sheetLayoutPart.getStyleStates();
    }

    public void setStyleSheetFactory(StyleSheetFactory styleSheetFactory) {
        sheetLayoutPart.setStyleSheetFactory(styleSheetFactory);
    }

    public Style getStyle(State state, Interaction interaction) {
        return sheetLayoutPart.getStyle(state, interaction);
    }

    public Style getStyle(Interaction interaction) {
        return sheetLayoutPart.getStyle(interaction);
    }

    public boolean hasWrapper() {
        return sheetLayoutPart.hasWrapper();
    }

    public boolean isInitialized() {
        return sheetLayoutPart.isInitialized();
    }

    public void log(Object obj) {
        sheetLayoutPart.log(obj);
    }

    public void removeFromParent() {
        sheetLayoutPart.removeFromParent();
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
    public WebFrontendSheetRouteLayout getComponent() {
        return ((WebFrontendSheetRouteLayout) (baseComponentPart.getComponent()));
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
        sheetLayoutPart.onInitializeComponentType(rootComponent);
        onInitializeCommonStyle(((WebRootComponent) (rootComponent)).getCommonStyles());
    }

    @Override
    public WebFrontendRouteLayout getRouteLayout() {
        return ((WebFrontendRouteLayout) (super.getRouteLayout()));
    }

    public void onInitializeCommonStyle(StyleBuilder commonStyles) {
        super.onInitializeCommonStyle(commonStyles);
    }
}

package dev.reuise.web.frontend.regionselector;
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
import dev.reuise.core.option.OptionApplicator;
import dev.reuise.core.regionselector.Countries;
import dev.reuise.core.regionselector.Country;
import dev.reuise.core.selectmenu.CoreSelectMenuOptions;
import dev.reuise.core.theme.Theme;
import dev.reuise.web.core.WebRootComponent;
import dev.reuise.web.core.regionselector.DefaultWebRegionSelectorPart;
import dev.reuise.web.frontend.BrowserLocale;
import dev.reuise.web.frontend.ElementDataParser;
import dev.reuise.web.frontend.ElementProvider;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.WebFrontendComponentType;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPart;
import dev.reuise.web.frontend.input.WebFrontendTextField;
import dev.reuise.web.frontend.list.WebFrontendListItem;
import dev.reuise.web.frontend.menu.WebFrontendMenu;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
import dev.reuise.web.frontend.selectmenu.WebFrontendSelectMenuPart;
import dev.reuise.webstyles.Style;
import dev.reuise.webstyles.StyleBuilder;
import dev.reuise.webstyles.StyleSheetFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
// Option: Items - CORE
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
// base comp: selectMenu
// add composition for selectMenu: addItem
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
public abstract class DefaultWebFrontendRegionSelector<S extends DefaultWebFrontendRegionSelector<S, O>, O extends WebFrontendRegionSelectorOptions> extends DefaultWebRegionSelectorPart<S, O> implements WebFrontendComponentType<S, O> , WebFrontendRegionSelector {
    private static boolean containsIgnoreCase(List<String> list, String value) {
        for (String item : list) {
            if ((item != null) && item.equalsIgnoreCase(value))
                return true;

        }
        return false;
    }

    protected final WebFrontendSelectMenuPart selectMenuPart;

    protected final WebFrontendParentComponentPart parentComponentPart;

    protected final WebFrontendBaseComponentPart baseComponentPart;

    protected DefaultWebFrontendRegionSelector(O options) {
        super(options);
        if (options.getComponent() == null)
            options.setComponent(self());

        selectMenuPart = options.getComponentFactory().createSelectMenu(((CoreSelectMenuOptions) (options.getSelectMenuPart())));
        parentComponentPart = selectMenuPart.getParentComponentPart();
        baseComponentPart = parentComponentPart.getBaseComponentPart();
        addPart(ComponentPart.Type.BASE, selectMenuPart);
    }

    public S addItem(WebFrontendListItem item) {
        selectMenuPart.addItem(item);
        return self();
    }

    public S addItem(String text) {
        selectMenuPart.addItem(text);
        return self();
    }

    public WebFrontendSelectMenuPart getSelectMenuPart() {
        return selectMenuPart;
    }

    @Override
    public RootComponent getRootComponent() {
        return selectMenuPart.getRootComponent();
    }

    @Override
    public void setRootComponent(RootComponent rootComponent) {
        this.selectMenuPart.setRootComponent(rootComponent);
    }

    @Override
    public Theme getTheme() {
        return selectMenuPart.getTheme();
    }

    @Override
    public S setTheme(Theme theme) {
        this.selectMenuPart.setTheme(theme);
        return self();
    }

    @Override
    public WebFrontendTextField getTextField() {
        return selectMenuPart.getTextField();
    }

    @Override
    public WebFrontendMenu getMenu() {
        return selectMenuPart.getMenu();
    }

    @Override
    public S rehydrate(CoreComponent child) {
        this.selectMenuPart.rehydrate(child);
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
        return selectMenuPart.getElement();
    }

    public HTMLElement getHtmlElement() {
        return selectMenuPart.getHtmlElement();
    }

    public Rect getBoundingBox() {
        return selectMenuPart.getBoundingBox();
    }

    public HTMLElement createOrRehydrateElement(String tagName, String selector) {
        return selectMenuPart.createOrRehydrateElement(tagName, selector);
    }

    public S on(EventType type, EventListener listener) {
        selectMenuPart.on(type, listener);
        return self();
    }

    public S on(Set<EventType> types, EventListener listener) {
        selectMenuPart.on(types, listener);
        return self();
    }

    public void dispatchEvent(EventType type) {
        selectMenuPart.dispatchEvent(type);
    }

    public void click() {
        selectMenuPart.click();
    }

    public boolean isRehydrated() {
        if (selectMenuPart == null)
            return false;

        return selectMenuPart.isRehydrated();
    }

    public Style getComputedStyle() {
        return selectMenuPart.getComputedStyle();
    }

    public S addOrRemoveStyleClass(String styleClass, boolean add) {
        selectMenuPart.addOrRemoveStyleClass(styleClass, add);
        return self();
    }

    public boolean hasStyleClass(String styleClass) {
        return selectMenuPart.hasStyleClass(styleClass);
    }

    public S removeStyleClass(String styleClass) {
        selectMenuPart.removeStyleClass(styleClass);
        return self();
    }

    public S setAttribute(String attribute, String value) {
        selectMenuPart.setAttribute(attribute, value);
        return self();
    }

    public S setAttribute(String attribute) {
        selectMenuPart.setAttribute(attribute);
        return self();
    }

    public S removeAttribute(String attribute) {
        selectMenuPart.removeAttribute(attribute);
        return self();
    }

    public String getAttribute(String attribute) {
        return selectMenuPart.getAttribute(attribute);
    }

    public boolean hasAttribute(String attribute) {
        return selectMenuPart.hasAttribute(attribute);
    }

    public S setData(String data, String value) {
        selectMenuPart.setData(data, value);
        return self();
    }

    public String getData(String data) {
        return selectMenuPart.getData(data);
    }

    public boolean hasData(String data) {
        return selectMenuPart.hasData(data);
    }

    public S setAria(String attribute, String value) {
        selectMenuPart.setAria(attribute, value);
        return self();
    }

    public String getAria(String attribute) {
        return selectMenuPart.getAria(attribute);
    }

    public boolean hasAria(String attribute) {
        return selectMenuPart.hasAria(attribute);
    }

    public String getUniqueId() {
        return selectMenuPart.getUniqueId();
    }

    public String getUniqueStyleClass() {
        return selectMenuPart.getUniqueStyleClass();
    }

    public String getStyleSheetId() {
        return selectMenuPart.getStyleSheetId();
    }

    public String getStyleSheetId(State state) {
        return selectMenuPart.getStyleSheetId(state);
    }

    public Set<State> getStyleStates() {
        return selectMenuPart.getStyleStates();
    }

    public void setStyleSheetFactory(StyleSheetFactory styleSheetFactory) {
        selectMenuPart.setStyleSheetFactory(styleSheetFactory);
    }

    public Style getStyle(State state, Interaction interaction) {
        return selectMenuPart.getStyle(state, interaction);
    }

    public Style getStyle(Interaction interaction) {
        return selectMenuPart.getStyle(interaction);
    }

    public boolean hasWrapper() {
        return selectMenuPart.hasWrapper();
    }

    public boolean isInitialized() {
        return selectMenuPart.isInitialized();
    }

    public void log(Object obj) {
        selectMenuPart.log(obj);
    }

    public void removeFromParent() {
        selectMenuPart.removeFromParent();
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
    public WebFrontendRegionSelector getComponent() {
        return ((WebFrontendRegionSelector) (baseComponentPart.getComponent()));
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
        if (!options.isDefaultFromBrowser())
            return;

        String current = getTextField().getValue();
        if ((current != null) && (!current.isEmpty()))
            return;

        Country country = Countries.getByCode(BrowserLocale.getRegion());
        if (country == null)
            return;

        List<String> regions = options.getRegions();
        if (((regions != null) && (!regions.isEmpty())) && (!containsIgnoreCase(regions, country.getCode())))
            return;

        getTextField().setValue(country.getName());
    }

    public void applyOptions(O options, OptionApplicator applicator, Collection<State> states) {
        super.applyOptions(options, applicator, states);
    }

    public void onInitializeComponentType(RootComponent rootComponent) {
        if (isRehydrated() || ((WebRootComponent) (rootComponent)).isComponentTypeRegistered(getComponent().getClass()))
            return;

        super.onInitializeComponentType(rootComponent);
        selectMenuPart.onInitializeComponentType(rootComponent);
        onInitializeCommonStyle(((WebRootComponent) (rootComponent)).getCommonStyles());
    }

    public void onInitializeCommonStyle(StyleBuilder commonStyles) {
        super.onInitializeCommonStyle(commonStyles);
    }

    @Override
    public S setRegion(String region) {
        setRegions(new ArrayList<String>(Arrays.asList(region)));
        return self();
    }
}

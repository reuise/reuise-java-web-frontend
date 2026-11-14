package dev.reuise.web.frontend.chip;
import akasha.CustomEvent;
import akasha.CustomEventInit;
import akasha.Element;
import akasha.EventListener;
import akasha.HTMLCollection;
import akasha.HTMLElement;
import akasha.MutationObserver;
import akasha.MutationObserverInit;
import akasha.MutationRecord;
import akasha.Node;
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
import dev.reuise.core.layout.CoreFieldSetOptions;
import dev.reuise.core.option.OptionApplicator;
import dev.reuise.core.theme.Theme;
import dev.reuise.web.core.WebRootComponent;
import dev.reuise.web.core.chip.DefaultWebChipGroupPart;
import dev.reuise.web.frontend.ElementDataParser;
import dev.reuise.web.frontend.ElementProvider;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.WebFrontendComponentType;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPart;
import dev.reuise.web.frontend.layout.WebFrontendContainerPart;
import dev.reuise.web.frontend.layout.WebFrontendFieldSetPart;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
import dev.reuise.webstyles.Style;
import dev.reuise.webstyles.StyleBuilder;
import dev.reuise.webstyles.StyleSheetFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import jsinterop.base.JsPropertyMap;
// Option: Label - CORE
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
// base comp: fieldSet
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
public abstract class DefaultWebFrontendChipGroup<S extends DefaultWebFrontendChipGroup<S, O>, O extends WebFrontendChipGroupOptions> extends DefaultWebChipGroupPart<S, O> implements WebFrontendChipGroup , WebFrontendComponentType<S, O> {
    private MutationObserver mutationObserver;

    private List<String> getSelectedChips() {
        List<String> selected = new ArrayList<>();
        HTMLCollection children = getHtmlElement().children();
        for (int c = 0; c < children.length(); c++) {
            Element chipEl = children.item(c);
            if (!(chipEl instanceof HTMLElement))
                continue;

            if ((chipEl instanceof HTMLElement) && ((HTMLElement) (chipEl)).classList().contains("reuise-chip--selected"))
                selected.add(chipEl.getAttribute("data-value"));

        }
        return selected;
    }

    @Override
    public List<String> getSelected() {
        return getSelectedChips();
    }

    @Override
    public boolean hasSelected(String selected) {
        return getSelectedChips().contains(selected);
    }

    protected final WebFrontendFieldSetPart fieldSetPart;

    protected final WebFrontendContainerPart containerPart;

    protected final WebFrontendParentComponentPart parentComponentPart;

    protected final WebFrontendBaseComponentPart baseComponentPart;

    protected DefaultWebFrontendChipGroup(O options) {
        super(options);
        if (options.getComponent() == null)
            options.setComponent(self());

        fieldSetPart = options.getComponentFactory().createFieldSet(((CoreFieldSetOptions) (options.getFieldSetPart())));
        containerPart = fieldSetPart.getContainerPart();
        parentComponentPart = containerPart.getParentComponentPart();
        baseComponentPart = parentComponentPart.getBaseComponentPart();
        addPart(ComponentPart.Type.BASE, fieldSetPart);
    }

    public WebFrontendFieldSetPart getFieldSetPart() {
        return fieldSetPart;
    }

    @Override
    public RootComponent getRootComponent() {
        return fieldSetPart.getRootComponent();
    }

    @Override
    public void setRootComponent(RootComponent rootComponent) {
        super.setRootComponent(rootComponent);
        this.fieldSetPart.setRootComponent(rootComponent);
        if (addButton != null)
            addButton.setRootComponent(rootComponent);

    }

    @Override
    public Theme getTheme() {
        return fieldSetPart.getTheme();
    }

    @Override
    public S setTheme(Theme theme) {
        super.setTheme(theme);
        if (addButton != null)
            addButton.setTheme(theme);

        this.fieldSetPart.setTheme(theme);
        return self();
    }

    @Override
    public S rehydrate(CoreComponent child) {
        this.fieldSetPart.rehydrate(child);
        child.setParent(self());
        child.setRootComponent(getRootComponent());
        return self();
    }

    @Override
    public S setBackdropFilter(BackdropFilter backdropFilter, Object value) {
        this.containerPart.setBackdropFilter(backdropFilter, value);
        return self();
    }

    public S startAnimation() {
        fieldSetPart.startAnimation();
        return self();
    }

    public S cancelAnimation() {
        fieldSetPart.cancelAnimation();
        return self();
    }

    public S addMarkdown(String markdown) {
        fieldSetPart.addMarkdown(markdown);
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
        return fieldSetPart.getElement();
    }

    public HTMLElement getHtmlElement() {
        return fieldSetPart.getHtmlElement();
    }

    public Rect getBoundingBox() {
        return fieldSetPart.getBoundingBox();
    }

    public HTMLElement createOrRehydrateElement(String tagName, String selector) {
        return fieldSetPart.createOrRehydrateElement(tagName, selector);
    }

    public S on(EventType type, EventListener listener) {
        fieldSetPart.on(type, listener);
        return self();
    }

    public S on(Set<EventType> types, EventListener listener) {
        fieldSetPart.on(types, listener);
        return self();
    }

    public void dispatchEvent(EventType type) {
        fieldSetPart.dispatchEvent(type);
    }

    public void click() {
        fieldSetPart.click();
    }

    public boolean isRehydrated() {
        if (fieldSetPart == null)
            return false;

        return fieldSetPart.isRehydrated();
    }

    public Style getComputedStyle() {
        return fieldSetPart.getComputedStyle();
    }

    public S addOrRemoveStyleClass(String styleClass, boolean add) {
        fieldSetPart.addOrRemoveStyleClass(styleClass, add);
        return self();
    }

    public boolean hasStyleClass(String styleClass) {
        return fieldSetPart.hasStyleClass(styleClass);
    }

    public S removeStyleClass(String styleClass) {
        fieldSetPart.removeStyleClass(styleClass);
        return self();
    }

    public S setAttribute(String attribute, String value) {
        fieldSetPart.setAttribute(attribute, value);
        return self();
    }

    public S setAttribute(String attribute) {
        fieldSetPart.setAttribute(attribute);
        return self();
    }

    public S removeAttribute(String attribute) {
        fieldSetPart.removeAttribute(attribute);
        return self();
    }

    public String getAttribute(String attribute) {
        return fieldSetPart.getAttribute(attribute);
    }

    public boolean hasAttribute(String attribute) {
        return fieldSetPart.hasAttribute(attribute);
    }

    public S setData(String data, String value) {
        fieldSetPart.setData(data, value);
        return self();
    }

    public String getData(String data) {
        return fieldSetPart.getData(data);
    }

    public boolean hasData(String data) {
        return fieldSetPart.hasData(data);
    }

    public S setAria(String attribute, String value) {
        fieldSetPart.setAria(attribute, value);
        return self();
    }

    public String getAria(String attribute) {
        return fieldSetPart.getAria(attribute);
    }

    public boolean hasAria(String attribute) {
        return fieldSetPart.hasAria(attribute);
    }

    public String getUniqueId() {
        return fieldSetPart.getUniqueId();
    }

    public String getUniqueStyleClass() {
        return fieldSetPart.getUniqueStyleClass();
    }

    public String getStyleSheetId() {
        return fieldSetPart.getStyleSheetId();
    }

    public String getStyleSheetId(State state) {
        return fieldSetPart.getStyleSheetId(state);
    }

    public Set<State> getStyleStates() {
        return fieldSetPart.getStyleStates();
    }

    public void setStyleSheetFactory(StyleSheetFactory styleSheetFactory) {
        fieldSetPart.setStyleSheetFactory(styleSheetFactory);
    }

    public Style getStyle(State state, Interaction interaction) {
        return fieldSetPart.getStyle(state, interaction);
    }

    public Style getStyle(Interaction interaction) {
        return fieldSetPart.getStyle(interaction);
    }

    public boolean hasWrapper() {
        return fieldSetPart.hasWrapper();
    }

    public boolean isInitialized() {
        return fieldSetPart.isInitialized();
    }

    public void log(Object obj) {
        fieldSetPart.log(obj);
    }

    public void removeFromParent() {
        fieldSetPart.removeFromParent();
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
    public WebFrontendChipGroup getComponent() {
        return ((WebFrontendChipGroup) (baseComponentPart.getComponent()));
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
        mutationObserver = new MutationObserver((mutations, observer) -> {
            HTMLElement htmlEl = getHtmlElement();
            boolean fireEvent = false;
            for (MutationRecord mutation : mutations.asArray(new MutationRecord[0])) {
                if ((!mutation.type().equals("attributes")) || (!mutation.attributeName().equals("class")))
                    continue;

                Node target = mutation.target();
                if (((target.nodeType() != Node.ELEMENT_NODE) || (!(target instanceof HTMLElement))) || (target.parentElement() != htmlEl))
                    continue;

                HTMLElement chipEl = ((HTMLElement) (target));
                if (chipEl.classList().contains("reuise-filterchip"))
                    fireEvent = true;

            }
            if (fireEvent) {
                CustomEvent changeEvent = new CustomEvent("change", CustomEventInit.of().detail(JsPropertyMap.of("selected", getSelectedChips())));
                getElement().dispatchEvent(changeEvent);
            }
        });
        mutationObserver.observe(getHtmlElement(), MutationObserverInit.of().subtree(true).attributes(true).attributeFilter("class"));
    }

    public void applyOptions(O options, OptionApplicator applicator, Collection<State> states) {
        super.applyOptions(options, applicator, states);
    }

    public void onInitializeComponentType(RootComponent rootComponent) {
        if (isRehydrated() || ((WebRootComponent) (rootComponent)).isComponentTypeRegistered(getComponent().getClass()))
            return;

        super.onInitializeComponentType(rootComponent);
        fieldSetPart.onInitializeComponentType(rootComponent);
        onInitializeCommonStyle(((WebRootComponent) (rootComponent)).getCommonStyles());
    }

    @Override
    public WebFrontendChip getAddButton() {
        return ((WebFrontendChip) (super.getAddButton()));
    }

    public void onInitializeCommonStyle(StyleBuilder commonStyles) {
        super.onInitializeCommonStyle(commonStyles);
    }
}

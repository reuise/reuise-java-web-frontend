package dev.reuise.web.frontend.card;
import akasha.CSSStyleDeclaration;
import akasha.Element;
import akasha.EventListener;
import akasha.HTMLElement;
import akasha.MutationObserver;
import akasha.MutationObserverInit;
import akasha.Node;
import akasha.ResizeObserver;
import akasha.WindowGlobal;
import dev.reuise.core.ComponentPart;
import dev.reuise.core.ComponentType;
import dev.reuise.core.CoreComponent;
import dev.reuise.core.CoreComponentOptions;
import dev.reuise.core.Interaction;
import dev.reuise.core.Rect;
import dev.reuise.core.RootComponent;
import dev.reuise.core.ScreenSizeValues;
import dev.reuise.core.State;
import dev.reuise.core.card.CardGridPositionMode;
import dev.reuise.core.event.EventType;
import dev.reuise.core.layout.BackdropFilter;
import dev.reuise.core.layout.CoreContainerOptions;
import dev.reuise.core.option.OptionApplicator;
import dev.reuise.core.theme.Theme;
import dev.reuise.web.core.WebRootComponent;
import dev.reuise.web.core.card.DefaultWebCardGridPart;
import dev.reuise.web.frontend.ElementDataParser;
import dev.reuise.web.frontend.ElementProvider;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.WebFrontendComponentType;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPart;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
import dev.reuise.web.frontend.layout.WebFrontendContainerPart;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
import dev.reuise.webstyles.Style;
import dev.reuise.webstyles.StyleBuilder;
import dev.reuise.webstyles.StyleSheetFactory;
import java.util.Collection;
import java.util.Set;
import java.util.function.Function;
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
public abstract class DefaultWebFrontendCardGrid<S extends DefaultWebFrontendCardGrid<S, O>, O extends WebFrontendCardGridOptions> extends DefaultWebCardGridPart<S, O> implements WebFrontendCardGrid , WebFrontendComponentType<S, O> {
    private ResizeObserver resizeObserver;

    private MutationObserver mutationObserver;

    private int colGap;

    private int rowGap;

    private int cardWidth;

    private int cardHeight;

    private int numColumns = 0;

    private int numRows = 0;

    private int containerWidth;

    private int remainingSpace = 0;

    private int remainingSpacePerCol = 0;

    private HTMLElement htmlElement;

    private boolean animationEnabled;

    private void setHover(HTMLElement el, boolean active) {
        if (active)
            el.classList().add("reuise-cardgrid_card--hover");
        else
            el.classList().remove("reuise-cardgrid_card--hover");

    }

    private void setActive(HTMLElement el, boolean active) {
        if (active)
            el.classList().add("reuise-cardgrid_card--active");
        else
            el.classList().remove("reuise-cardgrid_card--active");

    }

    private void setActive(Function<HTMLElement, Boolean> callback) {
        HTMLElement el = ((HTMLElement) (htmlElement.firstElementChild()));
        boolean hasActive = false;
        while (el != null) {
            if (isCard(el)) {
                boolean active = callback.apply(el);
                if (active)
                    hasActive = true;

                setActive(el, active);
            }
            el = ((HTMLElement) (el.nextElementSibling()));
        } 
        addOrRemoveStyleClass("reuise-cardgrid--hasactivecard", hasActive);
        showScrim(hasActive);
    }

    private void layout(boolean animate) {
        calculateLayout();
        HTMLElement el = ((HTMLElement) (htmlElement.firstElementChild()));
        int c = 0;
        int left = colGap;
        int top = rowGap;
        while (el != null) {
            if (isCard(el)) {
                CSSStyleDeclaration elStyle = el.style();
                if (isCardVisible(el)) {
                    elStyle.setProperty("left", left + "px");
                    elStyle.setProperty("top", top + "px");
                    elStyle.setProperty("width", (cardWidth + remainingSpacePerCol) + "px");
                    elStyle.setProperty("height", cardHeight + "px");
                    if (animate)
                        el.classList().add("reuise-cardgrid_card--hidden");

                    left += (cardWidth + colGap) + remainingSpacePerCol;
                    if (((left + cardWidth) + colGap) > containerWidth) {
                        left = colGap;
                        top += cardHeight + rowGap;
                    }
                    if (animate)
                        showCard(el, c * 100);

                    c++;
                }
            }
            el = ((HTMLElement) (el.nextElementSibling()));
        } 
    }

    private void calculateLayout() {
        colGap = getColumnGap();
        rowGap = getRowGap();
        cardWidth = getCardWidth();
        cardHeight = getCardHeight();
        containerWidth = containerPart.getHtmlElement().clientWidth() - colGap;
        HTMLElement el = ((HTMLElement) (htmlElement.firstElementChild()));
        numRows = 0;
        numColumns = 0;
        int i = 0;
        int left = 0;
        while (el != null) {
            if (isCard(el) && isCardVisible(el)) {
                left += cardWidth + colGap;
                if (((left + cardWidth) + colGap) > containerWidth) {
                    if (numColumns == 0) {
                        numColumns = i + 1;
                        remainingSpace = containerWidth - left;
                    }
                    left = colGap;
                    numRows++;
                }
                i++;
            }
            el = ((HTMLElement) (el.nextElementSibling()));
        } 
        if (numColumns != 0)
            remainingSpacePerCol = remainingSpace / numColumns;
        else
            remainingSpacePerCol = 0;

    }

    private boolean isCard(HTMLElement el) {
        return el.classList().contains("reuise-card");
    }

    private boolean isCardVisible(HTMLElement el) {
        String elDisplay = el.style().getPropertyValue("display");
        return (elDisplay != null) && (!elDisplay.equals("none"));
    }

    private void showCard(HTMLElement el, int timeout) {
        WindowGlobal.setTimeout(() -> el.classList().remove("reuise-cardgrid_card--hidden"), timeout);
    }

    protected final WebFrontendContainerPart containerPart;

    protected final WebFrontendParentComponentPart parentComponentPart;

    protected final WebFrontendBaseComponentPart baseComponentPart;

    protected DefaultWebFrontendCardGrid(O options) {
        super(options);
        if (options.getComponent() == null)
            options.setComponent(self());

        containerPart = options.getComponentFactory().createContainer(((CoreContainerOptions) (options.getContainerPart())));
        parentComponentPart = containerPart.getParentComponentPart();
        baseComponentPart = parentComponentPart.getBaseComponentPart();
        addPart(ComponentPart.Type.BASE, containerPart);
    }

    @Override
    public S setBackdropFilter(BackdropFilter backdropFilter, Object value) {
        this.containerPart.setBackdropFilter(backdropFilter, value);
        return self();
    }

    public S startAnimation() {
        containerPart.startAnimation();
        return self();
    }

    public S cancelAnimation() {
        containerPart.cancelAnimation();
        return self();
    }

    public S addMarkdown(String markdown) {
        containerPart.addMarkdown(markdown);
        return self();
    }

    public WebFrontendContainerPart getContainerPart() {
        return containerPart;
    }

    @Override
    public RootComponent getRootComponent() {
        return containerPart.getRootComponent();
    }

    // Implementation
    @Override
    public void setRootComponent(RootComponent rootComponent) {
        super.setRootComponent(rootComponent);
        this.containerPart.setRootComponent(rootComponent);
        CardGridPositionMode positionMode = getPositionMode();
        if (positionMode == CardGridPositionMode.ABSOLUTE)
            layout(animationEnabled);

    }

    @Override
    public Theme getTheme() {
        return containerPart.getTheme();
    }

    @Override
    public S setTheme(Theme theme) {
        super.setTheme(theme);
        if (scrim != null)
            scrim.setTheme(theme);

        if (cardContainer != null)
            cardContainer.setTheme(theme);

        this.containerPart.setTheme(theme);
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
        return containerPart.getElement();
    }

    public HTMLElement getHtmlElement() {
        return containerPart.getHtmlElement();
    }

    public Rect getBoundingBox() {
        return containerPart.getBoundingBox();
    }

    public HTMLElement createOrRehydrateElement(String tagName, String selector) {
        return containerPart.createOrRehydrateElement(tagName, selector);
    }

    public S on(EventType type, EventListener listener) {
        containerPart.on(type, listener);
        return self();
    }

    public S on(Set<EventType> types, EventListener listener) {
        containerPart.on(types, listener);
        return self();
    }

    public void dispatchEvent(EventType type) {
        containerPart.dispatchEvent(type);
    }

    public void click() {
        containerPart.click();
    }

    public boolean isRehydrated() {
        if (containerPart == null)
            return false;

        return containerPart.isRehydrated();
    }

    public Style getComputedStyle() {
        return containerPart.getComputedStyle();
    }

    public S addOrRemoveStyleClass(String styleClass, boolean add) {
        containerPart.addOrRemoveStyleClass(styleClass, add);
        return self();
    }

    public boolean hasStyleClass(String styleClass) {
        return containerPart.hasStyleClass(styleClass);
    }

    public S removeStyleClass(String styleClass) {
        containerPart.removeStyleClass(styleClass);
        return self();
    }

    public S setAttribute(String attribute, String value) {
        containerPart.setAttribute(attribute, value);
        return self();
    }

    public S setAttribute(String attribute) {
        containerPart.setAttribute(attribute);
        return self();
    }

    public S removeAttribute(String attribute) {
        containerPart.removeAttribute(attribute);
        return self();
    }

    public String getAttribute(String attribute) {
        return containerPart.getAttribute(attribute);
    }

    public boolean hasAttribute(String attribute) {
        return containerPart.hasAttribute(attribute);
    }

    public S setData(String data, String value) {
        containerPart.setData(data, value);
        return self();
    }

    public String getData(String data) {
        return containerPart.getData(data);
    }

    public boolean hasData(String data) {
        return containerPart.hasData(data);
    }

    public S setAria(String attribute, String value) {
        containerPart.setAria(attribute, value);
        return self();
    }

    public String getAria(String attribute) {
        return containerPart.getAria(attribute);
    }

    public boolean hasAria(String attribute) {
        return containerPart.hasAria(attribute);
    }

    public String getUniqueId() {
        return containerPart.getUniqueId();
    }

    public String getUniqueStyleClass() {
        return containerPart.getUniqueStyleClass();
    }

    public String getStyleSheetId() {
        return containerPart.getStyleSheetId();
    }

    public String getStyleSheetId(State state) {
        return containerPart.getStyleSheetId(state);
    }

    public Set<State> getStyleStates() {
        return containerPart.getStyleStates();
    }

    public void setStyleSheetFactory(StyleSheetFactory styleSheetFactory) {
        containerPart.setStyleSheetFactory(styleSheetFactory);
    }

    public Style getStyle(State state, Interaction interaction) {
        return containerPart.getStyle(state, interaction);
    }

    public Style getStyle(Interaction interaction) {
        return containerPart.getStyle(interaction);
    }

    public boolean hasWrapper() {
        return containerPart.hasWrapper();
    }

    public boolean isInitialized() {
        return containerPart.isInitialized();
    }

    public void log(Object obj) {
        containerPart.log(obj);
    }

    public void removeFromParent() {
        containerPart.removeFromParent();
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
    public WebFrontendCardGrid getComponent() {
        return ((WebFrontendCardGrid) (baseComponentPart.getComponent()));
    }

    public boolean onPreInitialize(O options) {
        if ((options != null) && options.isRehydrated())
            options.rehydrate(getElement());

        if (!super.onPreInitialize(options))
            return false;

        return true;
    }

    @Override
    public S rehydrate(CoreComponent child) {
        ((WebFrontendContainerPart) (getCardContainer())).rehydrate(child);
        return self();
    }

    public void onInitialize(O options) {
        super.onInitialize(options);
    }

    // Implementation
    // Implementation
    public void onCreate(O options) {
        super.onCreate(options);
        animationEnabled = isAnimationEnabled();
        CardGridPositionMode positionMode = getPositionMode();
        if (positionMode == CardGridPositionMode.ABSOLUTE) {
            htmlElement = ((HTMLElement) (((WebFrontendContainer) (cardContainer)).getHtmlElement()));
            mutationObserver = new MutationObserver((entries, observer) -> {
                layout(false);
            });
            mutationObserver.observe(htmlElement, MutationObserverInit.of().childList(true));
            resizeObserver = new ResizeObserver((entries, observer) -> {
                layout(false);
            });
            layout(false);
            resizeObserver.observe(getElement());
        }
        if (Boolean.TRUE.equals(expandableCards)) {
            htmlElement.addEventListener("click", e -> {
                setActive(el -> (e.target() == el) || el.contains(((Node) (e.target()))));
            });
            htmlElement.addEventListener("mouseenter", e -> {
                HTMLElement el = ((HTMLElement) (htmlElement.firstElementChild()));
                while (el != null) {
                    if (isCard(el))
                        setHover(el, (e.target() == el) || el.contains(((Node) (e.target()))));

                    el = ((HTMLElement) (el.nextElementSibling()));
                } 
            });
            htmlElement.addEventListener("mouseleave", e -> {
                HTMLElement el = ((HTMLElement) (htmlElement.firstElementChild()));
                while (el != null) {
                    if (isCard(el) && ((e.target() == el) || el.contains(((Node) (e.target())))))
                        setHover(el, false);

                    el = ((HTMLElement) (el.nextElementSibling()));
                } 
            });
            ((WebFrontendContainer) (scrim)).getHtmlElement().addEventListener("click", e -> setActive(el -> false));
        }
    }

    public void applyOptions(O options, OptionApplicator applicator, Collection<State> states) {
        super.applyOptions(options, applicator, states);
    }

    public void onInitializeComponentType(RootComponent rootComponent) {
        if (isRehydrated() || ((WebRootComponent) (rootComponent)).isComponentTypeRegistered(getComponent().getClass()))
            return;

        super.onInitializeComponentType(rootComponent);
        containerPart.onInitializeComponentType(rootComponent);
        onInitializeCommonStyle(((WebRootComponent) (rootComponent)).getCommonStyles());
    }

    @Override
    public WebFrontendContainer getScrim() {
        return ((WebFrontendContainer) (super.getScrim()));
    }

    @Override
    public WebFrontendContainer getCardContainer() {
        return ((WebFrontendContainer) (super.getCardContainer()));
    }

    public void onInitializeCommonStyle(StyleBuilder commonStyles) {
        super.onInitializeCommonStyle(commonStyles);
    }

    @Override
    public S setColumnGapAllStates(Integer columnGap) {
        setColumnGap(ScreenSizeValues.of(columnGap, columnGap));
        setColumnGap(columnGap);
        return self();
    }

    @Override
    public S setRowGapAllStates(Integer rowGap) {
        setRowGap(ScreenSizeValues.of(rowGap, rowGap));
        setRowGap(rowGap);
        return self();
    }

    @Override
    public S setGapAllStates(Integer gap) {
        setGap(ScreenSizeValues.of(gap, gap));
        setGap(gap);
        return self();
    }

    @Override
    public S setCardWidthAllStates(Integer cardWidth) {
        setCardWidth(ScreenSizeValues.of(cardWidth, cardWidth));
        setCardWidth(cardWidth);
        return self();
    }

    @Override
    public S setCardHeightAllStates(Integer cardHeight) {
        setCardHeight(ScreenSizeValues.of(cardHeight, cardHeight));
        setCardHeight(cardHeight);
        return self();
    }
}

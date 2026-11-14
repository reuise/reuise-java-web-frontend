package dev.reuise.web.frontend.scrollablecontainer;
import akasha.Element;
import akasha.EventListener;
import akasha.HTMLElement;
import akasha.MouseEvent;
import akasha.ResizeObserver;
import akasha.ScrollToOptions;
import akasha.WindowGlobal;
import dev.reuise.core.Axis;
import dev.reuise.core.ComponentPart;
import dev.reuise.core.ComponentType;
import dev.reuise.core.CoreComponent;
import dev.reuise.core.CoreComponentOptions;
import dev.reuise.core.Interaction;
import dev.reuise.core.Rect;
import dev.reuise.core.RootComponent;
import dev.reuise.core.Side;
import dev.reuise.core.State;
import dev.reuise.core.event.EventType;
import dev.reuise.core.event.Events;
import dev.reuise.core.layout.BackdropFilter;
import dev.reuise.core.layout.CoreContainer;
import dev.reuise.core.layout.CoreContainerOptions;
import dev.reuise.core.option.OptionApplicator;
import dev.reuise.core.scrollablecontainer.ScrollDirection;
import dev.reuise.core.scrollablecontainer.ScrollIncrement;
import dev.reuise.core.scrollablecontainer.ScrollableContainerFadeOptions;
import dev.reuise.core.scrollablecontainer.ScrollableContainerScrollBehavior;
import dev.reuise.core.theme.Theme;
import dev.reuise.web.core.WebRootComponent;
import dev.reuise.web.core.event.Event;
import dev.reuise.web.core.layout.WebContainer;
import dev.reuise.web.core.scrollablecontainer.DefaultWebScrollableContainerPart;
import dev.reuise.web.core.scrollablecontainer.WebScrollableContainerEdge;
import dev.reuise.web.frontend.ElementDataParser;
import dev.reuise.web.frontend.ElementProvider;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.WebFrontendComponentType;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPart;
import dev.reuise.web.frontend.button.DefaultWebFrontendButton;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
import dev.reuise.web.frontend.layout.WebFrontendContainerPart;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
import dev.reuise.webstyles.Style;
import dev.reuise.webstyles.StyleBuilder;
import dev.reuise.webstyles.StyleSheetFactory;
import java.util.Collection;
import java.util.Set;
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
public abstract class DefaultWebFrontendScrollableContainer<S extends DefaultWebFrontendScrollableContainer<S, O>, O extends WebFrontendScrollableContainerOptions> extends DefaultWebScrollableContainerPart<S, O> implements WebFrontendComponentType<S, O> , WebFrontendScrollableContainer {
    private static final int SCROLL_AMOUNT = 5;

    private static final int SCROLL_INTERVAL = 10;

    private ScrollableContainerFadeOptions fadeOpts;

    private ScrollableContainerScrollBehavior scrollBehavior;

    private ScrollIncrement scrollIncrement;

    private boolean continuousScroll;

    private HTMLElement scrollAreaEl;

    private int scrollIntervalID = 0;

    private Side scrollSide;

    private ResizeObserver resizeObserver;

    private boolean mouseDown = false;

    private double startX;

    private double startY;

    private double scrollLeft;

    private double scrollTop;

    private double touchScrollIncrement = 1;

    private void stopTouchScroll() {
        mouseDown = false;
        resetCursor();
    }

    private void resetCursor() {
        if (scrollAreaEl == null)
            return;

        scrollAreaEl.style().setProperty("cursor", "default");
    }

    private void initScrollButton(WebScrollableContainerEdge edge, Side side) {
        if (edge == null)
            return;

        DefaultWebFrontendScrollableContainerEdge<?, ?> frontendEdge = ((DefaultWebFrontendScrollableContainerEdge<?, ?>) (edge));
        DefaultWebFrontendButton<?, ?> scrollButton = ((DefaultWebFrontendButton<?, ?>) (frontendEdge.getScrollButton()));
        if (scrollButton == null)
            return;

        scrollButton.on(Events.of(Event.MOUSE_DOWN, Event.TOUCH_START), e -> {
            e.preventDefault();
            e.stopImmediatePropagation();
            if (this.continuousScroll) {
                if (this.scrollSide != side)
                    this.clearScrollInterval();

                this.scrollSide = side;
                if (this.scrollIntervalID == 0) {
                    this.scrollIntervalID = WindowGlobal.setInterval(() -> this.scroll(side), SCROLL_INTERVAL);
                }
            } else
                this.scroll(side);

        });
        if (this.continuousScroll) {
            scrollButton.on(Events.of(Event.MOUSE_LEAVE, Event.MOUSE_UP), e -> this.clearScrollInterval());
        }
    }

    private void scroll(Side side) {
        if (scrollIncrement == ScrollIncrement.AUTO) {
            if (side == Side.TOP)
                scrollAreaEl.scrollTo(0, scrollAreaEl.scrollTop - SCROLL_AMOUNT);
            else if (side == Side.RIGHT)
                scrollAreaEl.scrollTo(scrollAreaEl.scrollLeft + SCROLL_AMOUNT, 0);
            else if (side == Side.BOTTOM)
                scrollAreaEl.scrollTo(0, scrollAreaEl.scrollTop + SCROLL_AMOUNT);
            else if (side == Side.LEFT)
                scrollAreaEl.scrollTo(scrollAreaEl.scrollLeft - SCROLL_AMOUNT, 0);

        } else if (scrollIncrement == ScrollIncrement.CHILD_SIZE) {
            /* ScrollToOptions scrollOpts = ScrollToOptions.create();
            scrollOpts.setBehavior("smooth");
            if(side == Side.TOP) scrollOpts.setTop(scrollAreaEl.scrollTop-SCROLL_AMOUNT);
            else if(side == Side.RIGHT) scrollOpts.setLeft(scrollAreaEl.scrollLeft+SCROLL_AMOUNT);
            else if(side == Side.BOTTOM) scrollOpts.setTop(scrollAreaEl.scrollTop+SCROLL_AMOUNT);
            else if(side == Side.LEFT) scrollOpts.setLeft(scrollAreaEl.scrollLeft-SCROLL_AMOUNT);
            scrollAreaEl.scrollTo(scrollOpts);
             */
        }
    }

    private void clearScrollInterval() {
        WindowGlobal.clearInterval(scrollIntervalID);
        scrollIntervalID = 0;
        scrollSide = null;
    }

    private void checkScrollPositions() {
        if (scrollAreaEl == null)
            return;

        ScrollDirection fadeScrollDir = fadeOpts.getScrollDirection();
        boolean xScroll = (fadeScrollDir == ScrollDirection.HORIZONTAL) || (fadeScrollDir == ScrollDirection.BOTH);
        boolean yScroll = (fadeScrollDir == ScrollDirection.VERTICAL) || (fadeScrollDir == ScrollDirection.BOTH);
        boolean isStart = false;
        boolean isEnd = false;
        if (xScroll) {
            isStart = scrollAreaEl.scrollLeft <= 0;
            isEnd = (scrollAreaEl.offsetWidth() + Math.ceil(scrollAreaEl.scrollLeft)) >= scrollAreaEl.scrollWidth();
            enableScroll(Side.LEFT, getLeftEdge(), getScrollArea().getScrollAreaLeftFade(), !isStart);
            enableScroll(Side.RIGHT, getRightEdge(), getScrollArea().getScrollAreaRightFade(), !isEnd);
        }
        if (yScroll) {
            isStart = scrollAreaEl.scrollTop <= 0;
            isEnd = (scrollAreaEl.offsetHeight() + Math.ceil(scrollAreaEl.scrollTop)) >= scrollAreaEl.scrollHeight();
            enableScroll(Side.TOP, getTopEdge(), getScrollArea().getScrollAreaTopFade(), !isStart);
            enableScroll(Side.BOTTOM, getBottomEdge(), getScrollArea().getScrollAreaBottomFade(), !isEnd);
        }
        if (fadeOpts.isMask()) {
            String maskImg = ("linear-gradient(" + (xScroll ? 90 : 180)) + "deg";
            if (!isStart)
                maskImg += ", transparent 0%, rgb(0, 0, 0) 10%";

            if (!isEnd)
                maskImg += ", rgb(0, 0, 0) 90%, transparent 100%";

            maskImg += ")";
            scrollAreaEl.style().setProperty("-webkit-mask-image", maskImg);
        }
    }

    private void enableScroll(Side side, WebScrollableContainerEdge e, CoreContainer fade, boolean enable) {
        if (e == null)
            return;

        DefaultWebFrontendScrollableContainerEdge<?, ?> edge = ((DefaultWebFrontendScrollableContainerEdge<?, ?>) (e));
        if (fade != null)
            ((WebContainer) (fade)).addOrRemoveStyleClass("reuise-scrollablecontainer_scrollarea_fade--hidden", !enable);

        edge.enableScrollButton(enable);
        if ((!enable) && (side == scrollSide))
            clearScrollInterval();

    }

    @Override
    public void scroll(double xCoord, double yCoord) {
        if (scrollAreaEl == null)
            return;

        ScrollToOptions scrollOpts = ScrollToOptions.of();
        scrollOpts.setLeft(xCoord);
        scrollOpts.setTop(yCoord);
        scrollOpts.setBehavior("smooth");
        scrollAreaEl.scrollTo(scrollOpts);
    }

    @Override
    public void scrollToEnd(Axis direction) {
        if (direction == Axis.HORIZONTAL)
            scroll(scrollAreaEl.offsetWidth() + scrollAreaEl.scrollWidth(), 0);
        else if (direction == Axis.VERTICAL)
            scroll(0, scrollAreaEl.offsetHeight() + scrollAreaEl.scrollHeight());

    }

    protected final WebFrontendContainerPart containerPart;

    protected final WebFrontendParentComponentPart parentComponentPart;

    protected final WebFrontendBaseComponentPart baseComponentPart;

    protected DefaultWebFrontendScrollableContainer(O options) {
        super(options);
        if (options.getComponent() == null)
            options.setComponent(self());

        containerPart = options.getComponentFactory().createContainer(((CoreContainerOptions) (options.getContainerPart())));
        parentComponentPart = containerPart.getParentComponentPart();
        baseComponentPart = parentComponentPart.getBaseComponentPart();
        addPart(ComponentPart.Type.BASE, containerPart);
        fadeOpts = options.getScrollAreaFadeOptions();
        scrollBehavior = options.getScrollBehavior();
        if (scrollBehavior == null) {
            scrollBehavior = new ScrollableContainerScrollBehavior();
        }
        scrollIncrement = scrollBehavior.getIncrement();
        continuousScroll = scrollBehavior.isContinuous();
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

    @Override
    public void setRootComponent(RootComponent rootComponent) {
        super.setRootComponent(rootComponent);
        this.containerPart.setRootComponent(rootComponent);
        if (scrollAreaBefore != null)
            scrollAreaBefore.setRootComponent(rootComponent);

        if (scrollArea != null)
            scrollArea.setRootComponent(rootComponent);

        if (scrollAreaAfter != null)
            scrollAreaAfter.setRootComponent(rootComponent);

    }

    @Override
    public Theme getTheme() {
        return containerPart.getTheme();
    }

    @Override
    public S setTheme(Theme theme) {
        super.setTheme(theme);
        if (scrollAreaBefore != null)
            scrollAreaBefore.setTheme(theme);

        if (scrollArea != null)
            scrollArea.setTheme(theme);

        if (scrollAreaAfter != null)
            scrollAreaAfter.setTheme(theme);

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
    public WebFrontendScrollableContainer getComponent() {
        return ((WebFrontendScrollableContainer) (baseComponentPart.getComponent()));
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
        ((WebFrontendScrollableContainerScrollAreaPart) (getScrollArea())).rehydrate(child);
        return self();
    }

    public void onInitialize(O options) {
        super.onInitialize(options);
    }

    // Implementation
    // Implementation
    public void onCreate(O options) {
        super.onCreate(options);
        resizeObserver = new ResizeObserver((entries, observer) -> {
            this.checkScrollPositions();
        });
        scrollAreaEl = ((WebFrontendContainer) (scrollArea.getScrollAreaContent())).getHtmlElement();
        if (scrollAreaEl != null) {
            if (fadeOpts != null) {
                scrollAreaEl.addEventListener("scroll", e -> this.checkScrollPositions());
                this.checkScrollPositions();
                resizeObserver.observe(getElement());
            }
            scrollAreaEl.addEventListener("mousedown", e -> {
                e.preventDefault();
                e.stopPropagation();
                mouseDown = true;
                scrollAreaEl.style().setProperty("cursor", "grabbing");
                MouseEvent mouseEvent = ((MouseEvent) (e));
                startX = mouseEvent.pageX() - scrollAreaEl.offsetLeft();
                startY = mouseEvent.pageY() - scrollAreaEl.offsetTop();
                scrollLeft = scrollAreaEl.scrollLeft;
                scrollTop = scrollAreaEl.scrollTop;
            });
            scrollAreaEl.addEventListener("mouseup", e -> {
                stopTouchScroll();
            });
            WindowGlobal.document().addEventListener("mouseup", e -> {
                stopTouchScroll();
            });
            WindowGlobal.document().addEventListener("mousemove", e -> {
                if (!mouseDown)
                    return;

                e.preventDefault();
                MouseEvent mouseEvent = ((MouseEvent) (e));
                double x = mouseEvent.pageX() - scrollAreaEl.offsetLeft();
                double y = mouseEvent.pageY() - scrollAreaEl.offsetTop();
                double walkX = (x - startX) * touchScrollIncrement;
                double walkY = (y - startY) * touchScrollIncrement;
                scrollAreaEl.scrollLeft = scrollLeft - walkX;
                scrollAreaEl.scrollTop = scrollTop - walkY;
            });
            if (scrollButtonOptions != null) {
                initScrollButton(getTopEdge(), Side.TOP);
                initScrollButton(getRightEdge(), Side.RIGHT);
                initScrollButton(getBottomEdge(), Side.BOTTOM);
                initScrollButton(getLeftEdge(), Side.LEFT);
            }
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
    public WebFrontendContainer getScrollAreaBefore() {
        return ((WebFrontendContainer) (super.getScrollAreaBefore()));
    }

    @Override
    public WebFrontendScrollableContainerScrollArea getScrollArea() {
        return ((WebFrontendScrollableContainerScrollArea) (super.getScrollArea()));
    }

    @Override
    public WebFrontendContainer getScrollAreaAfter() {
        return ((WebFrontendContainer) (super.getScrollAreaAfter()));
    }

    public void onInitializeCommonStyle(StyleBuilder commonStyles) {
        super.onInitializeCommonStyle(commonStyles);
    }
}

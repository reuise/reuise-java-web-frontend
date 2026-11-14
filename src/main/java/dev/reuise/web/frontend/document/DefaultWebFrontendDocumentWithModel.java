package dev.reuise.web.frontend.document;
import akasha.Element;
import akasha.EventListener;
import akasha.HTMLElement;
import akasha.core.JSON;
import com.github.nmorel.gwtjackson.client.ObjectMapper;
import dev.reuise.core.ColorMode;
import dev.reuise.core.ComponentPart;
import dev.reuise.core.ComponentType;
import dev.reuise.core.CoreComponent;
import dev.reuise.core.CoreComponentOptions;
import dev.reuise.core.Interaction;
import dev.reuise.core.LocaleContext;
import dev.reuise.core.Rect;
import dev.reuise.core.RootComponent;
import dev.reuise.core.ScreenSizeValues;
import dev.reuise.core.State;
import dev.reuise.core.TextDirection;
import dev.reuise.core.dialog.CoreDialog;
import dev.reuise.core.event.EventType;
import dev.reuise.core.option.OptionApplicator;
import dev.reuise.core.parentcomponent.CoreParentComponent;
import dev.reuise.core.theme.Theme;
import dev.reuise.web.core.WebRootComponent;
import dev.reuise.web.core.document.WebDocumentOptions;
import dev.reuise.web.frontend.ElementDataParser;
import dev.reuise.web.frontend.ElementProvider;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.WebFrontendComponentType;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPart;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
import dev.reuise.webstyles.Style;
import dev.reuise.webstyles.StyleBuilder;
import dev.reuise.webstyles.StyleSheet;
import dev.reuise.webstyles.StyleSheetFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import jsinterop.base.JsPropertyMap;
// Option: Title - WEB
// Option: ViewId - WEB
// Option: Description - WEB
// Option: Keywords - WEB
// Option: ThemeColor - WEB
// Option: Language - WEB
// Option: TextDirection - WEB
// Option: Path - WEB
// Option: Url - WEB
// Option: Charset - WEB
// Option: StyleSheet - WEB
// Option: Model - WEB
// Option: UrlParameters - WEB
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
// base comp: document
// add composition for document: getUrlParameter
// add composition for document: openDialog
// add composition for document: setColorMode
// add composition for document: getColorMode
// add composition for document: setHydrationData
// add composition for document: getHydrationData
// add composition for document: hasHydrationData
// add composition for document: removeHydrationData
// add composition for document: isViewId
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
public abstract class DefaultWebFrontendDocumentWithModel<S extends DefaultWebFrontendDocumentWithModel<S, O, M>, O extends WebFrontendDocumentWithModelOptions<M>, M> implements WebFrontendComponentType<S, O> , WebFrontendDocumentWithModel<M> {
    protected ObjectMapper<M> modelMapper;

    protected void onLoad(M model) {
    }

    @Override
    public ObjectMapper<M> getModelMapper() {
        return modelMapper;
    }

    @Override
    public S setModelMapper(ObjectMapper<M> modelMapper) {
        this.modelMapper = modelMapper;
        return self();
    }

    @Override
    public StyleBuilder getCommonStyles() {
        return ((DefaultWebFrontendDocument<?, ?>) (documentPart)).getCommonStyles();
    }

    protected final WebFrontendDocumentPart documentPart;

    protected final WebFrontendParentComponentPart parentComponentPart;

    protected final WebFrontendBaseComponentPart baseComponentPart;

    private final List<Class> componentTypeRegister = new ArrayList();

    protected DefaultWebFrontendDocumentWithModel(O options) {
        if (options.getComponent() == null)
            options.setComponent(self());

        documentPart = options.getComponentFactory().createDocument(((WebDocumentOptions) (options.getDocumentPart())));
        parentComponentPart = documentPart.getParentComponentPart();
        baseComponentPart = parentComponentPart.getBaseComponentPart();
        addPart(ComponentPart.Type.BASE, documentPart);
    }

    @Override
    public String getTitle() {
        return documentPart.getTitle();
    }

    @Override
    public S setTitle(String title) {
        this.documentPart.setTitle(title);
        return self();
    }

    @Override
    public String getViewId() {
        return documentPart.getViewId();
    }

    @Override
    public S setViewId(String viewId) {
        this.documentPart.setViewId(viewId);
        return self();
    }

    @Override
    public String getDescription() {
        return documentPart.getDescription();
    }

    @Override
    public S setDescription(String description) {
        this.documentPart.setDescription(description);
        return self();
    }

    @Override
    public List<String> getKeywords() {
        return documentPart.getKeywords();
    }

    @Override
    public S setKeywords(List<String> keywords) {
        this.documentPart.setKeywords(keywords);
        return self();
    }

    @Override
    public S addKeyword(String keyword) {
        this.documentPart.addKeyword(keyword);
        return self();
    }

    @Override
    public S removeKeyword(String keyword) {
        documentPart.removeKeyword(keyword);
        return self();
    }

    @Override
    public S clearKeywords() {
        documentPart.clearKeywords();
        return self();
    }

    @Override
    public boolean hasKeyword(String keyword) {
        return documentPart.hasKeyword(keyword);
    }

    @Override
    public String getThemeColor() {
        return documentPart.getThemeColor();
    }

    @Override
    public S setThemeColor(String themeColor) {
        this.documentPart.setThemeColor(themeColor);
        return self();
    }

    @Override
    public String getLanguage() {
        return documentPart.getLanguage();
    }

    @Override
    public S setLanguage(String language) {
        this.documentPart.setLanguage(language);
        return self();
    }

    @Override
    public TextDirection getTextDirection() {
        return documentPart.getTextDirection();
    }

    @Override
    public S setTextDirection(TextDirection textDirection) {
        this.documentPart.setTextDirection(textDirection);
        return self();
    }

    @Override
    public String getPath() {
        return documentPart.getPath();
    }

    @Override
    public S setPath(String path) {
        this.documentPart.setPath(path);
        return self();
    }

    @Override
    public String getUrl() {
        return documentPart.getUrl();
    }

    @Override
    public S setUrl(String url) {
        this.documentPart.setUrl(url);
        return self();
    }

    @Override
    public String getCharset() {
        return documentPart.getCharset();
    }

    @Override
    public S setCharset(String charset) {
        this.documentPart.setCharset(charset);
        return self();
    }

    @Override
    public List<StyleSheet> getStyleSheet() {
        return documentPart.getStyleSheet();
    }

    @Override
    public S setStyleSheet(List<StyleSheet> styleSheet) {
        this.documentPart.setStyleSheet(styleSheet);
        return self();
    }

    @Override
    public S addStyleSheet(StyleSheet styleSheet) {
        this.documentPart.addStyleSheet(styleSheet);
        return self();
    }

    @Override
    public S setStyleSheet(StyleSheet styleSheet) {
        documentPart.setStyleSheet(styleSheet);
        return self();
    }

    @Override
    public S removeStyleSheet(StyleSheet styleSheet) {
        documentPart.removeStyleSheet(styleSheet);
        return self();
    }

    @Override
    public Map<String, Object> getModel() {
        return documentPart.getModel();
    }

    @Override
    public S setModel(Map<String, Object> model) {
        this.documentPart.setModel(model);
        return self();
    }

    @Override
    public Map<String, String> getUrlParameters() {
        return documentPart.getUrlParameters();
    }

    public String getUrlParameter(String urlParameter) {
        return documentPart.getUrlParameter(urlParameter);
    }

    public void openDialog(CoreDialog dialog) {
        documentPart.openDialog(dialog);
    }

    public S setColorMode(ColorMode colorMode) {
        documentPart.setColorMode(colorMode);
        return self();
    }

    public ColorMode getColorMode() {
        return documentPart.getColorMode();
    }

    public S setHydrationData(String key, Object value) {
        documentPart.setHydrationData(key, value);
        return self();
    }

    public Object getHydrationData(String key) {
        return documentPart.getHydrationData(key);
    }

    public boolean hasHydrationData(String key) {
        return documentPart.hasHydrationData(key);
    }

    public S removeHydrationData(String key) {
        documentPart.removeHydrationData(key);
        return self();
    }

    public boolean isViewId(String viewId) {
        return documentPart.isViewId(viewId);
    }

    public WebFrontendDocumentPart getDocumentPart() {
        return documentPart;
    }

    @Override
    public RootComponent getRootComponent() {
        return documentPart.getRootComponent();
    }

    @Override
    public void setRootComponent(RootComponent rootComponent) {
        this.documentPart.setRootComponent(rootComponent);
    }

    @Override
    public WebFrontendDocumentBody getBody() {
        return documentPart.getBody();
    }

    @Override
    public S add(CoreComponent child) {
        documentPart.add(child);
        return self();
    }

    @Override
    public S addAll(List<? extends CoreComponent> children) {
        documentPart.addAll(children);
        return self();
    }

    @Override
    public void insertBefore(CoreComponent child, CoreComponent beforeChild) {
        documentPart.insertBefore(child, beforeChild);
    }

    @Override
    public S addText(String text) {
        documentPart.addText(text);
        return self();
    }

    @Override
    public S addLineBreak() {
        documentPart.addLineBreak();
        return self();
    }

    @Override
    public void remove(CoreComponent child) {
        documentPart.remove(child);
    }

    @Override
    public void removeAll() {
        documentPart.removeAll();
    }

    @Override
    public S rehydrate(CoreComponent child) {
        this.documentPart.rehydrate(child);
        child.setParent(self());
        child.setRootComponent(this);
        return self();
    }

    @Override
    public List<CoreComponent> getChildren() {
        return parentComponentPart.getChildren();
    }

    @Override
    public S setChildren(List<CoreComponent> children) {
        this.parentComponentPart.setChildren(children);
        return self();
    }

    @Override
    public S setChild(CoreComponent child) {
        parentComponentPart.setChild(child);
        return self();
    }

    @Override
    public S removeChild(CoreComponent child) {
        parentComponentPart.removeChild(child);
        return self();
    }

    @Override
    public S clearChildren() {
        parentComponentPart.clearChildren();
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
    public String getId() {
        return baseComponentPart.getId();
    }

    @Override
    public S setId(String id) {
        this.baseComponentPart.setId(id);
        return self();
    }

    @Override
    public String getTagName() {
        return baseComponentPart.getTagName();
    }

    @Override
    public S setTagName(String tagName) {
        this.baseComponentPart.setTagName(tagName);
        return self();
    }

    @Override
    public String getXmlNamespace() {
        return baseComponentPart.getXmlNamespace();
    }

    @Override
    public S setXmlNamespace(String xmlNamespace) {
        this.baseComponentPart.setXmlNamespace(xmlNamespace);
        return self();
    }

    @Override
    public String getTooltip() {
        return baseComponentPart.getTooltip();
    }

    @Override
    public S setTooltip(String tooltip) {
        this.baseComponentPart.setTooltip(tooltip);
        return self();
    }

    @Override
    public String getBaseStyleClass() {
        return baseComponentPart.getBaseStyleClass();
    }

    @Override
    public S setBaseStyleClass(String baseStyleClass) {
        this.baseComponentPart.setBaseStyleClass(baseStyleClass);
        return self();
    }

    @Override
    public Map<String, String> getAttributes() {
        return baseComponentPart.getAttributes();
    }

    @Override
    public S setAttributes(Map<String, String> attributes) {
        this.baseComponentPart.setAttributes(attributes);
        return self();
    }

    @Override
    public List<String> getStyleClasses() {
        return baseComponentPart.getStyleClasses();
    }

    @Override
    public S setStyleClasses(List<String> styleClasses) {
        this.baseComponentPart.setStyleClasses(styleClasses);
        return self();
    }

    @Override
    public S addStyleClass(String styleClass) {
        this.baseComponentPart.addStyleClass(styleClass);
        return self();
    }

    @Override
    public S setStyleClass(String styleClass) {
        baseComponentPart.setStyleClass(styleClass);
        return self();
    }

    @Override
    public S setStyleClasses(String... styleClasses) {
        baseComponentPart.setStyleClasses(styleClasses);
        return self();
    }

    @Override
    public S clearStyleClasses() {
        baseComponentPart.clearStyleClasses();
        return self();
    }

    @Override
    public Map<String, String> getData() {
        return baseComponentPart.getData();
    }

    @Override
    public S setData(Map<String, String> data) {
        this.baseComponentPart.setData(data);
        return self();
    }

    @Override
    public Style getStyle() {
        return baseComponentPart.getStyle();
    }

    @Override
    public S setStyle(Style style) {
        this.baseComponentPart.setStyle(style);
        return self();
    }

    @Override
    public S setStyle(Style style, State state) {
        this.baseComponentPart.setStyle(style, state);
        return self();
    }

    @Override
    public S setStyleAllStates(Style style) {
        setStyle(ScreenSizeValues.of(style, style));
        setStyle(style);
        return self();
    }

    @Override
    public S setStyle(ScreenSizeValues<Style> style) {
        this.baseComponentPart.setStyle(style);
        return self();
    }

    @Override
    public Style getStyle(State state) {
        return baseComponentPart.getStyle(state);
    }

    @Override
    public Style getInlineStyle() {
        return baseComponentPart.getInlineStyle();
    }

    @Override
    public S setInlineStyle(Style inlineStyle) {
        this.baseComponentPart.setInlineStyle(inlineStyle);
        return self();
    }

    @Override
    public String getRehydration() {
        return baseComponentPart.getRehydration();
    }

    @Override
    public S setRehydration(String rehydration) {
        this.baseComponentPart.setRehydration(rehydration);
        return self();
    }

    @Override
    public boolean isContentEditable() {
        return baseComponentPart.isContentEditable();
    }

    @Override
    public S setContentEditable(Boolean contentEditable) {
        this.baseComponentPart.setContentEditable(contentEditable);
        return self();
    }

    @Override
    public List<String> getStoreInElementOptions() {
        return baseComponentPart.getStoreInElementOptions();
    }

    @Override
    public S setStoreInElementOptions(List<String> storeInElementOptions) {
        this.baseComponentPart.setStoreInElementOptions(storeInElementOptions);
        return self();
    }

    @Override
    public S addStoreInElementOptions(String storeInElementOptions) {
        this.baseComponentPart.addStoreInElementOptions(storeInElementOptions);
        return self();
    }

    @Override
    public S setStoreInElementOptions(String storeInElementOptions) {
        baseComponentPart.setStoreInElementOptions(storeInElementOptions);
        return self();
    }

    @Override
    public S removeStoreInElementOptions(String storeInElementOptions) {
        baseComponentPart.removeStoreInElementOptions(storeInElementOptions);
        return self();
    }

    @Override
    public boolean hasStoreInElementOptions(String storeInElementOptions) {
        return baseComponentPart.hasStoreInElementOptions(storeInElementOptions);
    }

    @Override
    public boolean isMounted() {
        return baseComponentPart.isMounted();
    }

    @Override
    public S setMounted(Boolean mounted) {
        this.baseComponentPart.setMounted(mounted);
        return self();
    }

    @Override
    public Object getMargin() {
        return baseComponentPart.getMargin();
    }

    @Override
    public S setMargin(Object margin) {
        this.baseComponentPart.setMargin(margin);
        return self();
    }

    @Override
    public S setMargin(Object margin, State state) {
        this.baseComponentPart.setMargin(margin, state);
        return self();
    }

    @Override
    public S setMarginAllStates(Object margin) {
        setMargin(ScreenSizeValues.of(margin, margin));
        setMargin(margin);
        return self();
    }

    @Override
    public S setMargin(ScreenSizeValues<Object> margin) {
        this.baseComponentPart.setMargin(margin);
        return self();
    }

    @Override
    public Object getMargin(State state) {
        return baseComponentPart.getMargin(state);
    }

    @Override
    public Object getMarginTop() {
        return baseComponentPart.getMarginTop();
    }

    @Override
    public S setMarginTop(Object marginTop) {
        this.baseComponentPart.setMarginTop(marginTop);
        return self();
    }

    @Override
    public S setMarginTop(Object marginTop, State state) {
        this.baseComponentPart.setMarginTop(marginTop, state);
        return self();
    }

    @Override
    public S setMarginTopAllStates(Object marginTop) {
        setMarginTop(ScreenSizeValues.of(marginTop, marginTop));
        setMarginTop(marginTop);
        return self();
    }

    @Override
    public S setMarginTop(ScreenSizeValues<Object> marginTop) {
        this.baseComponentPart.setMarginTop(marginTop);
        return self();
    }

    @Override
    public Object getMarginTop(State state) {
        return baseComponentPart.getMarginTop(state);
    }

    @Override
    public Object getMarginRight() {
        return baseComponentPart.getMarginRight();
    }

    @Override
    public S setMarginRight(Object marginRight) {
        this.baseComponentPart.setMarginRight(marginRight);
        return self();
    }

    @Override
    public S setMarginRight(Object marginRight, State state) {
        this.baseComponentPart.setMarginRight(marginRight, state);
        return self();
    }

    @Override
    public S setMarginRightAllStates(Object marginRight) {
        setMarginRight(ScreenSizeValues.of(marginRight, marginRight));
        setMarginRight(marginRight);
        return self();
    }

    @Override
    public S setMarginRight(ScreenSizeValues<Object> marginRight) {
        this.baseComponentPart.setMarginRight(marginRight);
        return self();
    }

    @Override
    public Object getMarginRight(State state) {
        return baseComponentPart.getMarginRight(state);
    }

    @Override
    public Object getMarginBottom() {
        return baseComponentPart.getMarginBottom();
    }

    @Override
    public S setMarginBottom(Object marginBottom) {
        this.baseComponentPart.setMarginBottom(marginBottom);
        return self();
    }

    @Override
    public S setMarginBottom(Object marginBottom, State state) {
        this.baseComponentPart.setMarginBottom(marginBottom, state);
        return self();
    }

    @Override
    public S setMarginBottomAllStates(Object marginBottom) {
        setMarginBottom(ScreenSizeValues.of(marginBottom, marginBottom));
        setMarginBottom(marginBottom);
        return self();
    }

    @Override
    public S setMarginBottom(ScreenSizeValues<Object> marginBottom) {
        this.baseComponentPart.setMarginBottom(marginBottom);
        return self();
    }

    @Override
    public Object getMarginBottom(State state) {
        return baseComponentPart.getMarginBottom(state);
    }

    @Override
    public Object getMarginLeft() {
        return baseComponentPart.getMarginLeft();
    }

    @Override
    public S setMarginLeft(Object marginLeft) {
        this.baseComponentPart.setMarginLeft(marginLeft);
        return self();
    }

    @Override
    public S setMarginLeft(Object marginLeft, State state) {
        this.baseComponentPart.setMarginLeft(marginLeft, state);
        return self();
    }

    @Override
    public S setMarginLeftAllStates(Object marginLeft) {
        setMarginLeft(ScreenSizeValues.of(marginLeft, marginLeft));
        setMarginLeft(marginLeft);
        return self();
    }

    @Override
    public S setMarginLeft(ScreenSizeValues<Object> marginLeft) {
        this.baseComponentPart.setMarginLeft(marginLeft);
        return self();
    }

    @Override
    public Object getMarginLeft(State state) {
        return baseComponentPart.getMarginLeft(state);
    }

    @Override
    public Object getWidth() {
        return baseComponentPart.getWidth();
    }

    @Override
    public S setWidth(Object width) {
        this.baseComponentPart.setWidth(width);
        return self();
    }

    @Override
    public S setWidth(Object width, State state) {
        this.baseComponentPart.setWidth(width, state);
        return self();
    }

    @Override
    public S setWidthAllStates(Object width) {
        setWidth(ScreenSizeValues.of(width, width));
        setWidth(width);
        return self();
    }

    @Override
    public S setWidth(ScreenSizeValues<Object> width) {
        this.baseComponentPart.setWidth(width);
        return self();
    }

    @Override
    public Object getWidth(State state) {
        return baseComponentPart.getWidth(state);
    }

    @Override
    public Object getMinWidth() {
        return baseComponentPart.getMinWidth();
    }

    @Override
    public S setMinWidth(Object minWidth) {
        this.baseComponentPart.setMinWidth(minWidth);
        return self();
    }

    @Override
    public S setMinWidth(Object minWidth, State state) {
        this.baseComponentPart.setMinWidth(minWidth, state);
        return self();
    }

    @Override
    public S setMinWidthAllStates(Object minWidth) {
        setMinWidth(ScreenSizeValues.of(minWidth, minWidth));
        setMinWidth(minWidth);
        return self();
    }

    @Override
    public S setMinWidth(ScreenSizeValues<Object> minWidth) {
        this.baseComponentPart.setMinWidth(minWidth);
        return self();
    }

    @Override
    public Object getMinWidth(State state) {
        return baseComponentPart.getMinWidth(state);
    }

    @Override
    public Object getMaxWidth() {
        return baseComponentPart.getMaxWidth();
    }

    @Override
    public S setMaxWidth(Object maxWidth) {
        this.baseComponentPart.setMaxWidth(maxWidth);
        return self();
    }

    @Override
    public S setMaxWidth(Object maxWidth, State state) {
        this.baseComponentPart.setMaxWidth(maxWidth, state);
        return self();
    }

    @Override
    public S setMaxWidthAllStates(Object maxWidth) {
        setMaxWidth(ScreenSizeValues.of(maxWidth, maxWidth));
        setMaxWidth(maxWidth);
        return self();
    }

    @Override
    public S setMaxWidth(ScreenSizeValues<Object> maxWidth) {
        this.baseComponentPart.setMaxWidth(maxWidth);
        return self();
    }

    @Override
    public Object getMaxWidth(State state) {
        return baseComponentPart.getMaxWidth(state);
    }

    @Override
    public Object getHeight() {
        return baseComponentPart.getHeight();
    }

    @Override
    public S setHeight(Object height) {
        this.baseComponentPart.setHeight(height);
        return self();
    }

    @Override
    public S setHeight(Object height, State state) {
        this.baseComponentPart.setHeight(height, state);
        return self();
    }

    @Override
    public S setHeightAllStates(Object height) {
        setHeight(ScreenSizeValues.of(height, height));
        setHeight(height);
        return self();
    }

    @Override
    public S setHeight(ScreenSizeValues<Object> height) {
        this.baseComponentPart.setHeight(height);
        return self();
    }

    @Override
    public Object getHeight(State state) {
        return baseComponentPart.getHeight(state);
    }

    @Override
    public Object getMinHeight() {
        return baseComponentPart.getMinHeight();
    }

    @Override
    public S setMinHeight(Object minHeight) {
        this.baseComponentPart.setMinHeight(minHeight);
        return self();
    }

    @Override
    public S setMinHeight(Object minHeight, State state) {
        this.baseComponentPart.setMinHeight(minHeight, state);
        return self();
    }

    @Override
    public S setMinHeightAllStates(Object minHeight) {
        setMinHeight(ScreenSizeValues.of(minHeight, minHeight));
        setMinHeight(minHeight);
        return self();
    }

    @Override
    public S setMinHeight(ScreenSizeValues<Object> minHeight) {
        this.baseComponentPart.setMinHeight(minHeight);
        return self();
    }

    @Override
    public Object getMinHeight(State state) {
        return baseComponentPart.getMinHeight(state);
    }

    @Override
    public Object getMaxHeight() {
        return baseComponentPart.getMaxHeight();
    }

    @Override
    public S setMaxHeight(Object maxHeight) {
        this.baseComponentPart.setMaxHeight(maxHeight);
        return self();
    }

    @Override
    public S setMaxHeight(Object maxHeight, State state) {
        this.baseComponentPart.setMaxHeight(maxHeight, state);
        return self();
    }

    @Override
    public S setMaxHeightAllStates(Object maxHeight) {
        setMaxHeight(ScreenSizeValues.of(maxHeight, maxHeight));
        setMaxHeight(maxHeight);
        return self();
    }

    @Override
    public S setMaxHeight(ScreenSizeValues<Object> maxHeight) {
        this.baseComponentPart.setMaxHeight(maxHeight);
        return self();
    }

    @Override
    public Object getMaxHeight(State state) {
        return baseComponentPart.getMaxHeight(state);
    }

    @Override
    public boolean isRequiredLayoutComponent() {
        return baseComponentPart.isRequiredLayoutComponent();
    }

    @Override
    public S setRequiredLayoutComponent(Boolean requiredLayoutComponent) {
        this.baseComponentPart.setRequiredLayoutComponent(requiredLayoutComponent);
        return self();
    }

    @Override
    public CoreComponent getParent() {
        return baseComponentPart.getParent();
    }

    @Override
    public S setParent(CoreComponent parent) {
        this.baseComponentPart.setParent(parent);
        return self();
    }

    @Override
    public LocaleContext getLocaleContext() {
        return baseComponentPart.getLocaleContext();
    }

    @Override
    public S setLocaleContext(LocaleContext localeContext) {
        this.baseComponentPart.setLocaleContext(localeContext);
        return self();
    }

    @Override
    public Function<String, String> getLinkUrlResolver() {
        return baseComponentPart.getLinkUrlResolver();
    }

    @Override
    public S setLinkUrlResolver(Function<String, String> linkUrlResolver) {
        this.baseComponentPart.setLinkUrlResolver(linkUrlResolver);
        return self();
    }

    @Override
    public CoreParentComponent getWrapper() {
        return baseComponentPart.getWrapper();
    }

    @Override
    public S setWrapper(CoreParentComponent wrapper) {
        this.baseComponentPart.setWrapper(wrapper);
        return self();
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
    public boolean isVisible() {
        return baseComponentPart.isVisible();
    }

    @Override
    public S setVisible(Boolean visible) {
        this.baseComponentPart.setVisible(visible);
        return self();
    }

    @Override
    public S setVisible(Boolean visible, State state) {
        this.baseComponentPart.setVisible(visible, state);
        return self();
    }

    @Override
    public S setVisibleAllStates(Boolean visible) {
        setVisible(ScreenSizeValues.of(visible, visible));
        setVisible(visible);
        return self();
    }

    @Override
    public S setVisible(ScreenSizeValues<Boolean> visible) {
        this.baseComponentPart.setVisible(visible);
        return self();
    }

    @Override
    public boolean isVisible(State state) {
        return baseComponentPart.isVisible(state);
    }

    @Override
    public boolean isEnabled() {
        return baseComponentPart.isEnabled();
    }

    @Override
    public S setEnabled(Boolean enabled) {
        this.baseComponentPart.setEnabled(enabled);
        return self();
    }

    @Override
    public boolean isFocused() {
        return baseComponentPart.isFocused();
    }

    @Override
    public S setFocused(Boolean focused) {
        this.baseComponentPart.setFocused(focused);
        return self();
    }

    @Override
    public boolean isDebug() {
        return baseComponentPart.isDebug();
    }

    @Override
    public S setDebug(Boolean debug) {
        this.baseComponentPart.setDebug(debug);
        return self();
    }

    @Override
    public String getDebugId() {
        return baseComponentPart.getDebugId();
    }

    @Override
    public S setDebugId(String debugId) {
        this.baseComponentPart.setDebugId(debugId);
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
        return documentPart.getElement();
    }

    public HTMLElement getHtmlElement() {
        return documentPart.getHtmlElement();
    }

    public Rect getBoundingBox() {
        return documentPart.getBoundingBox();
    }

    public HTMLElement createOrRehydrateElement(String tagName, String selector) {
        return documentPart.createOrRehydrateElement(tagName, selector);
    }

    public S on(EventType type, EventListener listener) {
        documentPart.on(type, listener);
        return self();
    }

    public S on(Set<EventType> types, EventListener listener) {
        documentPart.on(types, listener);
        return self();
    }

    public void dispatchEvent(EventType type) {
        documentPart.dispatchEvent(type);
    }

    public void click() {
        documentPart.click();
    }

    public boolean isRehydrated() {
        if (documentPart == null)
            return false;

        return documentPart.isRehydrated();
    }

    public Style getComputedStyle() {
        return documentPart.getComputedStyle();
    }

    public S addOrRemoveStyleClass(String styleClass, boolean add) {
        documentPart.addOrRemoveStyleClass(styleClass, add);
        return self();
    }

    public boolean hasStyleClass(String styleClass) {
        return documentPart.hasStyleClass(styleClass);
    }

    public S removeStyleClass(String styleClass) {
        documentPart.removeStyleClass(styleClass);
        return self();
    }

    public S setAttribute(String attribute, String value) {
        documentPart.setAttribute(attribute, value);
        return self();
    }

    public S setAttribute(String attribute) {
        documentPart.setAttribute(attribute);
        return self();
    }

    public S removeAttribute(String attribute) {
        documentPart.removeAttribute(attribute);
        return self();
    }

    public String getAttribute(String attribute) {
        return documentPart.getAttribute(attribute);
    }

    public boolean hasAttribute(String attribute) {
        return documentPart.hasAttribute(attribute);
    }

    public S setData(String data, String value) {
        documentPart.setData(data, value);
        return self();
    }

    public String getData(String data) {
        return documentPart.getData(data);
    }

    public boolean hasData(String data) {
        return documentPart.hasData(data);
    }

    public S setAria(String attribute, String value) {
        documentPart.setAria(attribute, value);
        return self();
    }

    public String getAria(String attribute) {
        return documentPart.getAria(attribute);
    }

    public boolean hasAria(String attribute) {
        return documentPart.hasAria(attribute);
    }

    public String getUniqueId() {
        return documentPart.getUniqueId();
    }

    public String getUniqueStyleClass() {
        return documentPart.getUniqueStyleClass();
    }

    public String getStyleSheetId() {
        return documentPart.getStyleSheetId();
    }

    public String getStyleSheetId(State state) {
        return documentPart.getStyleSheetId(state);
    }

    public Set<State> getStyleStates() {
        return documentPart.getStyleStates();
    }

    public void setStyleSheetFactory(StyleSheetFactory styleSheetFactory) {
        documentPart.setStyleSheetFactory(styleSheetFactory);
    }

    public Style getStyle(State state, Interaction interaction) {
        return documentPart.getStyle(state, interaction);
    }

    public Style getStyle(Interaction interaction) {
        return documentPart.getStyle(interaction);
    }

    public boolean hasWrapper() {
        return documentPart.hasWrapper();
    }

    public boolean isInitialized() {
        return documentPart.isInitialized();
    }

    public void log(Object obj) {
        documentPart.log(obj);
    }

    public void removeFromParent() {
        documentPart.removeFromParent();
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
        baseComponentPart.initialize(component, options);
    }

    @Override
    public WebFrontendDocumentWithModel getComponent() {
        return ((WebFrontendDocumentWithModel) (baseComponentPart.getComponent()));
    }

    public boolean onPreInitialize(O options) {
        if ((options != null) && options.isRehydrated())
            options.rehydrate(getElement());

        return true;
    }

    // Implementation
    // Implementation
    // Implementation
    public void onInitialize(O options) {
        modelMapper = options.getModelMapper();
        JsPropertyMap<Object> docModel = JsWindow.reuiseDocModel;
        onLoad(docModel != null ? deserializeModel(JSON.stringify(docModel)) : null);
    }

    public void onCreate(O options) {
    }

    public void applyOptions(O options, OptionApplicator applicator, Collection<State> states) {
        WebFrontendDocumentWithModelPart component = ((WebFrontendDocumentWithModelPart) (options.getComponent()));
        if (component == null)
            System.out.println("component is null");

        // Apply options for default state
        applicator.add(options.getModelMapperOption(), component::setModelMapper);
    }

    public void onInitializeComponentType(RootComponent rootComponent) {
        if (isRehydrated() || ((WebRootComponent) (rootComponent)).isComponentTypeRegistered(getComponent().getClass()))
            return;

        documentPart.onInitializeComponentType(rootComponent);
        onInitializeCommonStyle(((WebRootComponent) (rootComponent)).getCommonStyles());
    }

    public void onInitializeCommonStyle(StyleBuilder commonStyles) {
    }

    protected abstract S self();

    // Implementation
    public M deserializeModel(String json) {
        return modelMapper.read(json);
    }

    // Implementation
    @Override
    public boolean registerComponentType(CoreComponent component) {
        return ((DefaultWebFrontendDocument<?, ?>) (documentPart)).registerComponentType(component);
    }

    @Override
    public boolean isComponentTypeRegistered(Class<? extends CoreComponent> componentType) {
        return componentTypeRegister.contains(componentType);
    }
}

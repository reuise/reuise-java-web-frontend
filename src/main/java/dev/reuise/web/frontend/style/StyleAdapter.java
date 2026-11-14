package dev.reuise.web.frontend.style;
import akasha.CSSStyleDeclaration;
import dev.reuise.webstyles.Style;
import dev.reuise.webstyles.StyleProperty;
import dev.reuise.webstyles.StylePropertyValue;
import java.util.HashMap;
import java.util.Map;
public class StyleAdapter implements Style {
    public CSSStyleDeclaration styleDeclaration;

    public StyleAdapter() {
    }

    public StyleAdapter(CSSStyleDeclaration styleDeclaration, Style style) {
        this.styleDeclaration = styleDeclaration;
        if (style != null)
            this.styleDeclaration.cssText = style.getCssText();

    }

    @Override
    public String getCssText() {
        return styleDeclaration.cssText;
    }

    @Override
    public boolean hasProperties() {
        return styleDeclaration.length() != 0;
    }

    // Implementation
    @Override
    public Map<StyleProperty, StylePropertyValue> getProperties() {
        Map<StyleProperty, StylePropertyValue> properties = new HashMap<>();
        for (int i = 0; i < styleDeclaration.length(); i++) {
            String name = styleDeclaration.item(i);
            String value = styleDeclaration.getPropertyValue(name);
            String priority = styleDeclaration.getPropertyPriority(name);
            StyleProperty prop = new StyleProperty(name);
            properties.put(prop, new StylePropertyValue(prop, value, priority.equals("important")));
        }
        return properties;
    }

    // Implementation
    @Override
    public void append(Style other) {
        if (other == null)
            return;

        Map<StyleProperty, StylePropertyValue> otherProps = other.getProperties();
        otherProps.values().forEach(p -> setProperty(p.getProperty(), p.getValue(), p.isPriority()));
    }

    public Object getPropertyValue(String propertyName) {
        return styleDeclaration.getPropertyValue(propertyName);
    }

    public StyleAdapter setProperty(String propertyName, Object value, boolean important) {
        styleDeclaration.setProperty(propertyName, value.toString(), important ? "important" : null);
        return this;
    }

    public StyleAdapter setProperty(StyleProperty property, Object value, boolean important) {
        return setProperty(property.getName(), property.parseProperty(value), important);
    }

    @Override
    public String getAlignContent() {
        return getPropertyValue("align-content").toString();
    }

    @Override
    public StyleAdapter setAlignContent(String alignContent, boolean important) {
        return setProperty(Style.ALIGN_CONTENT, alignContent, important);
    }

    @Override
    public StyleAdapter setAlignContent(String alignContent) {
        return setAlignContent(alignContent, false);
    }

    @Override
    public String getAlignItems() {
        return getPropertyValue("align-items").toString();
    }

    @Override
    public StyleAdapter setAlignItems(String alignItems, boolean important) {
        return setProperty(Style.ALIGN_ITEMS, alignItems, important);
    }

    @Override
    public StyleAdapter setAlignItems(String alignItems) {
        return setAlignItems(alignItems, false);
    }

    @Override
    public String getAlignSelf() {
        return getPropertyValue("align-self").toString();
    }

    @Override
    public StyleAdapter setAlignSelf(String alignSelf, boolean important) {
        return setProperty(Style.ALIGN_SELF, alignSelf, important);
    }

    @Override
    public StyleAdapter setAlignSelf(String alignSelf) {
        return setAlignSelf(alignSelf, false);
    }

    @Override
    public Object getAnimation() {
        return getPropertyValue("animation").toString();
    }

    @Override
    public StyleAdapter setAnimation(Object animation, boolean important) {
        return setProperty(Style.ANIMATION, animation, important);
    }

    @Override
    public StyleAdapter setAnimation(Object animation) {
        return setAnimation(animation, false);
    }

    @Override
    public String getAnimationDelay() {
        return getPropertyValue("animation-delay").toString();
    }

    @Override
    public StyleAdapter setAnimationDelay(String animationDelay, boolean important) {
        return setProperty(Style.ANIMATION_DELAY, animationDelay, important);
    }

    @Override
    public StyleAdapter setAnimationDelay(String animationDelay) {
        return setAnimationDelay(animationDelay, false);
    }

    @Override
    public String getAnimationDirection() {
        return getPropertyValue("animation-direction").toString();
    }

    @Override
    public StyleAdapter setAnimationDirection(String animationDirection, boolean important) {
        return setProperty(Style.ANIMATION_DIRECTION, animationDirection, important);
    }

    @Override
    public StyleAdapter setAnimationDirection(String animationDirection) {
        return setAnimationDirection(animationDirection, false);
    }

    @Override
    public String getAnimationDuration() {
        return getPropertyValue("animation-duration").toString();
    }

    @Override
    public StyleAdapter setAnimationDuration(String animationDuration, boolean important) {
        return setProperty(Style.ANIMATION_DURATION, animationDuration, important);
    }

    @Override
    public StyleAdapter setAnimationDuration(String animationDuration) {
        return setAnimationDuration(animationDuration, false);
    }

    @Override
    public String getAnimationFillMode() {
        return getPropertyValue("animation-fill-mode").toString();
    }

    @Override
    public StyleAdapter setAnimationFillMode(String animationFillMode, boolean important) {
        return setProperty(Style.ANIMATION_FILL_MODE, animationFillMode, important);
    }

    @Override
    public StyleAdapter setAnimationFillMode(String animationFillMode) {
        return setAnimationFillMode(animationFillMode, false);
    }

    @Override
    public Object getAnimationIterationCount() {
        return getPropertyValue("animation-iteration-count").toString();
    }

    @Override
    public StyleAdapter setAnimationIterationCount(Object animationIterationCount, boolean important) {
        return setProperty(Style.ANIMATION_ITERATION_COUNT, animationIterationCount, important);
    }

    @Override
    public StyleAdapter setAnimationIterationCount(Object animationIterationCount) {
        return setAnimationIterationCount(animationIterationCount, false);
    }

    @Override
    public String getAnimationName() {
        return getPropertyValue("animation-name").toString();
    }

    @Override
    public StyleAdapter setAnimationName(String animationName, boolean important) {
        return setProperty(Style.ANIMATION_NAME, animationName, important);
    }

    @Override
    public StyleAdapter setAnimationName(String animationName) {
        return setAnimationName(animationName, false);
    }

    @Override
    public String getAnimationPlayState() {
        return getPropertyValue("animation-play-state").toString();
    }

    @Override
    public StyleAdapter setAnimationPlayState(String animationPlayState, boolean important) {
        return setProperty(Style.ANIMATION_PLAY_STATE, animationPlayState, important);
    }

    @Override
    public StyleAdapter setAnimationPlayState(String animationPlayState) {
        return setAnimationPlayState(animationPlayState, false);
    }

    @Override
    public String getAnimationTimingFunction() {
        return getPropertyValue("animation-timing-function").toString();
    }

    @Override
    public StyleAdapter setAnimationTimingFunction(String animationTimingFunction, boolean important) {
        return setProperty(Style.ANIMATION_TIMING_FUNCTION, animationTimingFunction, important);
    }

    @Override
    public StyleAdapter setAnimationTimingFunction(String animationTimingFunction) {
        return setAnimationTimingFunction(animationTimingFunction, false);
    }

    @Override
    public String getAzimuth() {
        return getPropertyValue("azimuth").toString();
    }

    @Override
    public StyleAdapter setAzimuth(String azimuth, boolean important) {
        return setProperty(Style.AZIMUTH, azimuth, important);
    }

    @Override
    public StyleAdapter setAzimuth(String azimuth) {
        return setAzimuth(azimuth, false);
    }

    @Override
    public String getBackdropFilter() {
        return getPropertyValue("backdrop-filter").toString();
    }

    @Override
    public StyleAdapter setBackdropFilter(String backdropFilter, boolean important) {
        return setProperty(Style.BACKDROP_FILTER, backdropFilter, important);
    }

    @Override
    public StyleAdapter setBackdropFilter(String backdropFilter) {
        return setBackdropFilter(backdropFilter, false);
    }

    @Override
    public String getBackfaceVisibility() {
        return getPropertyValue("backface-visibility").toString();
    }

    @Override
    public StyleAdapter setBackfaceVisibility(String backfaceVisibility, boolean important) {
        return setProperty(Style.BACKFACE_VISIBILITY, backfaceVisibility, important);
    }

    @Override
    public StyleAdapter setBackfaceVisibility(String backfaceVisibility) {
        return setBackfaceVisibility(backfaceVisibility, false);
    }

    @Override
    public String getBackground() {
        return getPropertyValue("background").toString();
    }

    @Override
    public StyleAdapter setBackground(String background, boolean important) {
        return setProperty(Style.BACKGROUND, background, important);
    }

    @Override
    public StyleAdapter setBackground(String background) {
        return setBackground(background, false);
    }

    @Override
    public String getBackgroundAttachment() {
        return getPropertyValue("background-attachment").toString();
    }

    @Override
    public StyleAdapter setBackgroundAttachment(String backgroundAttachment, boolean important) {
        return setProperty(Style.BACKGROUND_ATTACHMENT, backgroundAttachment, important);
    }

    @Override
    public StyleAdapter setBackgroundAttachment(String backgroundAttachment) {
        return setBackgroundAttachment(backgroundAttachment, false);
    }

    @Override
    public String getBackgroundColor() {
        return getPropertyValue("background-color").toString();
    }

    @Override
    public StyleAdapter setBackgroundColor(String backgroundColor, boolean important) {
        return setProperty(Style.BACKGROUND_COLOR, backgroundColor, important);
    }

    @Override
    public StyleAdapter setBackgroundColor(String backgroundColor) {
        return setBackgroundColor(backgroundColor, false);
    }

    @Override
    public String getBackgroundImage() {
        return getPropertyValue("background-image").toString();
    }

    @Override
    public StyleAdapter setBackgroundImage(String backgroundImage, boolean important) {
        return setProperty(Style.BACKGROUND_IMAGE, backgroundImage, important);
    }

    @Override
    public StyleAdapter setBackgroundImage(String backgroundImage) {
        return setBackgroundImage(backgroundImage, false);
    }

    @Override
    public String getBackgroundPosition() {
        return getPropertyValue("background-position").toString();
    }

    @Override
    public StyleAdapter setBackgroundPosition(String backgroundPosition, boolean important) {
        return setProperty(Style.BACKGROUND_POSITION, backgroundPosition, important);
    }

    @Override
    public StyleAdapter setBackgroundPosition(String backgroundPosition) {
        return setBackgroundPosition(backgroundPosition, false);
    }

    @Override
    public String getBackgroundRepeat() {
        return getPropertyValue("background-repeat").toString();
    }

    @Override
    public StyleAdapter setBackgroundRepeat(String backgroundRepeat, boolean important) {
        return setProperty(Style.BACKGROUND_REPEAT, backgroundRepeat, important);
    }

    @Override
    public StyleAdapter setBackgroundRepeat(String backgroundRepeat) {
        return setBackgroundRepeat(backgroundRepeat, false);
    }

    @Override
    public String getBackgroundSize() {
        return getPropertyValue("background-size").toString();
    }

    @Override
    public StyleAdapter setBackgroundSize(String backgroundSize, boolean important) {
        return setProperty(Style.BACKGROUND_SIZE, backgroundSize, important);
    }

    @Override
    public StyleAdapter setBackgroundSize(String backgroundSize) {
        return setBackgroundSize(backgroundSize, false);
    }

    @Override
    public String getInset() {
        return getPropertyValue("inset").toString();
    }

    @Override
    public StyleAdapter setInset(String inset, boolean important) {
        return setProperty(Style.INSET, inset, important);
    }

    @Override
    public StyleAdapter setInset(String inset) {
        return setInset(inset, false);
    }

    @Override
    public String getBorder() {
        return getPropertyValue("border").toString();
    }

    @Override
    public StyleAdapter setBorder(String border, boolean important) {
        return setProperty(Style.BORDER, border, important);
    }

    @Override
    public StyleAdapter setBorder(String border) {
        return setBorder(border, false);
    }

    @Override
    public String getBorderBottom() {
        return getPropertyValue("border-bottom").toString();
    }

    @Override
    public StyleAdapter setBorderBottom(String borderBottom, boolean important) {
        return setProperty(Style.BORDER_BOTTOM, borderBottom, important);
    }

    @Override
    public StyleAdapter setBorderBottom(String borderBottom) {
        return setBorderBottom(borderBottom, false);
    }

    @Override
    public String getBorderBottomColor() {
        return getPropertyValue("border-bottom-color").toString();
    }

    @Override
    public StyleAdapter setBorderBottomColor(String borderBottomColor, boolean important) {
        return setProperty(Style.BORDER_BOTTOM_COLOR, borderBottomColor, important);
    }

    @Override
    public StyleAdapter setBorderBottomColor(String borderBottomColor) {
        return setBorderBottomColor(borderBottomColor, false);
    }

    @Override
    public Object getBorderBottomLeftRadius() {
        return getPropertyValue("border-bottom-left-radius").toString();
    }

    @Override
    public StyleAdapter setBorderBottomLeftRadius(Object borderBottomLeftRadius, boolean important) {
        return setProperty(Style.BORDER_BOTTOM_LEFT_RADIUS, borderBottomLeftRadius, important);
    }

    @Override
    public StyleAdapter setBorderBottomLeftRadius(Object borderBottomLeftRadius) {
        return setBorderBottomLeftRadius(borderBottomLeftRadius, false);
    }

    @Override
    public Object getBorderBottomRightRadius() {
        return getPropertyValue("border-bottom-right-radius").toString();
    }

    @Override
    public StyleAdapter setBorderBottomRightRadius(Object borderBottomRightRadius, boolean important) {
        return setProperty(Style.BORDER_BOTTOM_RIGHT_RADIUS, borderBottomRightRadius, important);
    }

    @Override
    public StyleAdapter setBorderBottomRightRadius(Object borderBottomRightRadius) {
        return setBorderBottomRightRadius(borderBottomRightRadius, false);
    }

    @Override
    public String getBorderBottomStyle() {
        return getPropertyValue("border-bottom-style").toString();
    }

    @Override
    public StyleAdapter setBorderBottomStyle(String borderBottomStyle, boolean important) {
        return setProperty(Style.BORDER_BOTTOM_STYLE, borderBottomStyle, important);
    }

    @Override
    public StyleAdapter setBorderBottomStyle(String borderBottomStyle) {
        return setBorderBottomStyle(borderBottomStyle, false);
    }

    @Override
    public Object getBorderBottomWidth() {
        return getPropertyValue("border-bottom-width").toString();
    }

    @Override
    public StyleAdapter setBorderBottomWidth(Object borderBottomWidth, boolean important) {
        return setProperty(Style.BORDER_BOTTOM_WIDTH, borderBottomWidth, important);
    }

    @Override
    public StyleAdapter setBorderBottomWidth(Object borderBottomWidth) {
        return setBorderBottomWidth(borderBottomWidth, false);
    }

    @Override
    public String getBorderCollapse() {
        return getPropertyValue("border-collapse").toString();
    }

    @Override
    public StyleAdapter setBorderCollapse(String borderCollapse, boolean important) {
        return setProperty(Style.BORDER_COLLAPSE, borderCollapse, important);
    }

    @Override
    public StyleAdapter setBorderCollapse(String borderCollapse) {
        return setBorderCollapse(borderCollapse, false);
    }

    @Override
    public String getBorderColor() {
        return getPropertyValue("border-color").toString();
    }

    @Override
    public StyleAdapter setBorderColor(String borderColor, boolean important) {
        return setProperty(Style.BORDER_COLOR, borderColor, important);
    }

    @Override
    public StyleAdapter setBorderColor(String borderColor) {
        return setBorderColor(borderColor, false);
    }

    @Override
    public String getBorderImage() {
        return getPropertyValue("border-image").toString();
    }

    @Override
    public StyleAdapter setBorderImage(String borderImage, boolean important) {
        return setProperty(Style.BORDER_IMAGE, borderImage, important);
    }

    @Override
    public StyleAdapter setBorderImage(String borderImage) {
        return setBorderImage(borderImage, false);
    }

    @Override
    public Object getBorderImageOutset() {
        return getPropertyValue("border-image-outset").toString();
    }

    @Override
    public StyleAdapter setBorderImageOutset(Object borderImageOutset, boolean important) {
        return setProperty(Style.BORDER_IMAGE_OUTSET, borderImageOutset, important);
    }

    @Override
    public StyleAdapter setBorderImageOutset(Object borderImageOutset) {
        return setBorderImageOutset(borderImageOutset, false);
    }

    @Override
    public String getBorderImageRepeat() {
        return getPropertyValue("border-image-repeat").toString();
    }

    @Override
    public StyleAdapter setBorderImageRepeat(String borderImageRepeat, boolean important) {
        return setProperty(Style.BORDER_IMAGE_REPEAT, borderImageRepeat, important);
    }

    @Override
    public StyleAdapter setBorderImageRepeat(String borderImageRepeat) {
        return setBorderImageRepeat(borderImageRepeat, false);
    }

    @Override
    public Object getBorderImageSlice() {
        return getPropertyValue("border-image-slice").toString();
    }

    @Override
    public StyleAdapter setBorderImageSlice(Object borderImageSlice, boolean important) {
        return setProperty(Style.BORDER_IMAGE_SLICE, borderImageSlice, important);
    }

    @Override
    public StyleAdapter setBorderImageSlice(Object borderImageSlice) {
        return setBorderImageSlice(borderImageSlice, false);
    }

    @Override
    public String getBorderImageSource() {
        return getPropertyValue("border-image-source").toString();
    }

    @Override
    public StyleAdapter setBorderImageSource(String borderImageSource, boolean important) {
        return setProperty(Style.BORDER_IMAGE_SOURCE, borderImageSource, important);
    }

    @Override
    public StyleAdapter setBorderImageSource(String borderImageSource) {
        return setBorderImageSource(borderImageSource, false);
    }

    @Override
    public Object getBorderImageWidth() {
        return getPropertyValue("border-image-width").toString();
    }

    @Override
    public StyleAdapter setBorderImageWidth(Object borderImageWidth, boolean important) {
        return setProperty(Style.BORDER_IMAGE_WIDTH, borderImageWidth, important);
    }

    @Override
    public StyleAdapter setBorderImageWidth(Object borderImageWidth) {
        return setBorderImageWidth(borderImageWidth, false);
    }

    @Override
    public String getBorderLeft() {
        return getPropertyValue("border-left").toString();
    }

    @Override
    public StyleAdapter setBorderLeft(String borderLeft, boolean important) {
        return setProperty(Style.BORDER_LEFT, borderLeft, important);
    }

    @Override
    public StyleAdapter setBorderLeft(String borderLeft) {
        return setBorderLeft(borderLeft, false);
    }

    @Override
    public String getBorderLeftColor() {
        return getPropertyValue("border-left-color").toString();
    }

    @Override
    public StyleAdapter setBorderLeftColor(String borderLeftColor, boolean important) {
        return setProperty(Style.BORDER_LEFT_COLOR, borderLeftColor, important);
    }

    @Override
    public StyleAdapter setBorderLeftColor(String borderLeftColor) {
        return setBorderLeftColor(borderLeftColor, false);
    }

    @Override
    public String getBorderLeftStyle() {
        return getPropertyValue("border-left-style").toString();
    }

    @Override
    public StyleAdapter setBorderLeftStyle(String borderLeftStyle, boolean important) {
        return setProperty(Style.BORDER_LEFT_STYLE, borderLeftStyle, important);
    }

    @Override
    public StyleAdapter setBorderLeftStyle(String borderLeftStyle) {
        return setBorderLeftStyle(borderLeftStyle, false);
    }

    @Override
    public Object getBorderLeftWidth() {
        return getPropertyValue("border-left-width").toString();
    }

    @Override
    public StyleAdapter setBorderLeftWidth(Object borderLeftWidth, boolean important) {
        return setProperty(Style.BORDER_LEFT_WIDTH, borderLeftWidth, important);
    }

    @Override
    public StyleAdapter setBorderLeftWidth(Object borderLeftWidth) {
        return setBorderLeftWidth(borderLeftWidth, false);
    }

    @Override
    public Object getBorderRadius() {
        return getPropertyValue("border-radius").toString();
    }

    @Override
    public StyleAdapter setBorderRadius(Object borderRadius, boolean important) {
        return setProperty(Style.BORDER_RADIUS, borderRadius, important);
    }

    @Override
    public StyleAdapter setBorderRadius(Object borderRadius) {
        return setBorderRadius(borderRadius, false);
    }

    @Override
    public String getBorderRight() {
        return getPropertyValue("border-right").toString();
    }

    @Override
    public StyleAdapter setBorderRight(String borderRight, boolean important) {
        return setProperty(Style.BORDER_RIGHT, borderRight, important);
    }

    @Override
    public StyleAdapter setBorderRight(String borderRight) {
        return setBorderRight(borderRight, false);
    }

    @Override
    public String getBorderRightColor() {
        return getPropertyValue("border-right-color").toString();
    }

    @Override
    public StyleAdapter setBorderRightColor(String borderRightColor, boolean important) {
        return setProperty(Style.BORDER_RIGHT_COLOR, borderRightColor, important);
    }

    @Override
    public StyleAdapter setBorderRightColor(String borderRightColor) {
        return setBorderRightColor(borderRightColor, false);
    }

    @Override
    public String getBorderRightStyle() {
        return getPropertyValue("border-right-style").toString();
    }

    @Override
    public StyleAdapter setBorderRightStyle(String borderRightStyle, boolean important) {
        return setProperty(Style.BORDER_RIGHT_STYLE, borderRightStyle, important);
    }

    @Override
    public StyleAdapter setBorderRightStyle(String borderRightStyle) {
        return setBorderRightStyle(borderRightStyle, false);
    }

    @Override
    public Object getBorderRightWidth() {
        return getPropertyValue("border-right-width").toString();
    }

    @Override
    public StyleAdapter setBorderRightWidth(Object borderRightWidth, boolean important) {
        return setProperty(Style.BORDER_RIGHT_WIDTH, borderRightWidth, important);
    }

    @Override
    public StyleAdapter setBorderRightWidth(Object borderRightWidth) {
        return setBorderRightWidth(borderRightWidth, false);
    }

    @Override
    public String getBorderSpacing() {
        return getPropertyValue("border-spacing").toString();
    }

    @Override
    public StyleAdapter setBorderSpacing(String borderSpacing, boolean important) {
        return setProperty(Style.BORDER_SPACING, borderSpacing, important);
    }

    @Override
    public StyleAdapter setBorderSpacing(String borderSpacing) {
        return setBorderSpacing(borderSpacing, false);
    }

    @Override
    public String getBorderStyle() {
        return getPropertyValue("border-style").toString();
    }

    @Override
    public StyleAdapter setBorderStyle(String borderStyle, boolean important) {
        return setProperty(Style.BORDER_STYLE, borderStyle, important);
    }

    @Override
    public StyleAdapter setBorderStyle(String borderStyle) {
        return setBorderStyle(borderStyle, false);
    }

    @Override
    public String getBorderTop() {
        return getPropertyValue("border-top").toString();
    }

    @Override
    public StyleAdapter setBorderTop(String borderTop, boolean important) {
        return setProperty(Style.BORDER_TOP, borderTop, important);
    }

    @Override
    public StyleAdapter setBorderTop(String borderTop) {
        return setBorderTop(borderTop, false);
    }

    @Override
    public String getBorderTopColor() {
        return getPropertyValue("border-top-color").toString();
    }

    @Override
    public StyleAdapter setBorderTopColor(String borderTopColor, boolean important) {
        return setProperty(Style.BORDER_TOP_COLOR, borderTopColor, important);
    }

    @Override
    public StyleAdapter setBorderTopColor(String borderTopColor) {
        return setBorderTopColor(borderTopColor, false);
    }

    @Override
    public Object getBorderTopLeftRadius() {
        return getPropertyValue("border-top-left-radius").toString();
    }

    @Override
    public StyleAdapter setBorderTopLeftRadius(Object borderTopLeftRadius, boolean important) {
        return setProperty(Style.BORDER_TOP_LEFT_RADIUS, borderTopLeftRadius, important);
    }

    @Override
    public StyleAdapter setBorderTopLeftRadius(Object borderTopLeftRadius) {
        return setBorderTopLeftRadius(borderTopLeftRadius, false);
    }

    @Override
    public Object getBorderTopRightRadius() {
        return getPropertyValue("border-top-right-radius").toString();
    }

    @Override
    public StyleAdapter setBorderTopRightRadius(Object borderTopRightRadius, boolean important) {
        return setProperty(Style.BORDER_TOP_RIGHT_RADIUS, borderTopRightRadius, important);
    }

    @Override
    public StyleAdapter setBorderTopRightRadius(Object borderTopRightRadius) {
        return setBorderTopRightRadius(borderTopRightRadius, false);
    }

    @Override
    public String getBorderTopStyle() {
        return getPropertyValue("border-top-style").toString();
    }

    @Override
    public StyleAdapter setBorderTopStyle(String borderTopStyle, boolean important) {
        return setProperty(Style.BORDER_TOP_STYLE, borderTopStyle, important);
    }

    @Override
    public StyleAdapter setBorderTopStyle(String borderTopStyle) {
        return setBorderTopStyle(borderTopStyle, false);
    }

    @Override
    public Object getBorderTopWidth() {
        return getPropertyValue("border-top-width").toString();
    }

    @Override
    public StyleAdapter setBorderTopWidth(Object borderTopWidth, boolean important) {
        return setProperty(Style.BORDER_TOP_WIDTH, borderTopWidth, important);
    }

    @Override
    public StyleAdapter setBorderTopWidth(Object borderTopWidth) {
        return setBorderTopWidth(borderTopWidth, false);
    }

    @Override
    public Object getBorderWidth() {
        return getPropertyValue("border-width").toString();
    }

    @Override
    public StyleAdapter setBorderWidth(Object borderWidth, boolean important) {
        return setProperty(Style.BORDER_WIDTH, borderWidth, important);
    }

    @Override
    public StyleAdapter setBorderWidth(Object borderWidth) {
        return setBorderWidth(borderWidth, false);
    }

    @Override
    public Object getBottom() {
        return getPropertyValue("bottom").toString();
    }

    @Override
    public StyleAdapter setBottom(Object bottom, boolean important) {
        return setProperty(Style.BOTTOM, bottom, important);
    }

    @Override
    public StyleAdapter setBottom(Object bottom) {
        return setBottom(bottom, false);
    }

    @Override
    public String getBoxShadow() {
        return getPropertyValue("box-shadow").toString();
    }

    @Override
    public StyleAdapter setBoxShadow(String boxShadow, boolean important) {
        return setProperty(Style.BOX_SHADOW, boxShadow, important);
    }

    @Override
    public StyleAdapter setBoxShadow(String boxShadow) {
        return setBoxShadow(boxShadow, false);
    }

    @Override
    public String getBoxSizing() {
        return getPropertyValue("box-sizing").toString();
    }

    @Override
    public StyleAdapter setBoxSizing(String boxSizing, boolean important) {
        return setProperty(Style.BOX_SIZING, boxSizing, important);
    }

    @Override
    public StyleAdapter setBoxSizing(String boxSizing) {
        return setBoxSizing(boxSizing, false);
    }

    @Override
    public String getCaptionSide() {
        return getPropertyValue("caption-side").toString();
    }

    @Override
    public StyleAdapter setCaptionSide(String captionSide, boolean important) {
        return setProperty(Style.CAPTION_SIDE, captionSide, important);
    }

    @Override
    public StyleAdapter setCaptionSide(String captionSide) {
        return setCaptionSide(captionSide, false);
    }

    @Override
    public String getClear() {
        return getPropertyValue("clear").toString();
    }

    @Override
    public StyleAdapter setClear(String clear, boolean important) {
        return setProperty(Style.CLEAR, clear, important);
    }

    @Override
    public StyleAdapter setClear(String clear) {
        return setClear(clear, false);
    }

    @Override
    public String getClip() {
        return getPropertyValue("clip").toString();
    }

    @Override
    public StyleAdapter setClip(String clip, boolean important) {
        return setProperty(Style.CLIP, clip, important);
    }

    @Override
    public StyleAdapter setClip(String clip) {
        return setClip(clip, false);
    }

    @Override
    public String getClipPath() {
        return getPropertyValue("clip-path").toString();
    }

    @Override
    public StyleAdapter setClipPath(String clipPath, boolean important) {
        return setProperty(Style.CLIP_PATH, clipPath, important);
    }

    @Override
    public StyleAdapter setClipPath(String clipPath) {
        return setClipPath(clipPath, false);
    }

    @Override
    public String getColor() {
        return getPropertyValue("color").toString();
    }

    @Override
    public StyleAdapter setColor(String color, boolean important) {
        return setProperty(Style.COLOR, color, important);
    }

    @Override
    public StyleAdapter setColor(String color) {
        return setColor(color, false);
    }

    @Override
    public String getContain() {
        return getPropertyValue("contain").toString();
    }

    @Override
    public StyleAdapter setContain(String contain, boolean important) {
        return setProperty(Style.CONTAIN, contain, important);
    }

    @Override
    public StyleAdapter setContain(String contain) {
        return setContain(contain, false);
    }

    @Override
    public String getContent() {
        return getPropertyValue("content").toString();
    }

    @Override
    public StyleAdapter setContent(String content, boolean important) {
        return setProperty(Style.CONTENT, content, important);
    }

    @Override
    public StyleAdapter setContent(String content) {
        return setContent(content, false);
    }

    @Override
    public String getContentVisibility() {
        return getPropertyValue("content-visibility").toString();
    }

    @Override
    public StyleAdapter setContentVisibility(String contentVisibility, boolean important) {
        return setProperty(Style.CONTENT_VISIBILITY, contentVisibility, important);
    }

    @Override
    public StyleAdapter setContentVisibility(String contentVisibility) {
        return setContentVisibility(contentVisibility, false);
    }

    @Override
    public String getCounterIncrement() {
        return getPropertyValue("counter-increment").toString();
    }

    @Override
    public StyleAdapter setCounterIncrement(String counterIncrement, boolean important) {
        return setProperty(Style.COUNTER_INCREMENT, counterIncrement, important);
    }

    @Override
    public StyleAdapter setCounterIncrement(String counterIncrement) {
        return setCounterIncrement(counterIncrement, false);
    }

    @Override
    public String getCounterReset() {
        return getPropertyValue("counter-reset").toString();
    }

    @Override
    public StyleAdapter setCounterReset(String counterReset, boolean important) {
        return setProperty(Style.COUNTER_RESET, counterReset, important);
    }

    @Override
    public StyleAdapter setCounterReset(String counterReset) {
        return setCounterReset(counterReset, false);
    }

    @Override
    public String getCssFloat() {
        return getPropertyValue("float").toString();
    }

    @Override
    public StyleAdapter setCssFloat(String cssFloat, boolean important) {
        return setProperty(Style.CSS_FLOAT, cssFloat, important);
    }

    @Override
    public StyleAdapter setCssFloat(String cssFloat) {
        return setCssFloat(cssFloat, false);
    }

    @Override
    public String getCursor() {
        return getPropertyValue("cursor").toString();
    }

    @Override
    public StyleAdapter setCursor(String cursor, boolean important) {
        return setProperty(Style.CURSOR, cursor, important);
    }

    @Override
    public StyleAdapter setCursor(String cursor) {
        return setCursor(cursor, false);
    }

    @Override
    public String getDirection() {
        return getPropertyValue("direction").toString();
    }

    @Override
    public StyleAdapter setDirection(String direction, boolean important) {
        return setProperty(Style.DIRECTION, direction, important);
    }

    @Override
    public StyleAdapter setDirection(String direction) {
        return setDirection(direction, false);
    }

    @Override
    public String getDisplay() {
        return getPropertyValue("display").toString();
    }

    @Override
    public StyleAdapter setDisplay(String display, boolean important) {
        return setProperty(Style.DISPLAY, display, important);
    }

    @Override
    public StyleAdapter setDisplay(String display) {
        return setDisplay(display, false);
    }

    @Override
    public String getEmptyCells() {
        return getPropertyValue("empty-cells").toString();
    }

    @Override
    public StyleAdapter setEmptyCells(String emptyCells, boolean important) {
        return setProperty(Style.EMPTY_CELLS, emptyCells, important);
    }

    @Override
    public StyleAdapter setEmptyCells(String emptyCells) {
        return setEmptyCells(emptyCells, false);
    }

    @Override
    public String getFlex() {
        return getPropertyValue("flex").toString();
    }

    @Override
    public StyleAdapter setFlex(String flex, boolean important) {
        return setProperty(Style.FLEX, flex, important);
    }

    @Override
    public StyleAdapter setFlex(String flex) {
        return setFlex(flex, false);
    }

    @Override
    public String getFlexBasis() {
        return getPropertyValue("flex-basis").toString();
    }

    @Override
    public StyleAdapter setFlexBasis(String flexBasis, boolean important) {
        return setProperty(Style.FLEX_BASIS, flexBasis, important);
    }

    @Override
    public StyleAdapter setFlexBasis(String flexBasis) {
        return setFlexBasis(flexBasis, false);
    }

    @Override
    public String getFlexDirection() {
        return getPropertyValue("flex-direction").toString();
    }

    @Override
    public StyleAdapter setFlexDirection(String flexDirection, boolean important) {
        return setProperty(Style.FLEX_DIRECTION, flexDirection, important);
    }

    @Override
    public StyleAdapter setFlexDirection(String flexDirection) {
        return setFlexDirection(flexDirection, false);
    }

    @Override
    public String getFlexFlow() {
        return getPropertyValue("flex-flow").toString();
    }

    @Override
    public StyleAdapter setFlexFlow(String flexFlow, boolean important) {
        return setProperty(Style.FLEX_FLOW, flexFlow, important);
    }

    @Override
    public StyleAdapter setFlexFlow(String flexFlow) {
        return setFlexFlow(flexFlow, false);
    }

    @Override
    public double getFlexGrow() {
        return ((Number) (getPropertyValue("flex-grow"))).doubleValue();
    }

    @Override
    public StyleAdapter setFlexGrow(double flexGrow, boolean important) {
        return setProperty(Style.FLEX_GROW, flexGrow, important);
    }

    @Override
    public StyleAdapter setFlexGrow(double flexGrow) {
        return setFlexGrow(flexGrow, false);
    }

    @Override
    public double getFlexShrink() {
        return ((Number) (getPropertyValue("flex-shrink"))).doubleValue();
    }

    @Override
    public StyleAdapter setFlexShrink(double flexShrink, boolean important) {
        return setProperty(Style.FLEX_SHRINK, flexShrink, important);
    }

    @Override
    public StyleAdapter setFlexShrink(double flexShrink) {
        return setFlexShrink(flexShrink, false);
    }

    @Override
    public String getFlexWrap() {
        return getPropertyValue("flex-wrap").toString();
    }

    @Override
    public StyleAdapter setFlexWrap(String flexWrap, boolean important) {
        return setProperty(Style.FLEX_WRAP, flexWrap, important);
    }

    @Override
    public StyleAdapter setFlexWrap(String flexWrap) {
        return setFlexWrap(flexWrap, false);
    }

    @Override
    public String getFont() {
        return getPropertyValue("font").toString();
    }

    @Override
    public StyleAdapter setFont(String font, boolean important) {
        return setProperty(Style.FONT, font, important);
    }

    @Override
    public StyleAdapter setFont(String font) {
        return setFont(font, false);
    }

    @Override
    public String getFontFamily() {
        return getPropertyValue("font-family").toString();
    }

    @Override
    public StyleAdapter setFontFamily(String fontFamily, boolean important) {
        return setProperty(Style.FONT_FAMILY, fontFamily, important);
    }

    @Override
    public StyleAdapter setFontFamily(String fontFamily) {
        return setFontFamily(fontFamily, false);
    }

    @Override
    public Object getFontSize() {
        return getPropertyValue("font-size").toString();
    }

    @Override
    public StyleAdapter setFontSize(Object fontSize, boolean important) {
        return setProperty(Style.FONT_SIZE, fontSize, important);
    }

    @Override
    public StyleAdapter setFontSize(Object fontSize) {
        return setFontSize(fontSize, false);
    }

    @Override
    public String getFontSizeAdjust() {
        return getPropertyValue("font-size-adjust").toString();
    }

    @Override
    public StyleAdapter setFontSizeAdjust(String fontSizeAdjust, boolean important) {
        return setProperty(Style.FONT_SIZE_ADJUST, fontSizeAdjust, important);
    }

    @Override
    public StyleAdapter setFontSizeAdjust(String fontSizeAdjust) {
        return setFontSizeAdjust(fontSizeAdjust, false);
    }

    @Override
    public String getFontStretch() {
        return getPropertyValue("font-stretch").toString();
    }

    @Override
    public StyleAdapter setFontStretch(String fontStretch, boolean important) {
        return setProperty(Style.FONT_STRETCH, fontStretch, important);
    }

    @Override
    public StyleAdapter setFontStretch(String fontStretch) {
        return setFontStretch(fontStretch, false);
    }

    @Override
    public String getFontStyle() {
        return getPropertyValue("font-style").toString();
    }

    @Override
    public StyleAdapter setFontStyle(String fontStyle, boolean important) {
        return setProperty(Style.FONT_STYLE, fontStyle, important);
    }

    @Override
    public StyleAdapter setFontStyle(String fontStyle) {
        return setFontStyle(fontStyle, false);
    }

    @Override
    public String getFontVariant() {
        return getPropertyValue("font-variant").toString();
    }

    @Override
    public StyleAdapter setFontVariant(String fontVariant, boolean important) {
        return setProperty(Style.FONT_VARIANT, fontVariant, important);
    }

    @Override
    public StyleAdapter setFontVariant(String fontVariant) {
        return setFontVariant(fontVariant, false);
    }

    @Override
    public String getFontWeight() {
        return getPropertyValue("font-weight").toString();
    }

    @Override
    public StyleAdapter setFontWeight(String fontWeight, boolean important) {
        return setProperty(Style.FONT_WEIGHT, fontWeight, important);
    }

    @Override
    public StyleAdapter setFontWeight(String fontWeight) {
        return setFontWeight(fontWeight, false);
    }

    @Override
    public String getGrid() {
        return getPropertyValue("grid").toString();
    }

    @Override
    public StyleAdapter setGrid(String grid, boolean important) {
        return setProperty(Style.GRID, grid, important);
    }

    @Override
    public StyleAdapter setGrid(String grid) {
        return setGrid(grid, false);
    }

    @Override
    public String getGridArea() {
        return getPropertyValue("grid-area").toString();
    }

    @Override
    public StyleAdapter setGridArea(String gridArea, boolean important) {
        return setProperty(Style.GRID_AREA, gridArea, important);
    }

    @Override
    public StyleAdapter setGridArea(String gridArea) {
        return setGridArea(gridArea, false);
    }

    @Override
    public String getGridAutoColumns() {
        return getPropertyValue("grid-auto-columns").toString();
    }

    @Override
    public StyleAdapter setGridAutoColumns(String gridAutoColumns, boolean important) {
        return setProperty(Style.GRID_AUTO_COLUMNS, gridAutoColumns, important);
    }

    @Override
    public StyleAdapter setGridAutoColumns(String gridAutoColumns) {
        return setGridAutoColumns(gridAutoColumns, false);
    }

    @Override
    public String getGridAutoRows() {
        return getPropertyValue("grid-auto-rows").toString();
    }

    @Override
    public StyleAdapter setGridAutoRows(String gridAutoRows, boolean important) {
        return setProperty(Style.GRID_AUTO_ROWS, gridAutoRows, important);
    }

    @Override
    public StyleAdapter setGridAutoRows(String gridAutoRows) {
        return setGridAutoRows(gridAutoRows, false);
    }

    @Override
    public String getGridColumn() {
        return getPropertyValue("grid-column").toString();
    }

    @Override
    public StyleAdapter setGridColumn(String gridColumn, boolean important) {
        return setProperty(Style.GRID_COLUMN, gridColumn, important);
    }

    @Override
    public StyleAdapter setGridColumn(String gridColumn) {
        return setGridColumn(gridColumn, false);
    }

    @Override
    public String getGridColumnEnd() {
        return getPropertyValue("grid-column-end").toString();
    }

    @Override
    public StyleAdapter setGridColumnEnd(String gridColumnEnd, boolean important) {
        return setProperty(Style.GRID_COLUMN_END, gridColumnEnd, important);
    }

    @Override
    public StyleAdapter setGridColumnEnd(String gridColumnEnd) {
        return setGridColumnEnd(gridColumnEnd, false);
    }

    @Override
    public String getGridColumnStart() {
        return getPropertyValue("grid-column-start").toString();
    }

    @Override
    public StyleAdapter setGridColumnStart(String gridColumnStart, boolean important) {
        return setProperty(Style.GRID_COLUMN_START, gridColumnStart, important);
    }

    @Override
    public StyleAdapter setGridColumnStart(String gridColumnStart) {
        return setGridColumnStart(gridColumnStart, false);
    }

    @Override
    public String getGridRow() {
        return getPropertyValue("grid-row").toString();
    }

    @Override
    public StyleAdapter setGridRow(String gridRow, boolean important) {
        return setProperty(Style.GRID_ROW, gridRow, important);
    }

    @Override
    public StyleAdapter setGridRow(String gridRow) {
        return setGridRow(gridRow, false);
    }

    @Override
    public String getGridRowEnd() {
        return getPropertyValue("grid-row-end").toString();
    }

    @Override
    public StyleAdapter setGridRowEnd(String gridRowEnd, boolean important) {
        return setProperty(Style.GRID_ROW_END, gridRowEnd, important);
    }

    @Override
    public StyleAdapter setGridRowEnd(String gridRowEnd) {
        return setGridRowEnd(gridRowEnd, false);
    }

    @Override
    public String getGridRowStart() {
        return getPropertyValue("grid-row-start").toString();
    }

    @Override
    public StyleAdapter setGridRowStart(String gridRowStart, boolean important) {
        return setProperty(Style.GRID_ROW_START, gridRowStart, important);
    }

    @Override
    public StyleAdapter setGridRowStart(String gridRowStart) {
        return setGridRowStart(gridRowStart, false);
    }

    @Override
    public String getGridTemplate() {
        return getPropertyValue("grid-template").toString();
    }

    @Override
    public StyleAdapter setGridTemplate(String gridTemplate, boolean important) {
        return setProperty(Style.GRID_TEMPLATE, gridTemplate, important);
    }

    @Override
    public StyleAdapter setGridTemplate(String gridTemplate) {
        return setGridTemplate(gridTemplate, false);
    }

    @Override
    public String getGridTemplateAreas() {
        return getPropertyValue("grid-template-areas").toString();
    }

    @Override
    public StyleAdapter setGridTemplateAreas(String gridTemplateAreas, boolean important) {
        return setProperty(Style.GRID_TEMPLATE_AREAS, gridTemplateAreas, important);
    }

    @Override
    public StyleAdapter setGridTemplateAreas(String gridTemplateAreas) {
        return setGridTemplateAreas(gridTemplateAreas, false);
    }

    @Override
    public String getGridTemplateColumns() {
        return getPropertyValue("grid-template-columns").toString();
    }

    @Override
    public StyleAdapter setGridTemplateColumns(String gridTemplateColumns, boolean important) {
        return setProperty(Style.GRID_TEMPLATE_COLUMNS, gridTemplateColumns, important);
    }

    @Override
    public StyleAdapter setGridTemplateColumns(String gridTemplateColumns) {
        return setGridTemplateColumns(gridTemplateColumns, false);
    }

    @Override
    public String getGridTemplateRows() {
        return getPropertyValue("grid-template-rows").toString();
    }

    @Override
    public StyleAdapter setGridTemplateRows(String gridTemplateRows, boolean important) {
        return setProperty(Style.GRID_TEMPLATE_ROWS, gridTemplateRows, important);
    }

    @Override
    public StyleAdapter setGridTemplateRows(String gridTemplateRows) {
        return setGridTemplateRows(gridTemplateRows, false);
    }

    @Override
    public Object getHeight() {
        return getPropertyValue("height").toString();
    }

    @Override
    public StyleAdapter setHeight(Object height, boolean important) {
        return setProperty(Style.HEIGHT, height, important);
    }

    @Override
    public StyleAdapter setHeight(Object height) {
        return setHeight(height, false);
    }

    @Override
    public String getJustifyContent() {
        return getPropertyValue("justify-content").toString();
    }

    @Override
    public StyleAdapter setJustifyContent(String justifyContent, boolean important) {
        return setProperty(Style.JUSTIFY_CONTENT, justifyContent, important);
    }

    @Override
    public StyleAdapter setJustifyContent(String justifyContent) {
        return setJustifyContent(justifyContent, false);
    }

    @Override
    public Object getLeft() {
        return getPropertyValue("left").toString();
    }

    @Override
    public StyleAdapter setLeft(Object left, boolean important) {
        return setProperty(Style.LEFT, left, important);
    }

    @Override
    public StyleAdapter setLeft(Object left) {
        return setLeft(left, false);
    }

    @Override
    public String getLetterSpacing() {
        return getPropertyValue("letter-spacing").toString();
    }

    @Override
    public StyleAdapter setLetterSpacing(String letterSpacing, boolean important) {
        return setProperty(Style.LETTER_SPACING, letterSpacing, important);
    }

    @Override
    public StyleAdapter setLetterSpacing(String letterSpacing) {
        return setLetterSpacing(letterSpacing, false);
    }

    @Override
    public Object getLineHeight() {
        return getPropertyValue("line-height").toString();
    }

    @Override
    public StyleAdapter setLineHeight(Object lineHeight, boolean important) {
        return setProperty(Style.LINE_HEIGHT, lineHeight, important);
    }

    @Override
    public StyleAdapter setLineHeight(Object lineHeight) {
        return setLineHeight(lineHeight, false);
    }

    @Override
    public String getListStyle() {
        return getPropertyValue("list-style").toString();
    }

    @Override
    public StyleAdapter setListStyle(String listStyle, boolean important) {
        return setProperty(Style.LIST_STYLE, listStyle, important);
    }

    @Override
    public StyleAdapter setListStyle(String listStyle) {
        return setListStyle(listStyle, false);
    }

    @Override
    public String getListStyleImage() {
        return getPropertyValue("list-style-image").toString();
    }

    @Override
    public StyleAdapter setListStyleImage(String listStyleImage, boolean important) {
        return setProperty(Style.LIST_STYLE_IMAGE, listStyleImage, important);
    }

    @Override
    public StyleAdapter setListStyleImage(String listStyleImage) {
        return setListStyleImage(listStyleImage, false);
    }

    @Override
    public String getListStylePosition() {
        return getPropertyValue("list-style-position").toString();
    }

    @Override
    public StyleAdapter setListStylePosition(String listStylePosition, boolean important) {
        return setProperty(Style.LIST_STYLE_POSITION, listStylePosition, important);
    }

    @Override
    public StyleAdapter setListStylePosition(String listStylePosition) {
        return setListStylePosition(listStylePosition, false);
    }

    @Override
    public String getListStyleType() {
        return getPropertyValue("list-style-type").toString();
    }

    @Override
    public StyleAdapter setListStyleType(String listStyleType, boolean important) {
        return setProperty(Style.LIST_STYLE_TYPE, listStyleType, important);
    }

    @Override
    public StyleAdapter setListStyleType(String listStyleType) {
        return setListStyleType(listStyleType, false);
    }

    @Override
    public Object getMargin() {
        return getPropertyValue("margin").toString();
    }

    @Override
    public StyleAdapter setMargin(Object margin, boolean important) {
        return setProperty(Style.MARGIN, margin, important);
    }

    @Override
    public StyleAdapter setMargin(Object margin) {
        return setMargin(margin, false);
    }

    @Override
    public Object getMarginBottom() {
        return getPropertyValue("margin-bottom").toString();
    }

    @Override
    public StyleAdapter setMarginBottom(Object marginBottom, boolean important) {
        return setProperty(Style.MARGIN_BOTTOM, marginBottom, important);
    }

    @Override
    public StyleAdapter setMarginBottom(Object marginBottom) {
        return setMarginBottom(marginBottom, false);
    }

    @Override
    public Object getMarginLeft() {
        return getPropertyValue("margin-left").toString();
    }

    @Override
    public StyleAdapter setMarginLeft(Object marginLeft, boolean important) {
        return setProperty(Style.MARGIN_LEFT, marginLeft, important);
    }

    @Override
    public StyleAdapter setMarginLeft(Object marginLeft) {
        return setMarginLeft(marginLeft, false);
    }

    @Override
    public Object getMarginRight() {
        return getPropertyValue("margin-right").toString();
    }

    @Override
    public StyleAdapter setMarginRight(Object marginRight, boolean important) {
        return setProperty(Style.MARGIN_RIGHT, marginRight, important);
    }

    @Override
    public StyleAdapter setMarginRight(Object marginRight) {
        return setMarginRight(marginRight, false);
    }

    @Override
    public Object getMarginTop() {
        return getPropertyValue("margin-top").toString();
    }

    @Override
    public StyleAdapter setMarginTop(Object marginTop, boolean important) {
        return setProperty(Style.MARGIN_TOP, marginTop, important);
    }

    @Override
    public StyleAdapter setMarginTop(Object marginTop) {
        return setMarginTop(marginTop, false);
    }

    @Override
    public String getMask() {
        return getPropertyValue("mask").toString();
    }

    @Override
    public StyleAdapter setMask(String mask, boolean important) {
        return setProperty(Style.MASK, mask, important);
    }

    @Override
    public StyleAdapter setMask(String mask) {
        return setMask(mask, false);
    }

    @Override
    public String getMaskImage() {
        return getPropertyValue("mask-image").toString();
    }

    @Override
    public StyleAdapter setMaskImage(String maskImage, boolean important) {
        return setProperty(Style.MASK_IMAGE, maskImage, important);
    }

    @Override
    public StyleAdapter setMaskImage(String maskImage) {
        return setMaskImage(maskImage, false);
    }

    @Override
    public String getMaskSize() {
        return getPropertyValue("mask-size").toString();
    }

    @Override
    public StyleAdapter setMaskSize(String maskSize, boolean important) {
        return setProperty(Style.MASK_SIZE, maskSize, important);
    }

    @Override
    public StyleAdapter setMaskSize(String maskSize) {
        return setMaskSize(maskSize, false);
    }

    @Override
    public Object getMaxHeight() {
        return getPropertyValue("max-height").toString();
    }

    @Override
    public StyleAdapter setMaxHeight(Object maxHeight, boolean important) {
        return setProperty(Style.MAX_HEIGHT, maxHeight, important);
    }

    @Override
    public StyleAdapter setMaxHeight(Object maxHeight) {
        return setMaxHeight(maxHeight, false);
    }

    @Override
    public Object getMaxWidth() {
        return getPropertyValue("max-width").toString();
    }

    @Override
    public StyleAdapter setMaxWidth(Object maxWidth, boolean important) {
        return setProperty(Style.MAX_WIDTH, maxWidth, important);
    }

    @Override
    public StyleAdapter setMaxWidth(Object maxWidth) {
        return setMaxWidth(maxWidth, false);
    }

    @Override
    public Object getMinHeight() {
        return getPropertyValue("min-height").toString();
    }

    @Override
    public StyleAdapter setMinHeight(Object minHeight, boolean important) {
        return setProperty(Style.MIN_HEIGHT, minHeight, important);
    }

    @Override
    public StyleAdapter setMinHeight(Object minHeight) {
        return setMinHeight(minHeight, false);
    }

    @Override
    public Object getMinWidth() {
        return getPropertyValue("min-width").toString();
    }

    @Override
    public StyleAdapter setMinWidth(Object minWidth, boolean important) {
        return setProperty(Style.MIN_WIDTH, minWidth, important);
    }

    @Override
    public StyleAdapter setMinWidth(Object minWidth) {
        return setMinWidth(minWidth, false);
    }

    @Override
    public String getObjectFit() {
        return getPropertyValue("object-fit").toString();
    }

    @Override
    public StyleAdapter setObjectFit(String objectFit, boolean important) {
        return setProperty(Style.OBJECT_FIT, objectFit, important);
    }

    @Override
    public StyleAdapter setObjectFit(String objectFit) {
        return setObjectFit(objectFit, false);
    }

    @Override
    public String getObjectPosition() {
        return getPropertyValue("object-position").toString();
    }

    @Override
    public StyleAdapter setObjectPosition(String objectPosition, boolean important) {
        return setProperty(Style.OBJECT_POSITION, objectPosition, important);
    }

    @Override
    public StyleAdapter setObjectPosition(String objectPosition) {
        return setObjectPosition(objectPosition, false);
    }

    @Override
    public Object getOpacity() {
        return getPropertyValue("opacity").toString();
    }

    @Override
    public StyleAdapter setOpacity(Object opacity, boolean important) {
        return setProperty(Style.OPACITY, opacity, important);
    }

    @Override
    public StyleAdapter setOpacity(Object opacity) {
        return setOpacity(opacity, false);
    }

    @Override
    public int getOrder() {
        return ((Number) (getPropertyValue("order"))).intValue();
    }

    @Override
    public StyleAdapter setOrder(int order, boolean important) {
        return setProperty(Style.ORDER, order, important);
    }

    @Override
    public StyleAdapter setOrder(int order) {
        return setOrder(order, false);
    }

    @Override
    public String getOrphans() {
        return getPropertyValue("orphans").toString();
    }

    @Override
    public StyleAdapter setOrphans(String orphans, boolean important) {
        return setProperty(Style.ORPHANS, orphans, important);
    }

    @Override
    public StyleAdapter setOrphans(String orphans) {
        return setOrphans(orphans, false);
    }

    @Override
    public String getOutline() {
        return getPropertyValue("outline").toString();
    }

    @Override
    public StyleAdapter setOutline(String outline, boolean important) {
        return setProperty(Style.OUTLINE, outline, important);
    }

    @Override
    public StyleAdapter setOutline(String outline) {
        return setOutline(outline, false);
    }

    @Override
    public String getOutlineColor() {
        return getPropertyValue("outline-color").toString();
    }

    @Override
    public StyleAdapter setOutlineColor(String outlineColor, boolean important) {
        return setProperty(Style.OUTLINE_COLOR, outlineColor, important);
    }

    @Override
    public StyleAdapter setOutlineColor(String outlineColor) {
        return setOutlineColor(outlineColor, false);
    }

    @Override
    public String getOutlineOffset() {
        return getPropertyValue("outline-offset").toString();
    }

    @Override
    public StyleAdapter setOutlineOffset(String outlineOffset, boolean important) {
        return setProperty(Style.OUTLINE_OFFSET, outlineOffset, important);
    }

    @Override
    public StyleAdapter setOutlineOffset(String outlineOffset) {
        return setOutlineOffset(outlineOffset, false);
    }

    @Override
    public String getOutlineStyle() {
        return getPropertyValue("outline-style").toString();
    }

    @Override
    public StyleAdapter setOutlineStyle(String outlineStyle, boolean important) {
        return setProperty(Style.OUTLINE_STYLE, outlineStyle, important);
    }

    @Override
    public StyleAdapter setOutlineStyle(String outlineStyle) {
        return setOutlineStyle(outlineStyle, false);
    }

    @Override
    public Object getOutlineWidth() {
        return getPropertyValue("outline-width").toString();
    }

    @Override
    public StyleAdapter setOutlineWidth(Object outlineWidth, boolean important) {
        return setProperty(Style.OUTLINE_WIDTH, outlineWidth, important);
    }

    @Override
    public StyleAdapter setOutlineWidth(Object outlineWidth) {
        return setOutlineWidth(outlineWidth, false);
    }

    @Override
    public String getOverflow() {
        return getPropertyValue("overflow").toString();
    }

    @Override
    public StyleAdapter setOverflow(String overflow, boolean important) {
        return setProperty(Style.OVERFLOW, overflow, important);
    }

    @Override
    public StyleAdapter setOverflow(String overflow) {
        return setOverflow(overflow, false);
    }

    @Override
    public Object getPadding() {
        return getPropertyValue("padding").toString();
    }

    @Override
    public StyleAdapter setPadding(Object padding, boolean important) {
        return setProperty(Style.PADDING, padding, important);
    }

    @Override
    public StyleAdapter setPadding(Object padding) {
        return setPadding(padding, false);
    }

    @Override
    public Object getPaddingBottom() {
        return getPropertyValue("padding-bottom").toString();
    }

    @Override
    public StyleAdapter setPaddingBottom(Object paddingBottom, boolean important) {
        return setProperty(Style.PADDING_BOTTOM, paddingBottom, important);
    }

    @Override
    public StyleAdapter setPaddingBottom(Object paddingBottom) {
        return setPaddingBottom(paddingBottom, false);
    }

    @Override
    public Object getPaddingLeft() {
        return getPropertyValue("padding-left").toString();
    }

    @Override
    public StyleAdapter setPaddingLeft(Object paddingLeft, boolean important) {
        return setProperty(Style.PADDING_LEFT, paddingLeft, important);
    }

    @Override
    public StyleAdapter setPaddingLeft(Object paddingLeft) {
        return setPaddingLeft(paddingLeft, false);
    }

    @Override
    public Object getPaddingRight() {
        return getPropertyValue("padding-right").toString();
    }

    @Override
    public StyleAdapter setPaddingRight(Object paddingRight, boolean important) {
        return setProperty(Style.PADDING_RIGHT, paddingRight, important);
    }

    @Override
    public StyleAdapter setPaddingRight(Object paddingRight) {
        return setPaddingRight(paddingRight, false);
    }

    @Override
    public Object getPaddingTop() {
        return getPropertyValue("padding-top").toString();
    }

    @Override
    public StyleAdapter setPaddingTop(Object paddingTop, boolean important) {
        return setProperty(Style.PADDING_TOP, paddingTop, important);
    }

    @Override
    public StyleAdapter setPaddingTop(Object paddingTop) {
        return setPaddingTop(paddingTop, false);
    }

    @Override
    public String getPage() {
        return getPropertyValue("page").toString();
    }

    @Override
    public StyleAdapter setPage(String page, boolean important) {
        return setProperty(Style.PAGE, page, important);
    }

    @Override
    public StyleAdapter setPage(String page) {
        return setPage(page, false);
    }

    @Override
    public String getPageBreakAfter() {
        return getPropertyValue("page-break-after").toString();
    }

    @Override
    public StyleAdapter setPageBreakAfter(String pageBreakAfter, boolean important) {
        return setProperty(Style.PAGE_BREAK_AFTER, pageBreakAfter, important);
    }

    @Override
    public StyleAdapter setPageBreakAfter(String pageBreakAfter) {
        return setPageBreakAfter(pageBreakAfter, false);
    }

    @Override
    public String getPageBreakBefore() {
        return getPropertyValue("page-break-before").toString();
    }

    @Override
    public StyleAdapter setPageBreakBefore(String pageBreakBefore, boolean important) {
        return setProperty(Style.PAGE_BREAK_BEFORE, pageBreakBefore, important);
    }

    @Override
    public StyleAdapter setPageBreakBefore(String pageBreakBefore) {
        return setPageBreakBefore(pageBreakBefore, false);
    }

    @Override
    public String getPageBreakInside() {
        return getPropertyValue("page-break-inside").toString();
    }

    @Override
    public StyleAdapter setPageBreakInside(String pageBreakInside, boolean important) {
        return setProperty(Style.PAGE_BREAK_INSIDE, pageBreakInside, important);
    }

    @Override
    public StyleAdapter setPageBreakInside(String pageBreakInside) {
        return setPageBreakInside(pageBreakInside, false);
    }

    @Override
    public String getPerspective() {
        return getPropertyValue("perspective").toString();
    }

    @Override
    public StyleAdapter setPerspective(String perspective, boolean important) {
        return setProperty(Style.PERSPECTIVE, perspective, important);
    }

    @Override
    public StyleAdapter setPerspective(String perspective) {
        return setPerspective(perspective, false);
    }

    @Override
    public Object getPerspectiveOrigin() {
        return getPropertyValue("perspective-origin").toString();
    }

    @Override
    public StyleAdapter setPerspectiveOrigin(Object perspectiveOrigin, boolean important) {
        return setProperty(Style.PERSPECTIVE_ORIGIN, perspectiveOrigin, important);
    }

    @Override
    public StyleAdapter setPerspectiveOrigin(Object perspectiveOrigin) {
        return setPerspectiveOrigin(perspectiveOrigin, false);
    }

    @Override
    public String getPointerEvents() {
        return getPropertyValue("pointer-events").toString();
    }

    @Override
    public StyleAdapter setPointerEvents(String pointerEvents, boolean important) {
        return setProperty(Style.POINTER_EVENTS, pointerEvents, important);
    }

    @Override
    public StyleAdapter setPointerEvents(String pointerEvents) {
        return setPointerEvents(pointerEvents, false);
    }

    @Override
    public String getPosition() {
        return getPropertyValue("position").toString();
    }

    @Override
    public StyleAdapter setPosition(String position, boolean important) {
        return setProperty(Style.POSITION, position, important);
    }

    @Override
    public StyleAdapter setPosition(String position) {
        return setPosition(position, false);
    }

    @Override
    public String getQuotes() {
        return getPropertyValue("quotes").toString();
    }

    @Override
    public StyleAdapter setQuotes(String quotes, boolean important) {
        return setProperty(Style.QUOTES, quotes, important);
    }

    @Override
    public StyleAdapter setQuotes(String quotes) {
        return setQuotes(quotes, false);
    }

    @Override
    public String getResize() {
        return getPropertyValue("resize").toString();
    }

    @Override
    public StyleAdapter setResize(String resize, boolean important) {
        return setProperty(Style.RESIZE, resize, important);
    }

    @Override
    public StyleAdapter setResize(String resize) {
        return setResize(resize, false);
    }

    @Override
    public Object getRight() {
        return getPropertyValue("right").toString();
    }

    @Override
    public StyleAdapter setRight(Object right, boolean important) {
        return setProperty(Style.RIGHT, right, important);
    }

    @Override
    public StyleAdapter setRight(Object right) {
        return setRight(right, false);
    }

    @Override
    public String getTableLayout() {
        return getPropertyValue("table-layout").toString();
    }

    @Override
    public StyleAdapter setTableLayout(String tableLayout, boolean important) {
        return setProperty(Style.TABLE_LAYOUT, tableLayout, important);
    }

    @Override
    public StyleAdapter setTableLayout(String tableLayout) {
        return setTableLayout(tableLayout, false);
    }

    @Override
    public String getTextAlign() {
        return getPropertyValue("text-align").toString();
    }

    @Override
    public StyleAdapter setTextAlign(String textAlign, boolean important) {
        return setProperty(Style.TEXT_ALIGN, textAlign, important);
    }

    @Override
    public StyleAdapter setTextAlign(String textAlign) {
        return setTextAlign(textAlign, false);
    }

    @Override
    public String getTextDecoration() {
        return getPropertyValue("text-decoration").toString();
    }

    @Override
    public StyleAdapter setTextDecoration(String textDecoration, boolean important) {
        return setProperty(Style.TEXT_DECORATION, textDecoration, important);
    }

    @Override
    public StyleAdapter setTextDecoration(String textDecoration) {
        return setTextDecoration(textDecoration, false);
    }

    @Override
    public String getTextDecorationColor() {
        return getPropertyValue("text-decoration-color").toString();
    }

    @Override
    public StyleAdapter setTextDecorationColor(String textDecorationColor, boolean important) {
        return setProperty(Style.TEXT_DECORATION_COLOR, textDecorationColor, important);
    }

    @Override
    public StyleAdapter setTextDecorationColor(String textDecorationColor) {
        return setTextDecorationColor(textDecorationColor, false);
    }

    @Override
    public String getTextDecorationLine() {
        return getPropertyValue("text-decoration-line").toString();
    }

    @Override
    public StyleAdapter setTextDecorationLine(String textDecorationLine, boolean important) {
        return setProperty(Style.TEXT_DECORATION_LINE, textDecorationLine, important);
    }

    @Override
    public StyleAdapter setTextDecorationLine(String textDecorationLine) {
        return setTextDecorationLine(textDecorationLine, false);
    }

    @Override
    public String getTextDecorationStyle() {
        return getPropertyValue("text-decoration-style").toString();
    }

    @Override
    public StyleAdapter setTextDecorationStyle(String textDecorationStyle, boolean important) {
        return setProperty(Style.TEXT_DECORATION_STYLE, textDecorationStyle, important);
    }

    @Override
    public StyleAdapter setTextDecorationStyle(String textDecorationStyle) {
        return setTextDecorationStyle(textDecorationStyle, false);
    }

    @Override
    public String getTextIndent() {
        return getPropertyValue("text-indent").toString();
    }

    @Override
    public StyleAdapter setTextIndent(String textIndent, boolean important) {
        return setProperty(Style.TEXT_INDENT, textIndent, important);
    }

    @Override
    public StyleAdapter setTextIndent(String textIndent) {
        return setTextIndent(textIndent, false);
    }

    @Override
    public String getTextOverflow() {
        return getPropertyValue("text-overflow").toString();
    }

    @Override
    public StyleAdapter setTextOverflow(String textOverflow, boolean important) {
        return setProperty(Style.TEXT_OVERFLOW, textOverflow, important);
    }

    @Override
    public StyleAdapter setTextOverflow(String textOverflow) {
        return setTextOverflow(textOverflow, false);
    }

    @Override
    public String getTextShadow() {
        return getPropertyValue("text-shadow").toString();
    }

    @Override
    public StyleAdapter setTextShadow(String textShadow, boolean important) {
        return setProperty(Style.TEXT_SHADOW, textShadow, important);
    }

    @Override
    public StyleAdapter setTextShadow(String textShadow) {
        return setTextShadow(textShadow, false);
    }

    @Override
    public String getTextTransform() {
        return getPropertyValue("text-transform").toString();
    }

    @Override
    public StyleAdapter setTextTransform(String textTransform, boolean important) {
        return setProperty(Style.TEXT_TRANSFORM, textTransform, important);
    }

    @Override
    public StyleAdapter setTextTransform(String textTransform) {
        return setTextTransform(textTransform, false);
    }

    @Override
    public Object getTop() {
        return getPropertyValue("top").toString();
    }

    @Override
    public StyleAdapter setTop(Object top, boolean important) {
        return setProperty(Style.TOP, top, important);
    }

    @Override
    public StyleAdapter setTop(Object top) {
        return setTop(top, false);
    }

    @Override
    public String getTransform() {
        return getPropertyValue("transform").toString();
    }

    @Override
    public StyleAdapter setTransform(String transform, boolean important) {
        return setProperty(Style.TRANSFORM, transform, important);
    }

    @Override
    public StyleAdapter setTransform(String transform) {
        return setTransform(transform, false);
    }

    @Override
    public Object getTransformOrigin() {
        return getPropertyValue("transform-origin").toString();
    }

    @Override
    public StyleAdapter setTransformOrigin(Object transformOrigin, boolean important) {
        return setProperty(Style.TRANSFORM_ORIGIN, transformOrigin, important);
    }

    @Override
    public StyleAdapter setTransformOrigin(Object transformOrigin) {
        return setTransformOrigin(transformOrigin, false);
    }

    @Override
    public String getTransformStyle() {
        return getPropertyValue("transform-style").toString();
    }

    @Override
    public StyleAdapter setTransformStyle(String transformStyle, boolean important) {
        return setProperty(Style.TRANSFORM_STYLE, transformStyle, important);
    }

    @Override
    public StyleAdapter setTransformStyle(String transformStyle) {
        return setTransformStyle(transformStyle, false);
    }

    @Override
    public String getTransition() {
        return getPropertyValue("transition").toString();
    }

    @Override
    public StyleAdapter setTransition(String transition, boolean important) {
        return setProperty(Style.TRANSITION, transition, important);
    }

    @Override
    public StyleAdapter setTransition(String transition) {
        return setTransition(transition, false);
    }

    @Override
    public String getTransitionDelay() {
        return getPropertyValue("transition-delay").toString();
    }

    @Override
    public StyleAdapter setTransitionDelay(String transitionDelay, boolean important) {
        return setProperty(Style.TRANSITION_DELAY, transitionDelay, important);
    }

    @Override
    public StyleAdapter setTransitionDelay(String transitionDelay) {
        return setTransitionDelay(transitionDelay, false);
    }

    @Override
    public String getTransitionDuration() {
        return getPropertyValue("transition-duration").toString();
    }

    @Override
    public StyleAdapter setTransitionDuration(String transitionDuration, boolean important) {
        return setProperty(Style.TRANSITION_DURATION, transitionDuration, important);
    }

    @Override
    public StyleAdapter setTransitionDuration(String transitionDuration) {
        return setTransitionDuration(transitionDuration, false);
    }

    @Override
    public String getTransitionProperty() {
        return getPropertyValue("transition-property").toString();
    }

    @Override
    public StyleAdapter setTransitionProperty(String transitionProperty, boolean important) {
        return setProperty(Style.TRANSITION_PROPERTY, transitionProperty, important);
    }

    @Override
    public StyleAdapter setTransitionProperty(String transitionProperty) {
        return setTransitionProperty(transitionProperty, false);
    }

    @Override
    public String getTransitionTimingFunction() {
        return getPropertyValue("transition-timing-function").toString();
    }

    @Override
    public StyleAdapter setTransitionTimingFunction(String transitionTimingFunction, boolean important) {
        return setProperty(Style.TRANSITION_TIMING_FUNCTION, transitionTimingFunction, important);
    }

    @Override
    public StyleAdapter setTransitionTimingFunction(String transitionTimingFunction) {
        return setTransitionTimingFunction(transitionTimingFunction, false);
    }

    @Override
    public String getUnicodeBidi() {
        return getPropertyValue("unicode-bidi").toString();
    }

    @Override
    public StyleAdapter setUnicodeBidi(String unicodeBidi, boolean important) {
        return setProperty(Style.UNICODE_BIDI, unicodeBidi, important);
    }

    @Override
    public StyleAdapter setUnicodeBidi(String unicodeBidi) {
        return setUnicodeBidi(unicodeBidi, false);
    }

    @Override
    public String getUserSelect() {
        return getPropertyValue("user-select").toString();
    }

    @Override
    public StyleAdapter setUserSelect(String userSelect, boolean important) {
        return setProperty(Style.USER_SELECT, userSelect, important);
    }

    @Override
    public StyleAdapter setUserSelect(String userSelect) {
        return setUserSelect(userSelect, false);
    }

    @Override
    public String getVerticalAlign() {
        return getPropertyValue("vertical-align").toString();
    }

    @Override
    public StyleAdapter setVerticalAlign(String verticalAlign, boolean important) {
        return setProperty(Style.VERTICAL_ALIGN, verticalAlign, important);
    }

    @Override
    public StyleAdapter setVerticalAlign(String verticalAlign) {
        return setVerticalAlign(verticalAlign, false);
    }

    @Override
    public String getVisibility() {
        return getPropertyValue("visibility").toString();
    }

    @Override
    public StyleAdapter setVisibility(String visibility, boolean important) {
        return setProperty(Style.VISIBILITY, visibility, important);
    }

    @Override
    public StyleAdapter setVisibility(String visibility) {
        return setVisibility(visibility, false);
    }

    @Override
    public String getWhiteSpace() {
        return getPropertyValue("white-space").toString();
    }

    @Override
    public StyleAdapter setWhiteSpace(String whiteSpace, boolean important) {
        return setProperty(Style.WHITE_SPACE, whiteSpace, important);
    }

    @Override
    public StyleAdapter setWhiteSpace(String whiteSpace) {
        return setWhiteSpace(whiteSpace, false);
    }

    @Override
    public String getWidows() {
        return getPropertyValue("widows").toString();
    }

    @Override
    public StyleAdapter setWidows(String widows, boolean important) {
        return setProperty(Style.WIDOWS, widows, important);
    }

    @Override
    public StyleAdapter setWidows(String widows) {
        return setWidows(widows, false);
    }

    @Override
    public Object getWidth() {
        return getPropertyValue("width").toString();
    }

    @Override
    public StyleAdapter setWidth(Object width, boolean important) {
        return setProperty(Style.WIDTH, width, important);
    }

    @Override
    public StyleAdapter setWidth(Object width) {
        return setWidth(width, false);
    }

    @Override
    public String getWillChange() {
        return getPropertyValue("will-change").toString();
    }

    @Override
    public StyleAdapter setWillChange(String willChange, boolean important) {
        return setProperty(Style.WILL_CHANGE, willChange, important);
    }

    @Override
    public StyleAdapter setWillChange(String willChange) {
        return setWillChange(willChange, false);
    }

    @Override
    public String getWordSpacing() {
        return getPropertyValue("word-spacing").toString();
    }

    @Override
    public StyleAdapter setWordSpacing(String wordSpacing, boolean important) {
        return setProperty(Style.WORD_SPACING, wordSpacing, important);
    }

    @Override
    public StyleAdapter setWordSpacing(String wordSpacing) {
        return setWordSpacing(wordSpacing, false);
    }

    @Override
    public String getWordWrap() {
        return getPropertyValue("word-wrap").toString();
    }

    @Override
    public StyleAdapter setWordWrap(String wordWrap, boolean important) {
        return setProperty(Style.WORD_WRAP, wordWrap, important);
    }

    @Override
    public StyleAdapter setWordWrap(String wordWrap) {
        return setWordWrap(wordWrap, false);
    }

    @Override
    public Object getZIndex() {
        return getPropertyValue("z-index").toString();
    }

    @Override
    public StyleAdapter setZIndex(Object zIndex, boolean important) {
        return setProperty(Style.Z_INDEX, zIndex, important);
    }

    @Override
    public StyleAdapter setZIndex(Object zIndex) {
        return setZIndex(zIndex, false);
    }

    @Override
    public Object getRowGap() {
        return getPropertyValue("row-gap").toString();
    }

    @Override
    public StyleAdapter setRowGap(Object rowGap, boolean important) {
        return setProperty(Style.ROW_GAP, rowGap, important);
    }

    @Override
    public StyleAdapter setRowGap(Object rowGap) {
        return setRowGap(rowGap, false);
    }

    @Override
    public Object getColumnGap() {
        return getPropertyValue("column-gap").toString();
    }

    @Override
    public StyleAdapter setColumnGap(Object columnGap, boolean important) {
        return setProperty(Style.COLUMN_GAP, columnGap, important);
    }

    @Override
    public StyleAdapter setColumnGap(Object columnGap) {
        return setColumnGap(columnGap, false);
    }
}

package dev.reuise.web.frontend.style;
import akasha.CSSGroupingRule;
import akasha.CSSKeyframesRule;
import akasha.CSSMediaRule;
import akasha.CSSRule;
import akasha.CSSRuleList;
import akasha.CSSStyleRule;
import akasha.CSSStyleSheet;
import akasha.Element;
import akasha.HTMLStyleElement;
import akasha.WindowGlobal;
import dev.reuise.core.Interaction;
import dev.reuise.core.MediaQuery;
import dev.reuise.core.State;
import dev.reuise.webstyles.AtRule;
import dev.reuise.webstyles.Style;
import dev.reuise.webstyles.StyleSheet;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
public class WebFrontendStyleSheet implements StyleSheet {
    // Every state (base, each breakpoint, each interaction) of a given component shares a single
    // <style> element so the DOM only ever has one style tag per component, matching the
    // consolidated markup written by the backend. Instances are keyed by the shared element id
    // (the component's unique style class) so the first state to run creates the element and
    // later states for the same component simply reuse it.
    private static final Map<String, HTMLStyleElement> ELEMENTS = new HashMap<>();

    private HTMLStyleElement el;

    private Map<String, Style> rules = new HashMap<>();

    private Map<String, StyleSheet> atRules = new HashMap<>();

    // Set when this instance's <style> element/class is shared with other, unrelated component
    // instances (a hydrated dedup'd class with more than one element wearing it). While shared,
    // any mutating call runs forkCallback first so the owning component can fork onto a private
    // element/class before the mutation actually lands - see DefaultWebFrontendBaseComponentImpl.
    private boolean shared;

    private Runnable forkCallback;

    public void setShared(boolean shared) {
        this.shared = shared;
    }

    public boolean isShared() {
        return shared;
    }

    public void setForkCallback(Runnable forkCallback) {
        this.forkCallback = forkCallback;
    }

    private void forkIfShared() {
        if (shared && (forkCallback != null))
            forkCallback.run();

    }

    // Repoints this per-state instance at a freshly forked element (see
    // DefaultWebFrontendBaseComponentImpl#forkStyle) and re-indexes its rules from that
    // element's own content, since previously indexed rules belonged to the old shared element.
    public void reassignForkedElement(HTMLStyleElement el) {
        this.el = el;
        this.rules.clear();
        this.atRules.clear();
        if ((el.id != null) && (!el.id.isEmpty()))
            ELEMENTS.put(el.id, el);

        indexExistingRules();
    }

    public HTMLStyleElement createOrRehydrate(String id) {
        boolean hasId = (id != null) && (!id.isEmpty());
        if (hasId) {
            el = ELEMENTS.get(id);
            if (el == null)
                el = ((HTMLStyleElement) (WindowGlobal.document().getElementById(id)));

        }
        if (el != null) {
            if (hasId)
                ELEMENTS.put(id, el);

            indexExistingRules();
        } else {
            el = ((HTMLStyleElement) (WindowGlobal.document().createElement("style")));
            el.id = id;
            el.type = "text/css";
            if (hasId)
                ELEMENTS.put(id, el);

        }
        return el;
    }

    // Indexes the rules relevant to this instance's state: top-level rules for the base style
    // and interaction states, or the rules nested inside the matching @media block for a
    // MediaQuery state. This lets multiple states share one element/stylesheet while each
    // WebFrontendStyleSheetImpl instance only sees (and mutates) its own slice of it.
    private void indexExistingRules() {
        CSSStyleSheet sheet = el.sheet();
        if (sheet == null)
            return;

        boolean isMediaState = (getStateQuery() != null) && (!getStateQuery().isEmpty());
        CSSRuleList cssRules = sheet.cssRules();
        for (int r = 0; r < cssRules.length(); r++) {
            CSSRule cssRule = cssRules.item(r);
            if (isMediaState) {
                if (!(cssRule instanceof CSSMediaRule))
                    continue;

                CSSMediaRule mediaRule = ((CSSMediaRule) (cssRule));
                if (!getStateQuery().equals(mediaRule.conditionText))
                    continue;

                CSSRuleList innerRules = mediaRule.cssRules();
                for (int i = 0; i < innerRules.length(); i++) {
                    CSSRule innerRule = innerRules.item(i);
                    if (innerRule instanceof CSSStyleRule) {
                        CSSStyleRule innerStyleRule = ((CSSStyleRule) (innerRule));
                        rules.put(innerStyleRule.selectorText, new StyleAdapter(innerStyleRule.style(), null));
                    } else
                        indexAtRule(innerRule);

                }
            } else if (cssRule instanceof CSSStyleRule) {
                CSSStyleRule cssStyleRule = ((CSSStyleRule) (cssRule));
                rules.put(cssStyleRule.selectorText, new StyleAdapter(cssStyleRule.style(), null));
            } else
                indexAtRule(cssRule);

        }
    }

    private void indexAtRule(CSSRule cssRule) {
        String atRule = getAtRuleName(cssRule);
        if (atRule == null)
            return;

        atRules.put(atRule, new NestedCssRuleStyleSheet(cssRule));
    }

    static String getAtRuleName(CSSRule cssRule) {
        if (cssRule instanceof CSSMediaRule mediaRule)
            return "media " + mediaRule.conditionText;

        if (cssRule instanceof CSSKeyframesRule keyframesRule)
            return "keyframes " + keyframesRule.name;

        if ((cssRule.cssText != null) && cssRule.cssText.startsWith("@")) {
            int index = cssRule.cssText.indexOf('{');
            if (index > 1)
                return cssRule.cssText.substring(1, index).trim();

        }
        return null;
    }

    public void insertBefore(Element before) {
        if (el.isConnected())
            return;

        if ((before != null) && before.isConnected()) {
            Element parentEl = before.parentElement();
            if ((parentEl != null) && parentEl.isConnected())
                parentEl.insertBefore(el, before);

            return;
        }
        appendToHead();
    }

    public void appendToHead() {
        if (el.isConnected())
            return;

        WindowGlobal.document().head().appendChild(el);
    }

    public void setElement(HTMLStyleElement el) {
        this.el = el;
    }

    public HTMLStyleElement getElement() {
        return el;
    }

    public Style getRule(String rule, State state) {
        if (state instanceof Interaction interactionState) {
            return rules.get(interactionState.getSelector(rule));
        }
        return rules.get(rule);
    }

    // Finds the existing top-level CSSStyleRule for the base/interaction states, or the
    // CSSStyleRule nested inside this instance's matching @media block for a MediaQuery state.
    private CSSStyleRule getCssRule(String rule) {
        CSSStyleSheet sheet = el.sheet();
        if (sheet == null)
            return null;

        boolean isMediaState = (getStateQuery() != null) && (!getStateQuery().isEmpty());
        CSSRuleList cssRules = sheet.cssRules();
        for (int r = 0; r < cssRules.length(); r++) {
            CSSRule cssRule = cssRules.item(r);
            if (isMediaState) {
                if (!(cssRule instanceof CSSMediaRule))
                    continue;

                CSSMediaRule mediaRule = ((CSSMediaRule) (cssRule));
                if (!getStateQuery().equals(mediaRule.conditionText))
                    continue;

                CSSRuleList innerRules = mediaRule.cssRules();
                for (int i = 0; i < innerRules.length(); i++) {
                    CSSRule innerRule = innerRules.item(i);
                    if (innerRule instanceof CSSStyleRule) {
                        CSSStyleRule innerStyleRule = ((CSSStyleRule) (innerRule));
                        if (innerStyleRule.selectorText.equals(rule))
                            return innerStyleRule;

                    }
                }
            } else if (cssRule instanceof CSSStyleRule) {
                CSSStyleRule cssStyleRule = ((CSSStyleRule) (cssRule));
                if (cssStyleRule.selectorText.equals(rule))
                    return cssStyleRule;

            }
        }
        return null;
    }

    // Finds the @media block matching this instance's query, creating one at the end of the
    // sheet if it doesn't exist yet.
    private CSSMediaRule findOrCreateMediaRule(CSSStyleSheet sheet) {
        CSSRuleList cssRules = sheet.cssRules();
        for (int r = 0; r < cssRules.length(); r++) {
            CSSRule cssRule = cssRules.item(r);
            if (cssRule instanceof CSSMediaRule) {
                CSSMediaRule mediaRule = ((CSSMediaRule) (cssRule));
                if (getStateQuery().equals(mediaRule.conditionText))
                    return mediaRule;

            }
        }
        int index = sheet.insertRule(("@media " + getStateQuery()) + "{}");
        return ((CSSMediaRule) (sheet.cssRules().item(index)));
    }

    public WebFrontendStyleSheet(State state) {
        if (state != null) {
            stateKey = state.getStateKey();
            if (state instanceof MediaQuery)
                stateQuery = ((MediaQuery) (state)).getQuery();

        }
    }

    private String stateKey = "";

    private String stateQuery = "";

    public Map<String, Style> getRules() {
        return null;
    }

    public Map<String, StyleSheet> getAtRules() {
        return null;
    }

    public String getStateQuery() {
        return stateQuery;
    }

    public WebFrontendStyleSheet() {
    }

    // Implementation
    @Override
    public Style addRule(String rule, State state) {
        forkIfShared();
        String selector = null;
        if (state instanceof Interaction interactionState) {
            selector = interactionState.getSelector(rule);
        } else
            selector = rule;

        Style existing = getRule(selector, state);
        if (existing != null)
            return existing;

        CSSStyleSheet sheet = el.sheet();
        if (sheet == null)
            return null;

        CSSStyleRule cssRule;
        boolean isMediaState = (getStateQuery() != null) && (!getStateQuery().isEmpty());
        if (isMediaState) {
            CSSMediaRule mediaRule = findOrCreateMediaRule(sheet);
            int index = mediaRule.insertRule(selector + "{}");
            cssRule = ((CSSStyleRule) (mediaRule.cssRules().item(index)));
        } else {
            int index = sheet.insertRule(selector + "{}");
            cssRule = ((CSSStyleRule) (sheet.cssRules().item(index)));
        }
        Style style = new StyleAdapter(cssRule.style(), null);
        rules.put(selector, style);
        return style;
    }

    @Override
    public Style addRule(String rule) {
        return addRule(rule, null);
    }

    // Implementation
    @Override
    public StyleSheet addAtRule(String atRule, State state) {
        atRule = AtRule.normalize(Objects.requireNonNull(atRule, "atRule"));
        forkIfShared();
        String selector = null;
        if (state instanceof Interaction interactionState) {
            selector = interactionState.getSelector(atRule);
        } else
            selector = atRule;

        StyleSheet existing = atRules.get(selector);
        if (existing != null)
            return existing;

        CSSStyleSheet sheet = el.sheet();
        if (sheet == null)
            return null;

        CSSRule cssRule;
        boolean isMediaState = (getStateQuery() != null) && (!getStateQuery().isEmpty());
        if (isMediaState) {
            CSSGroupingRule mediaRule = findOrCreateMediaRule(sheet);
            int index = mediaRule.insertRule(("@" + selector) + "{}", mediaRule.cssRules().length());
            cssRule = mediaRule.cssRules().item(index);
        } else {
            int index = sheet.insertRule(("@" + selector) + "{}");
            cssRule = sheet.cssRules().item(index);
        }
        if ((cssRule instanceof CSSGroupingRule) || (cssRule instanceof CSSKeyframesRule)) {
            StyleSheet styleSheet = new NestedCssRuleStyleSheet(cssRule);
            atRules.put(selector, styleSheet);
            return styleSheet;
        }
        return null;
    }

    @Override
    public StyleSheet addAtRule(String atRule) {
        return addAtRule(atRule, null);
    }

    @Override
    public String getStateKey() {
        return stateKey;
    }

    // Implementation
    public Style getRule(String rule) {
        return rules.get(rule);
    }

    // Implementation
    @Override
    public void setRule(String rule, Style style) {
        forkIfShared();
        Style existing = getRule(rule);
        if (existing == null)
            addRule(rule);

        CSSStyleRule cssRule = getCssRule(rule);
        if (cssRule == null)
            return;

        rules.put(rule, new StyleAdapter(cssRule.style(), style));
    }

    // Implementation
    public StyleSheet getAtRule(String atRule) {
        return atRules.get(AtRule.normalize(atRule));
    }

    // Implementation
    @Override
    public void setAtRule(String atRule, StyleSheet styleSheet) {
        atRule = AtRule.normalize(atRule);
        if ((atRule == null) || (styleSheet == null))
            return;

        atRules.put(atRule, styleSheet);
    }

    // Implementation
    @Override
    public void appendRule(String rule, Style style) {
        if (rule == null)
            return;

        if ((style == null) || (!style.hasProperties()))
            return;

        forkIfShared();
        Style existingStyle = getRule(rule);
        if (existingStyle != null)
            existingStyle.append(style);
        else
            setRule(rule, style);

    }

    // Implementation
    @Override
    public String getCssText() {
        return el.sheet().toString_();
    }
}

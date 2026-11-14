package dev.reuise.web.frontend.style;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import akasha.CSSGroupingRule;
import akasha.CSSKeyframeRule;
import akasha.CSSKeyframesRule;
import akasha.CSSRule;
import akasha.CSSRuleList;
import akasha.CSSStyleRule;
import dev.reuise.core.Interaction;
import dev.reuise.core.State;
import dev.reuise.webstyles.Style;
import dev.reuise.webstyles.StyleSheet;
import dev.reuise.webstyles.AtRule;

// A nested at-rule (@keyframes, or a grouping rule such as @media/@supports) exposed as its
// own StyleSheet so callers can addRule("0%") / addRule(".x") against the live CSSOM rule.
public final class NestedCssRuleStyleSheet implements StyleSheet {
    private final CSSRule cssRule;
    private final CSSGroupingRule groupingRule;
    private final CSSKeyframesRule keyframesRule;
    private final Map<String, Style> rules = new HashMap<>();
    private final Map<String, StyleSheet> atRules = new HashMap<>();

    public NestedCssRuleStyleSheet(CSSRule cssRule) {
        this.cssRule = cssRule;
        this.groupingRule = cssRule instanceof CSSGroupingRule ? (CSSGroupingRule) cssRule : null;
        this.keyframesRule = cssRule instanceof CSSKeyframesRule ? (CSSKeyframesRule) cssRule : null;
        indexExistingRules();
    }

    private void indexExistingRules() {
        rules.clear();
        atRules.clear();
        if(keyframesRule != null) {
            CSSRuleList cssRules = keyframesRule.cssRules();
            for(int i = 0; i < cssRules.length(); i++) {
                CSSRule innerRule = cssRules.item(i);
                if(innerRule instanceof CSSKeyframeRule keyframeRule) {
                    rules.put(keyframeRule.keyText, new StyleAdapter(keyframeRule.style(), null));
                }
            }
            return;
        }
        if(groupingRule == null) return;

        CSSRuleList cssRules = groupingRule.cssRules();
        for(int i = 0; i < cssRules.length(); i++) {
            CSSRule innerRule = cssRules.item(i);
            if(innerRule instanceof CSSStyleRule cssStyleRule) {
                rules.put(cssStyleRule.selectorText, new StyleAdapter(cssStyleRule.style(), null));
            }
            else {
                String atRule = WebFrontendStyleSheet.getAtRuleName(innerRule);
                if(atRule != null) atRules.put(atRule, new NestedCssRuleStyleSheet(innerRule));
            }
        }
    }

    @Override
    public Style getRule(String rule) {
        return rules.get(rule);
    }

    @Override
    public StyleSheet getAtRule(String atRule) {
        return atRules.get(AtRule.normalize(atRule));
    }

    @Override
    public void setRule(String rule, Style style) {
        if(rule == null || style == null) return;

        if(getRule(rule) == null) addRule(rule);

        if(keyframesRule != null) {
            CSSKeyframeRule cssKeyframeRule = keyframesRule.findRule(rule);
            if(cssKeyframeRule == null) return;
            rules.put(rule, new StyleAdapter(cssKeyframeRule.style(), style));
            return;
        }
        if(groupingRule == null) return;

        CSSRuleList cssRules = groupingRule.cssRules();
        for(int i = 0; i < cssRules.length(); i++) {
            CSSRule innerRule = cssRules.item(i);
            if(innerRule instanceof CSSStyleRule cssStyleRule && cssStyleRule.selectorText.equals(rule)) {
                rules.put(rule, new StyleAdapter(cssStyleRule.style(), style));
                return;
            }
        }
    }

    @Override
    public void setAtRule(String atRule, StyleSheet styleSheet) {
        atRule = AtRule.normalize(atRule);
        if(atRule == null || styleSheet == null) return;
        atRules.put(atRule, styleSheet);
    }

    @Override
    public void appendRule(String rule, Style style) {
        if(rule == null) return;
        if(style == null || !style.hasProperties()) return;

        Style existing = getRule(rule);
        if(existing != null) existing.append(style);
        else setRule(rule, style);
    }

    @Override
    public Map<String, Style> getRules() {
        return rules;
    }

    @Override
    public Map<String, StyleSheet> getAtRules() {
        return atRules;
    }

    @Override
    public String getStateQuery() {
        return "";
    }

    @Override
    public Style addRule(String rule, State state) {
        String selector = null;
        if(state instanceof Interaction interactionState) {
            selector = interactionState.getSelector(rule);
        }
        else selector = rule;

        Style existing = rules.get(selector);
        if(existing != null) return existing;

        if(keyframesRule != null) {
            keyframesRule.appendRule(selector+"{}");
            CSSKeyframeRule cssKeyframeRule = keyframesRule.findRule(selector);
            if(cssKeyframeRule == null) return null;

            Style style = new StyleAdapter(cssKeyframeRule.style(), null);
            rules.put(selector, style);
            return style;
        }
        if(groupingRule == null) return null;

        int index = groupingRule.insertRule(selector+"{}", groupingRule.cssRules().length());
        CSSRule innerRule = groupingRule.cssRules().item(index);
        if(!(innerRule instanceof CSSStyleRule cssStyleRule)) return null;

        Style style = new StyleAdapter(cssStyleRule.style(), null);
        rules.put(selector, style);
        return style;
    }

    @Override
    public Style addRule(String rule) {
        return addRule(rule, null);
    }

    @Override
    public StyleSheet addAtRule(String atRule, State state) {
        atRule = AtRule.normalize(Objects.requireNonNull(atRule, "atRule"));
        if(keyframesRule != null) return null;

        String selector = null;
        if(state instanceof Interaction interactionState) {
            selector = interactionState.getSelector(atRule);
        }
        else selector = atRule;

        StyleSheet existing = atRules.get(selector);
        if(existing != null) return existing;
        if(groupingRule == null) return null;

        int index = groupingRule.insertRule("@"+selector+"{}", groupingRule.cssRules().length());
        CSSRule innerRule = groupingRule.cssRules().item(index);
        if(!(innerRule instanceof CSSGroupingRule || innerRule instanceof CSSKeyframesRule)) return null;

        StyleSheet styleSheet = new NestedCssRuleStyleSheet(innerRule);
        atRules.put(selector, styleSheet);
        return styleSheet;
    }

    @Override
    public StyleSheet addAtRule(String atRule) {
        return addAtRule(atRule, null);
    }

    @Override
    public String getStateKey() {
        return "";
    }

    @Override
    public String getCssText() {
        return cssRule.cssText;
    }
}

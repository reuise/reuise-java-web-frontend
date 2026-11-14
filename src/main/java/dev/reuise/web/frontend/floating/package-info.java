/**
 * Application-neutral floating UI.
 *
 * <p>Create FloatingActionButton/FloatingPanel with the generated factories.
 * The FAB is a native button: configure its inherited StartIcon options, optional
 * Label (default Help; null for icon-only) and non-empty AccessibleLabel. Native
 * Enter/Space and Tab work without custom key emulation. Never assign a URL or
 * change the button tag. UnreadCount hides at zero and displays 99+ above 99;
 * the badge is referenced as an accessible description, not a live announcement.
 * Applications own translated labels, unread data, services, auth and actions.
 *
 * <p>FloatingPanel owns its Trigger, Panel, Header, TitleContainer, CloseButton,
 * MinimiseButton and Content slots. Add arbitrary native components through
 * getContent().add(...). Trigger options expose FAB icon, label and badge.
 * Expanded defaults false; open/toggle reveal a non-modal dialog. Minimise
 * hides without destroying content and records Minimised; close clears that
 * flag; open clears it too. Both dismissal actions preserve application content.
 * Docked defaults false and docks to a desktop side when enabled.
 *
 * <p>Opening an attached panel focuses its dialog container. Escape from the
 * panel closes it unless a descendant has already consumed the event. Close or
 * minimise restores the previous focus (falling back to the trigger) only when
 * focus was inside. Focus is never trapped and outside clicks do not dismiss.
 * Open after adding a client-created component to the document. Hydration of
 * already-open markup never steals focus. Data attributes serialize options;
 * generated layout IDs and ARIA relationships survive hydration. Supply the
 * same child options/content and application handlers when hydrating. No portal,
 * service, storage, route, auth or global keyboard handling is installed.
 *
 * <p>Corner accepts top-left/top-right/bottom-left/bottom-right (default and
 * invalid/null fallback bottom-right). CSS handles mobile sheets at 600px and
 * below, safe-area insets, dynamic viewport height and scrollable content.
 * Custom properties configure --reuise-floating-offset (16px),
 * --reuise-floating-panel-offset (80px), --reuise-floating-width (380px),
 * --reuise-floating-height (520px), --reuise-floating-sheet-height (70dvh),
 * --reuise-floating-z-index (1000), --reuise-floating-background/color and
 * --reuise-floating-badge-background/color. Instance styles remain available.
 * No transitions or animation are introduced. This in-place fixed-position UI
 * cannot escape transformed/paint-contained/clipping ancestors or their stacking
 * contexts: mount in a non-clipping document-level container. Dynamic viewport
 * units depend on browser support and do not guarantee virtual-keyboard avoidance
 * in overlay-keyboard configurations.
 *
 * <p>Call dispose before permanently discarding a panel (especially if never
 * attached). Observed removal of a previously attached panel also disposes it.
 * Disposal closes and releases scoped click/key listeners and its removal
 * observer; instances remain independent. Do not reuse a disposed panel.
 */
package dev.reuise.web.frontend.floating;

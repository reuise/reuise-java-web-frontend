/**
 * Accessible menu buttons shared by account, language and overflow controls.
 *
 * <p>Create a MenuButton with the generated factory. Set its Label to a useful
 * accessible name, and add popup content through {@code getPopup().add(...)}.
 * The generated Trigger is a native button: do not give it a URL or replace
 * its button tag. Icons can be supplied through the Trigger's existing icon
 * options without changing the accessible label.
 * The optional chevron uses a six-pixel, current-color border shape with a
 * 12-pixel logical start gap and a 160ms translated rotation when expanded.
 *
 * <p>The default {@code ActionMenu=false} is a disclosure: use ordinary links
 * for navigation and ordinary buttons for other disclosure content. It retains
 * native Tab order and does not claim an ARIA menu role or intercept arrow keys.
 * For an application action menu, set {@code ActionMenu=true} and populate the
 * popup with generated MenuButtonItem buttons (Label, Enabled and CLICK handlers
 * use the existing Button API). These render role=menuitem and tabindex=-1.
 * Use native buttons without URLs; do not put form fields or unrelated tabbable
 * content in an action menu. Mixed navigation/actions should use disclosure mode.
 *
 * <p>Action menus focus the first enabled, visible item on opening. ArrowUp on
 * the trigger opens at the last item; arrows wrap, Home/End reach the boundaries,
 * and printable characters perform label typeahead. Native Enter/Space activate
 * buttons. Escape and action activation return focus to the trigger. Tab exits
 * without trapping focus. Pointer dismissal and moving focus outside do not
 * steal focus. Repeat-clicking the trigger closes either mode.
 *
 * <p>Expanded, ActionMenu and Label are serialized for hydration, along with
 * stable trigger/popup IDs and ARIA relationships. Create matching client-side
 * popup children and handlers when hydrating. Existing DOM nodes are reused;
 * neither the popup nor its children are portalled or rebuilt. An expanded
 * hydrated action menu receives initial item focus. For client-only creation,
 * normally add the component to the document before calling open().
 *
 * <p>The popup aligns with the trigger's right edge, shifts horizontally inside
 * the viewport's eight-pixel gutter, and flips above the trigger when there is
 * more room there. Oversized content is constrained and scrollable. Window and
 * ancestor scrolling, window/visual-viewport resizing, and trigger/popup size
 * changes reposition it without recreating nodes or changing focus. Positioning
 * is animation-frame coalesced, preserves popup scrolling, and keeps its focused
 * item vertically in view after resizing. Owned inline properties (including
 * priorities) are restored on close.
 *
 * <p>Document/viewport listeners, size/removal observers and pending positioning
 * frames exist only while expanded, and are released on close or observed removal.
 * Call {@code dispose()} before
 * permanently discarding a component, especially one opened while detached.
 * Disposed components are no longer interactive. Closing/removing one instance
 * does not remove another instance's listeners.
 *
 * <p>The legacy Menu remains available for its existing positioned-list API.
 * Its portal, list-item semantics and independent dismissal controller are not
 * used here: combining them would introduce competing focus/dismissal owners.
 * This component uses an in-place, absolutely positioned popup instead. It cannot
 * escape clipping ancestors (overflow, clip-path or paint containment), or an
 * ancestor's stacking context. Viewport collision handling does not fix those
 * layout constraints; use it in a non-clipping container. Axis-aligned scale
 * transforms are accounted for; rotated/skewed/perspective containing blocks are
 * not supported. A portal/top-layer design would require a separate ownership,
 * event, styling and hydration contract and is intentionally not introduced here.
 */
package dev.reuise.web.frontend.menu;

/**
 * Responsive carousels for arbitrary component content, not only images.
 *
 * <p>Create a Carousel through the component factory, add CarouselCard components with
 * {@code carousel.add(card)}, and add any content to each card. Cards fill the viewport by
 * default. {@code card.setAutoSize(true)} instead uses the card's content width; explicit
 * width/min-width/max-width styles may constrain it. Full-width and differently sized
 * cards may be mixed without cloning their content.
 *
 * <p>GroupSize defaults to null: measured cards that fit the viewport form a page.
 * A positive GroupSize uses a fixed card count. ActiveIndex is a zero-based page index,
 * not a card index. Gap is in CSS pixels. Align accepts start, center or end; Whitespace
 * permits blank space at the edges to retain that alignment. Without Whitespace, offsets
 * are clamped to the content bounds. Circular wraps navigation; it is not an infinitely
 * cloned belt. Resize and content changes remeasure pages and clamp ActiveIndex.
 *
 * <p>Previous/next buttons, indicators, viewport arrow/Home/End keys and optional pointer
 * dragging navigate pages. Embedded controls keep their normal keyboard behavior.
 * Offscreen cards are inert and hidden from assistive technology while enhanced.
 * Label, PreviousLabel, NextLabel, PlayLabel, PauseLabel and PageLabel are customizable;
 * PageLabel accepts one-based {index} and {count} placeholders.
 *
 * <p>Autoplay is opt-in, with a default interval of 4000 ms. Hover, hidden/offscreen
 * content, detachment and reduced-motion preferences suspend it. Focus pauses it until
 * explicitly restarted with play(); pause() stops it. Reduced motion also disables
 * transitions. OnActiveIndexChange receives the new target page index.
 *
 * <p>Server rendering remains a native horizontally scrollable content strip with
 * enhancement controls hidden. Hydrate explicitly using CarouselOptions.setRehydration
 * with the server-rendered root; cards and content nodes are retained. Before browser
 * measurement, core/server navigation treats auto grouping as one card per page.
 * Detached instances suspend document resources and reacquire them on attachment.
 * dispose() permanently releases the controller and restores native scrolling.
 */
package dev.reuise.web.frontend.carousel;

/**
 * Rotating text slides and fades between phrases while its item container
 * transitions to the active phrase's width using {@code TransitionMillis}.
 * Width remains constrained by the available space, allowing long phrases to
 * wrap. Pausing or requesting reduced motion settles the width immediately.
 * Before client initialization, SSR markup reserves space for all phrases.
 */
package dev.reuise.web.frontend.text;

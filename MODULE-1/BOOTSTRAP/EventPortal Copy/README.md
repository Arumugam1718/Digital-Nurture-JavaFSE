# Local Community Event Portal

A fully responsive, browser-based community event portal built using HTML5, Vanilla CSS3, and vanilla JavaScript (ES6+).

## Project Overview
This portal allows local residents to:
- Browse upcoming community events.
- Register for specific events with dynamic fee calculations.
- View an event gallery with double-click zoom functionality.
- Discover nearby events using HTML5 Geolocation.
- Save filter preferences using LocalStorage and SessionStorage.

## Technologies Used
- **HTML5**: Semantic structure, specialized inputs, native validation, and multimedia (video).
- **CSS3 (Vanilla)**: Custom styling variables, custom smooth transitions, flexbox and CSS Grid layout systems (no heavy frameworks).
- **JavaScript (ES6+)**: DOM manipulation, asynchronous data fetching (fetch API), Event handling, Object-Oriented patterns, Array methods, error handling, and jQuery integration.

## Setup Instructions
1. Clone or download the repository.
2. Ensure you have an active internet connection (requires CDNs for FontAwesome and jQuery).
3. Open `index.html` in any modern web browser.
4. No build steps or server required for basic viewing (though a local server like Live Server is recommended for Fetch API behavior without CORS issues in some browsers).

## Features Implemented per Requirements

### HTML5
- Semantic tags (`<nav>`, `<section>`, `<main>`, `<footer>`, `<figure>`, `<figcaption>`).
- `<video>` integration with `oncanplay` event.
- Form inputs with `required`, `placeholder`, `autofocus`, and `pattern`.
- Native browser storages (`localStorage`, `sessionStorage`).
- HTML5 Geolocation API integration.
- `<output>` tag for registration confirmation.
- JavaScript event triggers (`onblur`, `onchange`, `onclick`, `ondblclick`, `keydown/keyup`, `onbeforeunload`).

### CSS3
- Internal, Inline, and External CSS utilization.
- Complex Selectors (ID, Class, Grouped, Descendant).
- Box model mastery (margins, padding, border, outlines).
- Multi-column layout for Community News section.
- Responsive design via Media Queries.
- Flexbox and Grid display properties.

### Custom Vanilla UI
- Fully responsive architecture without external framework dependencies.
- Native HTML `<details>` and `<summary>` replacing traditional JS accordions.
- Custom CSS Modal logic seamlessly toggled via Vanilla JavaScript.
- Custom form styling and error states built natively.
- FontAwesome Icons implementation.

### JavaScript ES6+
- Async/Await & Promises (`fetch` API) for mock data retrieval.
- Class and Prototype definitions (`Event` class).
- Array manipulations (`filter`, `map`, `forEach`, `push`).
- Form validations and DOM node creations.
- Closure implementations for registration counting.
- jQuery utilization for simple animations (`fadeIn`).

## Author
Senior Frontend Architect, UI/UX Engineer

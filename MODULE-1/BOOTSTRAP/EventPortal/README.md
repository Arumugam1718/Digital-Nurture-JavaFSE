# Responsive Community Event Portal

This is a modern, responsive web application designed for browsing, filtering, and registering for local community events. It is built using clean, semantic HTML5, custom CSS3 styles, and modern ES6+ JavaScript.

## Features & Implementation Overview
This portal implements various client-side web technologies to deliver an interactive interface:

### HTML5 Layout and Features
- **Semantic Structure**: Organizes content using `<nav>`, `<main>`, `<aside>`, `<section>`, `<figure>`, `<figcaption>`, and `<footer>`.
- **Specialized Inputs & Validations**: Utilizes specialized inputs such as `type="email"`, `type="tel"`, and `type="date"` combined with attributes like `required`, `placeholder`, and `autofocus` for enhanced forms.
- **Embedded Media**: Integrates `<video>` with custom state tracking via the `oncanplay` event.
- **Confirmations**: Displays dynamically rendered receipts using the native `<output>` tag.
- **Geolocation API**: Detects device coordinates using high accuracy parameters to suggest local happenings.
- **Client Storage**: Saves category filter preferences in `localStorage` and form state in `sessionStorage`.

### Vanilla CSS3 Styles
- **Modular Stylesheets**: Uses internal, inline, and external styling declarations.
- **Dynamic Grid & Flexbox**: Constructs dynamic gallery grids and flex layouts without relying on framework systems.
- **Media Queries**: Tailors layouts to fit mobile screens and varying viewports.
- **Advanced Selectors**: Employs descendant, grouping, pseudo-elements, variables, and transition settings.

### JavaScript Core (ES6+)
- **OOP Structure**: Defines class prototypes and constructors to model event entities.
- **Array Operations**: Employs array methods (`map`, `filter`, `forEach`, `push`) to load, list, search, and parse event categories.
- **Asynchronous Execution**: Leverages `async/await` and the `fetch` API to load mock data from a server endpoint.
- **Form Interactivity**: Attaches listener callbacks for form inputs (`onchange`, `onblur`, `keydown`/`keyup`) to render calculated values, check string formats, and update character counters.
- **State Integrity**: Warns users of unsubmitted inputs before page unload.
- **Private State Tracking**: Implements closure modules to record registration statistics privately.
- **Library Integration**: Applies jQuery for smooth fade-in visual feedback.

## Project Structure
```text
EventPortal/
├── assets/
│   └── images/      # Event posters and visuals
├── index.html       # Primary application landing page
├── styles.css       # Core design stylesheet
├── main.js          # JavaScript controller logic
├── help.html        # Help page documentation
└── README.md        # Technical guidelines (this file)
```

## Running the Project
1. Download the files to your local environment.
2. Verify you have internet access to fetch resources like FontAwesome and jQuery CDN scripts.
3. Open `index.html` inside any modern web browser.

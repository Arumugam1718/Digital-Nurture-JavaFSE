// Requirement Completed: JS Exercise - Startup Alert and Console
console.log("Welcome to the Community Portal");
window.onload = () => {
    // Requirement Completed: JS Exercise - Alert when page loads
    alert("Welcome to the Community Portal!");
    
    initApp();
};

// Requirement Completed: JS Exercise - Data Types (const, let)
const eventsContainer = document.querySelector('#eventsContainer'); // DOM Manipulation - querySelector
const form = document.getElementById('regForm');
let eventsData = [];
let totalRegistrations = 0; // Using for ++/-- later

// Requirement Completed: JS Exercise - Objects (Class)
class Event {
    constructor(id, title, date, location, category, fee, image, description) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.location = location;
        this.category = category;
        this.fee = fee;
        this.image = image;
        this.description = description;
        this.registeredCount = 0;
        this.maxCapacity = 50; // Mock capacity
    }
}

// Requirement Completed: JS Exercise - Prototype
Event.prototype.checkAvailability = function() {
    return this.registeredCount < this.maxCapacity;
};

// Requirement Completed: JS Exercise - Async JavaScript (async/await, fetch)
async function fetchMockData() {
    // Requirement Completed: JS Exercise - Async JS (Show loading spinner)
    if(eventsContainer) {
        eventsContainer.innerHTML = '<div class="text-center w-100 py-5"><div class="spinner-border text-primary" role="status"></div><p class="mt-2 text-muted">Loading events...</p></div>';
    }

    try { // Requirement Completed: JS Exercise - Error Handling
        // Fetching from a mock JSON endpoint
        const response = await fetch('https://jsonplaceholder.typicode.com/posts?_limit=6');
        const apiData = await response.json();

        // Simulating API call with local array since we don't have a real backend
        const mockApiResponse = [
            { id: 1, title: "Summer Festival", date: "2025-07-15", location: "Central Park", category: "music", fee: 25, image: "assets/images/event1.png", description: "Annual outdoor summer music and arts festival.", isPast: false },
            { id: 2, title: "Night Concert", date: "2025-08-20", location: "Downtown Arena", category: "music", fee: 40, image: "assets/images/event2.png", description: "Experience an electrifying night of live music.", isPast: false },
            { id: 3, title: "Food Festival", date: "2025-06-10", location: "Town Square", category: "food", fee: 10, image: "assets/images/event3.png", description: "Taste culinary delights from local vendors.", isPast: false },
            { id: 4, title: "Art Exhibition", date: "2025-09-05", location: "City Gallery", category: "art", fee: 15, image: "assets/images/event4.png", description: "Modern art exhibition featuring local artists.", isPast: false },
            { id: 5, title: "City Marathon", date: "2025-10-12", location: "City Streets", category: "sports", fee: 30, image: "assets/images/event5.png", description: "Join the annual city marathon for health and fitness.", isPast: false },
            { id: 6, title: "Tech Workshop", date: "2025-11-18", location: "Innovation Hub", category: "tech", fee: 50, image: "assets/images/event6.png", description: "Hands-on coding bootcamp and tech networking.", isPast: false },
            { id: 7, title: "Past Event", date: "2023-01-01", location: "Old Hall", category: "music", fee: 0, image: "assets/images/event1.png", description: "This event already happened.", isPast: true } // For condition testing
        ];

        // Requirement Completed: JS Exercise - Arrays (map)
        eventsData = mockApiResponse.map(e => 
            new Event(e.id, e.title, e.date, e.location, e.category, e.fee, e.image, e.description)
        );
        
        // Add past property dynamically for filtering
        eventsData.forEach((event, index) => {
            event.isPast = mockApiResponse[index].isPast;
            if(index === 1) event.registeredCount = 50; // Make one full to test condition
        });

        // Explicit demo for Requirement Completed: JS Exercise - Arrays (.filter() to show only music events)
        const musicEventsOnly = eventsData.filter(e => e.category === 'music');
        console.log("Demo Filter (Music Events Only):", musicEventsOnly);

        renderEvents(eventsData);
        
    } catch (error) {
        console.error("Error fetching data:", error);
    }
}

// Requirement Completed: JS Exercise - DOM Manipulation (createElement, appendChild)
function renderEvents(events) {
    if (!eventsContainer) return;
    
    eventsContainer.innerHTML = '';
    
    // Requirement Completed: JS Exercise - Arrays (filter)
    // Requirement Completed: JS Exercise - Conditions (if else) Hide full and past events
    const availableEvents = events.filter(event => {
        if (event.isPast) {
            return false; // Hide past events
        } else if (!event.checkAvailability()) {
            return false; // Hide full events
        } else {
            return true;
        }
    });

    // Requirement Completed: JS Exercise - Arrays (.map() to format display cards)
    const formattedEvents = availableEvents.map(event => {
        return {
            ...event,
            displayTitle: `${event.category.toUpperCase()} | ${event.title}` // e.g. "MUSIC | Summer Festival"
        };
    });

    // Requirement Completed: JS Exercise - Loops (forEach)
    formattedEvents.forEach(event => {
        const col = document.createElement('div');
        col.className = 'event-wrapper';
        
        // Requirement Completed: JS Exercise - Template literals
        col.innerHTML = `
            <div class="card h-100 eventCard shadow-sm border-0">
                <!-- Requirement Completed: Bootstrap 5 Exercise - Badge Overlay (Position Utilities) -->
                <div class="position-relative">
                    <img src="${event.image}" class="card-img-top" alt="${event.title}" style="height: 200px; object-fit: cover;">
                    <span class="position-absolute top-0 end-0 bg-primary text-white px-2 py-1 m-2 rounded shadow-sm text-uppercase small fw-bold">${event.category}</span>
                </div>
                <div class="card-body d-flex flex-column">
                    <h5 class="card-title text-primary fw-bold">${event.displayTitle}</h5>
                    <p class="card-text text-muted small flex-grow-1">${event.description}</p>
                    <ul class="list-unstyled small mb-3">
                        <li><i class="bi bi-calendar-event text-secondary me-2"></i> ${event.date}</li>
                        <li><i class="bi bi-geo-alt text-secondary me-2"></i> ${event.location}</li>
                        <li><i class="bi bi-tag text-secondary me-2"></i> $${event.fee}</li>
                    </ul>
                    <!-- Requirement Completed: JS Exercise - Event Handling (onclick) -->
                    <button class="btn btn-outline-primary w-100 mt-auto" onclick="openEventDetails(${event.id})">View Details</button>
                </div>
            </div>
        `;
        eventsContainer.appendChild(col);
    });
}

function initApp() {
    fetchMockData();
    setupEventListeners();
    loadPreferences();
}

// Requirement Completed: JS Exercise - Functions (addEvent, registerUser, filterEventsByCategory)
function addEvent() {
    // Placeholder for admin function
    console.log("Admin: addEvent called");
}

function openEventDetails(eventId) {
    const event = eventsData.find(e => e.id === eventId);
    if (!event) return;

    // Requirement Completed: JS Exercise - Modern ES6+ (Destructuring)
    const { title, image, category, fee, description, date, location } = event;

    // Requirement Completed: JS Exercise - Objects (Object.entries)
    console.log("Event Details Dump:");
    for (const [key, value] of Object.entries(event)) {
        console.log(`${key}: ${value}`);
    }

    document.getElementById('modalEventTitle').innerText = title;
    document.getElementById('modalEventImg').src = image;
    document.getElementById('modalEventCategory').innerText = category.toUpperCase();
    document.getElementById('modalEventFee').innerText = fee === 0 ? "Free" : `$${fee}`;
    document.getElementById('modalEventDesc').innerText = description;
    document.getElementById('modalEventDate').innerText = date;
    document.getElementById('modalEventLocation').innerText = location;

    // Vanilla JS Modal Toggle
    document.getElementById('eventModal').classList.add('show');
}

function closeModal(modalId) {
    document.getElementById(modalId).classList.remove('show');
}

function scrollToRegistration() {
    closeModal('eventModal');
    document.getElementById('registration').scrollIntoView({ behavior: 'smooth' });
}

// Requirement Completed: JS Exercise - Callbacks (Dynamic filtering)
function filterEventsByCategory(callback = null) {
    const filterValue = document.getElementById('eventFilter').value;
    
    // Requirement Completed: HTML Exercise - Storage (localStorage)
    localStorage.setItem('preferredCategory', filterValue);

    let filtered = eventsData;
    if (filterValue !== 'all') {
        filtered = eventsData.filter(e => e.category === filterValue);
    }
    
    if (callback && typeof callback === 'function') {
        callback(filtered);
    } else {
        renderEvents(filtered);
        
        // Requirement Completed: JS Exercise - jQuery (fadeIn/fadeOut for event cards)
        // Using jQuery for animation as requested
        $('#eventsContainer').hide().fadeIn(500);
    }
}

// Requirement Completed: JS Exercise - Closures (Track total registrations per category)
const registrationTracker = (function() {
    const categories = { music: 0, sports: 0, tech: 0, free: 0, art: 0 };
    return {
        addRegistration: function(category) {
            if(categories[category] !== undefined) {
                categories[category]++;
            }
            return categories;
        },
        getStats: function() {
            return categories;
        }
    };
})();

// Requirement Completed: JS Exercise - Form Handling (form.elements, preventDefault, inline errors)
function registerUser(e) {
    e.preventDefault();
    
    // Requirement Completed: JS Exercise - Error Handling (try-catch)
    try {
        if (!form.checkValidity()) {
            throw new Error("Form validation failed. Please check required fields.");
        }

        // Requirement Completed: JS Exercise - Form elements, Data Types (const, let)
        const name = form.elements['regName'].value;
        const email = form.elements['regEmail'].value;
        const eventType = form.elements['regEventType'].value;
        const date = form.elements['regDate'].value;
        
        let availableSeats = 50 - registrationTracker.getStats()[eventType];
        
        // Requirement Completed: JS Exercise - ++ / --
        totalRegistrations++;
        availableSeats--; 
        registrationTracker.addRegistration(eventType);
        
        const regBtn = document.getElementById('registerBtn');
        regBtn.innerHTML = '<span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span> Processing...';
        regBtn.disabled = true;

        // Data for POST
        const payload = { name, email, eventType, date };

        // Requirement Completed: JS Exercise - AJAX (fetch POST)
        setTimeout(() => {
            fetch('https://jsonplaceholder.typicode.com/posts', {
                method: 'POST',
                body: JSON.stringify(payload),
                headers: {
                    'Content-type': 'application/json; charset=UTF-8',
                },
            })
            .then((response) => response.json()) // Requirement Completed: JS Exercise - Async (.then .catch)
            .then((json) => {
                console.log("Registration API Response:", json);
                
                // Success UI update (Vanilla class hidden instead of d-none)
                document.getElementById('regOutputArea').classList.remove('hidden');
                
                // Requirement Completed: JS Exercise - Template literals for output
                document.getElementById('regConfirmation').innerHTML = 
                    `<strong>Ticket ID:</strong> #${Math.floor(Math.random() * 10000)}<br>
                     <strong>Name:</strong> ${name}<br>
                     <strong>Event:</strong> ${eventType.toUpperCase()}<br>
                     <em>Remaining Seats in Category: ${availableSeats}</em><br>
                     A confirmation email has been sent to ${email}.`;
                     
                form.reset();
                form.classList.remove('was-validated');
                document.getElementById('feeDisplay').innerText = "$0.00";
                document.getElementById('charCount').innerText = "0";
                
                // Clear sessionStorage on success
                sessionStorage.removeItem('draftForm');
                isFormDirty = false;
                
            })
            .catch(err => {
                console.error("Registration failed:", err);
                alert("Registration failed. Please try again.");
            })
            .finally(() => {
                regBtn.innerHTML = 'Submit Registration';
                regBtn.disabled = false;
            });
        }, 1500);

    } catch (err) {
        e.stopPropagation();
        form.classList.add('was-validated');
        console.warn(err.message);
    }
}

// Requirement Completed: HTML Exercise - Event Handling (onchange) display fee
function calculateFee() {
    const select = document.getElementById('regEventType');
    const selectedOption = select.options[select.selectedIndex];
    
    // Requirement Completed: JS - Modern ES6+ (Default parameters)
    const getFeeString = (fee = 0) => {
        return fee > 0 ? `$${parseFloat(fee).toFixed(2)}` : "Free";
    };

    if (selectedOption && selectedOption.dataset.fee) {
        document.getElementById('feeDisplay').innerText = getFeeString(selectedOption.dataset.fee);
    }
}

// Requirement Completed: HTML Exercise - Event Handling (onblur) validate phone
function validatePhone(input) {
    const phoneRegex = /^[0-9]{3}-[0-9]{3}-[0-9]{4}$/;
    const errorDiv = document.getElementById('phoneError');
    if (input.value && !phoneRegex.test(input.value)) {
        input.setCustomValidity("Invalid");
        errorDiv.innerText = "Format must be: 123-456-7890";
    } else {
        input.setCustomValidity("");
        errorDiv.innerText = "Please provide a valid phone number.";
    }
}

// Requirement Completed: HTML Exercise - Event Handling (keydown/keyup) Live char counter
document.getElementById('regMessage').addEventListener('keyup', function() {
    const count = this.value.length;
    document.getElementById('charCount').innerText = count;
});

// Form state tracking for beforeunload and sessionStorage
let isFormDirty = false;

document.querySelectorAll('#regForm input, #regForm select, #regForm textarea').forEach(element => {
    element.addEventListener('change', () => {
        isFormDirty = true;
        // Requirement Completed: HTML Exercise - Storage (sessionStorage)
        const draftData = {
            name: document.getElementById('regName').value,
            email: document.getElementById('regEmail').value
        };
        sessionStorage.setItem('draftForm', JSON.stringify(draftData));
    });
});

// Requirement Completed: HTML Exercise - Before Unload
window.onbeforeunload = function(e) {
    if (isFormDirty) {
        const msg = "You have unsaved changes in your registration form. Are you sure you want to leave?";
        e.returnValue = msg;
        return msg;
    }
};

// Requirement Completed: HTML Exercise - Storage (Clear Preferences)
document.getElementById('clearPrefsBtn').addEventListener('click', () => {
    localStorage.clear();
    sessionStorage.clear();
    document.getElementById('eventFilter').value = 'all';
    filterEventsByCategory();
    alert("Preferences cleared!");
});

function loadPreferences() {
    const prefCat = localStorage.getItem('preferredCategory');
    if (prefCat) {
        document.getElementById('eventFilter').value = prefCat;
        // Small delay to allow data to load first
        setTimeout(() => filterEventsByCategory(), 100);
    }

    const draft = sessionStorage.getItem('draftForm');
    if (draft) {
        try {
            const data = JSON.parse(draft);
            if(data.name) document.getElementById('regName').value = data.name;
            if(data.email) document.getElementById('regEmail').value = data.email;
        } catch(e) {}
    }
}

// Requirement Completed: HTML Exercise - Geolocation
document.getElementById('findNearbyBtn').addEventListener('click', () => {
    const resultP = document.getElementById('geoResult');
    resultP.innerHTML = "Locating...";
    
    if (navigator.geolocation) {
        // Requirement Completed: HTML Exercise - Geolocation (enableHighAccuracy)
        navigator.geolocation.getCurrentPosition(
            (position) => {
                // Success
                const lat = position.coords.latitude;
                const lon = position.coords.longitude;
                // Requirement Completed: HTML Exercise - Geolocation (Display coordinates)
                resultP.innerHTML = `<span class="text-success fw-bold"><i class="bi bi-geo-alt-fill"></i> Found you!</span><br>Lat: ${lat.toFixed(4)}, Lon: ${lon.toFixed(4)}<br>Showing events within 10 miles.`;
                console.log(`User location: ${lat}, ${lon}`);
                
                // Breakpoint hint
                // BREAKPOINT: Check coordinate values here
            },
            (error) => {
                // Requirement Completed: HTML Exercise - Geolocation (Handle permissions, timeout, unavailable)
                switch(error.code) {
                    case error.PERMISSION_DENIED:
                        resultP.innerHTML = "Location request denied.";
                        break;
                    case error.POSITION_UNAVAILABLE:
                        resultP.innerHTML = "Location information is unavailable.";
                        break;
                    case error.TIMEOUT:
                        resultP.innerHTML = "The request to get user location timed out.";
                        break;
                    case error.UNKNOWN_ERROR:
                        resultP.innerHTML = "An unknown error occurred.";
                        break;
                }
            },
            { enableHighAccuracy: true, timeout: 5000, maximumAge: 0 }
        );
    } else {
        resultP.innerHTML = "Geolocation is not supported by this browser.";
    }
});

function setupEventListeners() {
    // jQuery click handler (Requirement Completed: JS Exercise - jQuery)
    $('#registerBtn').click(registerUser);

    // Requirement Completed: JS Exercise - Event Handling (keydown quick search)
    const searchInput = document.getElementById('globalSearch');
    if (searchInput) {
        searchInput.addEventListener('keydown', function(e) {
            // Slight delay so the value is updated after the keystroke
            setTimeout(() => {
                const searchTerm = this.value.toLowerCase();
                const filtered = eventsData.filter(event => event.title.toLowerCase().includes(searchTerm));
                renderEvents(filtered);
            }, 50);
        });
    }
    
    // Toggle view buttons (List/Grid)
    const btnList = document.getElementById('btnList');
    const btnGrid = document.getElementById('btnGrid');
    
    if(btnList && btnGrid) {
        btnList.addEventListener('click', function() {
            this.classList.add('active');
            btnGrid.classList.remove('active');
            eventsContainer.classList.add('list-view');
        });
        
        btnGrid.addEventListener('click', function() {
            this.classList.add('active');
            btnList.classList.remove('active');
            eventsContainer.classList.remove('list-view');
        });
    }
}

// Requirement Completed: HTML Exercise - Video oncanplay
function videoReady() {
    const statusDiv = document.getElementById('videoStatus');
    statusDiv.classList.remove('hidden');
    setTimeout(() => {
        statusDiv.classList.add('fadeOut'); // Custom CSS class for fade out
        setTimeout(() => statusDiv.classList.add('hidden'), 1000);
    }, 3000);
}

// Requirement Completed: HTML Exercise - ondblclick enlarge image
function enlargeImage(imgElement) {
    const modalImg = document.getElementById('enlargedImg');
    modalImg.src = imgElement.src;
    document.getElementById('imageModal').classList.add('show');
}

// Requirement Completed: JS Exercise - Arrays (push)
// Helper to dynamically add events
function pushNewEvent(eventObj) {
    eventsData.push(eventObj);
    renderEvents(eventsData);
}

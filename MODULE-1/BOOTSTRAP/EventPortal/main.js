window.addEventListener('load', () => {
    initializeCoreApp();
});
const eventsGridContainer = document.querySelector('#gridEventsContainer');
const signupForm = document.getElementById('formRegistration');
let registeredActivities = [];
let totalSignups = 0;
class ActivityItem {
    constructor(uid, label, dateVal, venueLoc, groupType, costRate, graphicPath, bodySummary) {
        this.id = uid;
        this.title = label;
        this.date = dateVal;
        this.location = venueLoc;
        this.category = groupType;
        this.fee = costRate;
        this.image = graphicPath;
        this.description = bodySummary;
        this.registeredCount = 0;
        this.maxCapacity = 50;
    }
}
ActivityItem.prototype.checkAvailability = function() {
    return this.registeredCount < this.maxCapacity;
};
async function retrieveOnlineActivities() {
    if (eventsGridContainer) {
        eventsGridContainer.innerHTML = `
            <div class="text-center py-5 w-100">
                <div class="spinner-border text-primary" role="status"></div>
                <p class="mt-2 text-muted">Retrieving upcoming experiences...</p>
            </div>
        `;
    }
    try {
        const serverResponse = await fetch('https://jsonplaceholder.typicode.com/posts?_limit=6');
        const parsedResponse = await serverResponse.json();
        const localMockData = [
            { id: 1, title: "Summer Festival", date: "2025-07-15", location: "Central Park", category: "music", fee: 25, image: "assets/images/event1.png", isPast: false },
            { id: 2, title: "Night Concert", date: "2025-08-20", location: "Downtown Arena", category: "music", fee: 40, image: "assets/images/event2.png", isPast: false },
            { id: 3, title: "Food Festival", date: "2025-06-10", location: "Town Square", category: "food", fee: 10, image: "assets/images/event3.png", isPast: false },
            { id: 4, title: "Art Exhibition", date: "2025-09-05", location: "City Gallery", category: "art", fee: 15, image: "assets/images/event4.png", isPast: false },
            { id: 5, title: "City Marathon", date: "2025-10-12", location: "City Streets", category: "sports", fee: 30, image: "assets/images/event5.png", isPast: false },
            { id: 6, title: "Tech Workshop", date: "2025-11-18", location: "Innovation Hub", category: "tech", fee: 50, image: "assets/images/event6.png", isPast: false },
            { id: 7, title: "Past Event", date: "2023-01-01", location: "Old Hall", category: "music", fee: 0, image: "assets/images/event1.png", isPast: true }
        ];
        registeredActivities = localMockData.map(record =>
            new ActivityItem(record.id, record.title, record.date, record.location, record.category, record.fee, record.image, "Experience an amazing " + record.title + " in our local neighborhood.")
        );
        registeredActivities.forEach((record, idx) => {
            record.isPast = localMockData[idx].isPast;
            if (idx === 1) record.registeredCount = 50;
        });
        const filteredMusicOnly = registeredActivities.filter(record => record.category === 'music');
        renderActivityGrid(registeredActivities);
    } catch (apiError) {
    }
}
function renderActivityGrid(listToRender) {
    if (!eventsGridContainer) return;
    eventsGridContainer.innerHTML = '';
    const validActivities = listToRender.filter(record => {
        if (record.isPast) {
            return false;
        } else if (!record.checkAvailability()) {
            return false;
        } else {
            return true;
        }
    });
    const convertedCards = validActivities.map(record => {
        return {
            ...record,
            customLabelHeader: `${record.category.toUpperCase()} | ${record.title}`
        };
    });
    convertedCards.forEach(record => {
        const cardColDiv = document.createElement('div');
        cardColDiv.className = 'activity-col-wrap';
        cardColDiv.innerHTML = `
            <div class="activity-card-item">
                <div class="position-relative">
                    <img src="${record.image}" class="activity-card-img" alt="${record.title}" style="height: 200px; object-fit: cover;">
                    <span class="activity-card-badge">${record.category}</span>
                </div>
                <div class="activity-card-body">
                    <h5 class="activity-card-title text-primary fw-bold">${record.customLabelHeader}</h5>
                    <p class="activity-card-desc text-muted small flex-grow-1">${record.description}</p>
                    <ul class="activity-card-meta small mb-3">
                        <li><i class="fa-solid fa-calendar-days me-2"></i> ${record.date}</li>
                        <li><i class="fa-solid fa-location-dot me-2"></i> ${record.location}</li>
                        <li><i class="fa-solid fa-tag me-2"></i> $${record.fee}</li>
                    </ul>
                    <button class="btn btn-outline w-100 mt-auto" onclick="openActivityDialog(${record.id})">View Details</button>
                </div>
            </div>
        `;
        eventsGridContainer.appendChild(cardColDiv);
    });
}
function initializeCoreApp() {
    retrieveOnlineActivities();
    registerGlobalListeners();
    loadSavedPreferences();
}
function registerNewEventPlaceholder() {
}
function openActivityDialog(activityId) {
    const foundActivity = registeredActivities.find(record => record.id === activityId);
    if (!foundActivity) return;
    const { title, image, category, fee, description, date, location } = foundActivity;
    for (const [propName, propVal] of Object.entries(foundActivity)) {
    }
    document.getElementById('lblModalEventTitle').innerText = title;
    document.getElementById('imgModalEvent').src = image;
    document.getElementById('lblModalEventCategory').innerText = category.toUpperCase();
    document.getElementById('lblModalEventFee').innerText = fee === 0 ? "Free" : `$${fee}`;
    document.getElementById('lblModalEventDesc').innerText = description;
    document.getElementById('lblModalEventDate').innerText = date;
    document.getElementById('lblModalEventLocation').innerText = location;
    document.getElementById('modalEventDetails').classList.add('show');
}
function closeActiveDialog(modalId) {
    document.getElementById(modalId).classList.remove('show');
}
function jumpToRegistration() {
    closeActiveDialog('modalEventDetails');
    document.getElementById('registration-section').scrollIntoView({ behavior: 'smooth' });
}
function filterPortalActivities(customCallbackRoutine = null) {
    const activeFilterValue = document.getElementById('selectCategoryFilter').value;
    localStorage.setItem('savedCategoryFilter', activeFilterValue);
    let matchingActivities = registeredActivities;
    if (activeFilterValue !== 'all') {
        matchingActivities = registeredActivities.filter(record => record.category === activeFilterValue);
    }
    if (customCallbackRoutine && typeof customCallbackRoutine === 'function') {
        customCallbackRoutine(matchingActivities);
    } else {
        renderActivityGrid(matchingActivities);
        $('#gridEventsContainer').hide().fadeIn(500);
    }
}
const signupTallyManager = (() => {
    const tallyRecord = { music: 0, sports: 0, tech: 0, free: 0, art: 0 };
    return {
        incrementRegistration: (typeKey) => {
            if (tallyRecord[typeKey] !== undefined) {
                tallyRecord[typeKey]++;
            }
            return tallyRecord;
        },
        getTallyCounts: () => {
            return tallyRecord;
        }
    };
})();
function onFormSubmit(e) {
    e.preventDefault();
    try {
        if (!signupForm.checkValidity()) {
            throw new Error("Form validation failed. Check highlighted fields.");
        }
        const clientNameVal = signupForm.elements['inputFullName'].value;
        const clientEmailVal = signupForm.elements['inputEmailAddress'].value;
        const selectedTypeVal = signupForm.elements['selectExperienceType'].value;
        const selectedDateVal = signupForm.elements['inputEventDate'].value;
        let seatsRemainingVal = 50 - signupTallyManager.getTallyCounts()[selectedTypeVal];
        totalSignups++;
        seatsRemainingVal--;
        signupTallyManager.incrementRegistration(selectedTypeVal);
        const triggerSubmitBtn = document.getElementById('btnSubmitForm');
        triggerSubmitBtn.innerHTML = '<span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span> Securing Slot...';
        triggerSubmitBtn.disabled = true;
        const uploadDataPayload = {
            clientName: clientNameVal,
            clientEmail: clientEmailVal,
            experienceType: selectedTypeVal,
            requestedDate: selectedDateVal
        };
        setTimeout(() => {
            fetch('https://jsonplaceholder.typicode.com/posts', {
                method: 'POST',
                body: JSON.stringify(uploadDataPayload),
                headers: {
                    'Content-type': 'application/json; charset=UTF-8',
                },
            })
            .then(res => res.json())
            .then(parsedOutput => {
                document.getElementById('boxSuccessReceipt').classList.remove('hidden');
                document.getElementById('outConfirmationReceipt').innerHTML =
                    `<strong>Confirmation Receipt:</strong> #${Math.floor(Math.random() * 12345)}<br>
                     <strong>Name:</strong> ${clientNameVal}<br>
                     <strong>Selected Event:</strong> ${selectedTypeVal.toUpperCase()}<br>
                     <em>Remaining Seats: ${seatsRemainingVal}</em><br>
                     A confirmation has been sent to ${clientEmailVal}.`;
                signupForm.reset();
                signupForm.classList.remove('was-validated');
                document.getElementById('txtCalculatedFee').innerText = "$0.00";
                document.getElementById('spanCharCounter').innerText = "0";
                sessionStorage.removeItem('cachedRegistrationDraft');
                dirtyFormCheck = false;
            })
            .catch(error => {
            })
            .finally(() => {
                triggerSubmitBtn.innerHTML = 'Confirm Registration <i class="fa-solid fa-arrow-right" style="margin-left: 10px;"></i>';
                triggerSubmitBtn.disabled = false;
            });
        }, 1500);
    } catch (validException) {
        e.stopPropagation();
        signupForm.classList.add('was-validated');
    }
}
function calculateTotalFee() {
    const listElement = document.getElementById('selectExperienceType');
    const highlightedOption = listElement.options[listElement.selectedIndex];
    const getFormattedCostText = (costRate = 0) => {
        return costRate > 0 ? `$${parseFloat(costRate).toFixed(2)}` : "Free";
    };
    if (highlightedOption && highlightedOption.dataset.fee) {
        document.getElementById('txtCalculatedFee').innerText = getFormattedCostText(highlightedOption.dataset.fee);
    }
}
function validatePhoneNumber(phoneInputElement) {
    const numberRegex = /^[0-9]{3}-[0-9]{3}-[0-9]{4}$/;
    const labelErrorDisplay = document.getElementById('phoneError');
    if (phoneInputElement.value && !numberRegex.test(phoneInputElement.value)) {
        phoneInputElement.setCustomValidity("Invalid phone number format");
        labelErrorDisplay.innerText = "Format must be: 123-456-7890";
    } else {
        phoneInputElement.setCustomValidity("");
        labelErrorDisplay.innerText = "Please provide a valid phone number.";
    }
}
document.getElementById('textareaSpecialNotes').addEventListener('keyup', function() {
    const inputCharsLength = this.value.length;
    document.getElementById('spanCharCounter').innerText = inputCharsLength;
});
let dirtyFormCheck = false;
document.querySelectorAll('#formRegistration input, #formRegistration select, #formRegistration textarea').forEach(controlInput => {
    controlInput.addEventListener('change', () => {
        dirtyFormCheck = true;
        const draftDetails = {
            fullName: document.getElementById('inputFullName').value,
            emailAddress: document.getElementById('inputEmailAddress').value
        };
        sessionStorage.setItem('cachedRegistrationDraft', JSON.stringify(draftDetails));
    });
});
window.onbeforeunload = (e) => {
    if (dirtyFormCheck) {
        const promptWarningLabel = "Unsubmitted registration details will be discarded. Are you sure?";
        e.returnValue = promptWarningLabel;
        return promptWarningLabel;
    }
};
document.getElementById('btnResetPreferences').addEventListener('click', () => {
    localStorage.clear();
    sessionStorage.clear();
    document.getElementById('selectCategoryFilter').value = 'all';
    filterPortalActivities();
});
function loadSavedPreferences() {
    const savedFilter = localStorage.getItem('savedCategoryFilter');
    if (savedFilter) {
        document.getElementById('selectCategoryFilter').value = savedFilter;
        setTimeout(() => filterPortalActivities(), 100);
    }
    const savedDraftJSON = sessionStorage.getItem('cachedRegistrationDraft');
    if (savedDraftJSON) {
        try {
            const parsedDraftObj = JSON.parse(savedDraftJSON);
            if (parsedDraftObj.fullName) document.getElementById('inputFullName').value = parsedDraftObj.fullName;
            if (parsedDraftObj.emailAddress) document.getElementById('inputEmailAddress').value = parsedDraftObj.emailAddress;
        } catch (parsingErr) {}
    }
}
function registerGlobalListeners() {
    $('#btnSubmitForm').click(onFormSubmit);
    const filterSearchControl = document.getElementById('inputGlobalSearch');
    if (filterSearchControl) {
        filterSearchControl.addEventListener('keydown', function(e) {
            setTimeout(() => {
                const searchKeyword = this.value.toLowerCase();
                const matches = registeredActivities.filter(record => record.title.toLowerCase().includes(searchKeyword));
                renderActivityGrid(matches);
            }, 50);
        });
    }
    const layoutListTrigger = document.getElementById('btnListView');
    const layoutGridTrigger = document.getElementById('btnGridView');
    if (layoutListTrigger && layoutGridTrigger) {
        layoutListTrigger.addEventListener('click', function() {
            this.classList.add('active');
            layoutGridTrigger.classList.remove('active');
            eventsGridContainer.classList.add('list-view');
        });
        layoutGridTrigger.addEventListener('click', function() {
            this.classList.add('active');
            layoutListTrigger.classList.remove('active');
            eventsGridContainer.classList.remove('list-view');
        });
    }
}
function videoReadyCallback() {
    const statusToastOverlay = document.getElementById('videoStatus');
    statusToastOverlay.classList.remove('hidden');
    setTimeout(() => {
        statusToastOverlay.classList.add('fadeOut');
        setTimeout(() => statusToastOverlay.classList.add('hidden'), 1000);
    }, 3000);
}
function expandImagePreview(imgElementRef) {
    const popupEnlargedImg = document.getElementById('imgEnlarged');
    popupEnlargedImg.src = imgElementRef.src;
    document.getElementById('modalImageZoom').classList.add('show');
}
function appendNewActivity(newActivityObj) {
    registeredActivities.push(newActivityObj);
    renderActivityGrid(registeredActivities);
}
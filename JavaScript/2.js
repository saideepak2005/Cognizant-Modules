const eventName = "Community Cleanup";
const eventDate = "2024-08-15";
let availableSeats = 5;

document.getElementById("event-title").textContent = eventName;
document.getElementById("event-info").textContent = `Date: ${eventDate}`;
const seatDisplay = document.getElementById("seat-count");
const registerBtn = document.getElementById("register-btn");

seatDisplay.textContent = availableSeats;

registerBtn.addEventListener("click", function() {
  if (availableSeats > 0) {
    availableSeats--;
    seatDisplay.textContent = availableSeats;
  }
  if (availableSeats === 0) {
    registerBtn.disabled = true;
    registerBtn.textContent = "Full";
  }
});

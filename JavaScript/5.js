function Event(name, date, totalSeats, bookedSeats) {
  this.name = name;
  this.date = date;
  this.totalSeats = totalSeats;
  this.bookedSeats = bookedSeats;
}

Event.prototype.checkAvailability = function() {
  return this.totalSeats - this.bookedSeats;
};

const ev1 = new Event("Community Cleanup", "2024-09-10", 50, 45);
const ev2 = new Event("Tech Conference", "2024-10-01", 100, 100);

const container = document.getElementById("output");

function displayEventDetails(eventObj) {
  let html = `<div class="card"><h3>${eventObj.name}</h3>`;
  const entries = Object.entries(eventObj);
  entries.forEach(([key, value]) => {
    html += `<p><span class="prop">${key}</span>: ${value}</p>`;
  });
  const available = eventObj.checkAvailability();
  html += `<p><strong>Available Seats (via Prototype):</strong> ${available}</p>`;
  html += `</div>`;
  container.innerHTML += html;
}

displayEventDetails(ev1);
displayEventDetails(ev2);

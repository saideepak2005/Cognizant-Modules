const events = [
  { id: 1, name: "Summer Fest", seats: 10, isPast: false },
  { id: 2, name: "Tech Meetup", seats: 0, isPast: false },
  { id: 3, name: "Old Workshop", seats: 5, isPast: true },
  { id: 4, name: "Art Exhibition", seats: 3, isPast: false }
];

const container = document.getElementById("events-container");
const errorMsg = document.getElementById("error-message");

function renderEvents() {
  container.innerHTML = "";
  events.forEach(function(event) {
    if (!event.isPast && event.seats > 0) {
      const card = document.createElement("div");
      card.className = "card";
      card.innerHTML = `
        <h3>${event.name}</h3>
        <p>Seats: <span id="seats-${event.id}">${event.seats}</span></p>
        <button class="btn" onclick="handleRegister(${event.id})">Register</button>
      `;
      container.appendChild(card);
    }
  });
}

window.handleRegister = function(id) {
  try {
    const event = events.find(e => e.id === id);
    if (!event) throw new Error("Event not found");
    if (event.seats <= 0) throw new Error("No seats available");
    
    event.seats--;
    document.getElementById(`seats-${id}`).textContent = event.seats;
    errorMsg.textContent = "";
    
    if (event.seats === 0) {
      renderEvents();
    }
  } catch (error) {
    errorMsg.textContent = error.message;
  }
};

renderEvents();

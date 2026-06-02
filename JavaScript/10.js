const originalEvents = [
  { id: 1, title: "Modern JS Meetup", location: "Library", seats: 30 },
  { id: 2, title: "ES6 Workshop", location: "Tech Hub", seats: 20 },
  { id: 3, title: "Outdated Event", location: "Old Hall", seats: 5 }
];

const processEvents = (eventsArray, minSeats = 10) => {
  const clonedEvents = [...eventsArray];
  
  const filtered = clonedEvents.filter(ev => ev.seats >= minSeats);
  
  const container = document.getElementById("es6-output");
  filtered.forEach(ev => {
    const { title, location, seats } = ev;
    
    container.innerHTML += `
      <div class="card">
        <h3>${title}</h3>
        <p>Location: ${location} | Seats: ${seats}</p>
      </div>
    `;
  });
};

processEvents(originalEvents);

const events = [
  { name: "Local Rock Band", category: "Music" },
  { name: "Baking Basics", category: "Workshop" }
];

events.push({ name: "Jazz Evening", category: "Music" });

document.getElementById("all-events").textContent = JSON.stringify(events, null, 2);

const musicEvents = events.filter(e => e.category === "Music");
document.getElementById("filtered-events").textContent = JSON.stringify(musicEvents, null, 2);

const mappedEvents = events.map(e => `${e.category} Session: ${e.name}`);
document.getElementById("mapped-events").textContent = JSON.stringify(mappedEvents, null, 2);

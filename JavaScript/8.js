const allEvents = [
  { id: 1, name: "Summer Jazz", category: "Music" },
  { id: 2, name: "React Workshop", category: "Tech" },
  { id: 3, name: "Rock Concert", category: "Music" }
];

const container = document.getElementById("events-list");
const searchBox = document.getElementById("search-box");
const categoryFilter = document.getElementById("category-filter");

function renderEvents(list) {
  container.innerHTML = "";
  list.forEach(ev => {
    const div = document.createElement("div");
    div.className = "event-item";
    div.innerHTML = `
      <div><strong>${ev.name}</strong> (${ev.category})</div>
      <button class="btn" onclick="alert('Registered for ${ev.name}!')">Register</button>
    `;
    container.appendChild(div);
  });
}

function filterEvents() {
  const searchTerm = searchBox.value.toLowerCase();
  const category = categoryFilter.value;
  
  const filtered = allEvents.filter(ev => {
    const matchesSearch = ev.name.toLowerCase().includes(searchTerm);
    const matchesCategory = category === "All" || ev.category === category;
    return matchesSearch && matchesCategory;
  });
  
  renderEvents(filtered);
}

searchBox.addEventListener("keyup", filterEvents);
categoryFilter.addEventListener("change", filterEvents);

renderEvents(allEvents);

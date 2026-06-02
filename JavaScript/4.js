function createRegistrationCounter() {
  let count = 0;
  return function() {
    count++;
    return count;
  };
}

const registerMusic = createRegistrationCounter();
const registerTech = createRegistrationCounter();

document.getElementById('reg-music').addEventListener('click', () => {
  document.getElementById('count-music').textContent = registerMusic();
});

document.getElementById('reg-tech').addEventListener('click', () => {
  document.getElementById('count-tech').textContent = registerTech();
});

const events = [
  { name: 'Jazz Fest', category: 'Music' },
  { name: 'React Meetup', category: 'Tech' },
  { name: 'Rock Concert', category: 'Music' }
];

function filterEventsByCategory(eventList, category, callback) {
  const filtered = eventList.filter(e => e.category === category);
  callback(filtered);
}

function displayFiltered(filteredEvents) {
  const container = document.getElementById('filtered-events');
  container.innerHTML = `<h3>Music Events Only (Higher-Order Filter)</h3>`;
  filteredEvents.forEach(e => {
    container.innerHTML += `<div class="event-item">${e.name} - ${e.category}</div>`;
  });
}

filterEventsByCategory(events, 'Music', displayFiltered);

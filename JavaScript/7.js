const events = [
  { id: 1, name: "Community Picnic", status: "Not Registered" },
  { id: 2, name: "Book Fair", status: "Not Registered" }
];

const container = document.querySelector("#dynamic-events");

function render() {
  container.innerHTML = "";
  events.forEach(ev => {
    const card = document.createElement("div");
    card.className = "event-card";
    
    const title = document.createElement("h3");
    title.textContent = ev.name;
    
    const status = document.createElement("p");
    status.textContent = `Status: ${ev.status}`;
    
    const btn = document.createElement("button");
    if (ev.status === "Not Registered") {
      btn.textContent = "Register";
      btn.className = "btn";
      btn.onclick = () => { ev.status = "Registered"; render(); };
    } else {
      btn.textContent = "Cancel";
      btn.className = "btn cancel";
      btn.onclick = () => { ev.status = "Not Registered"; render(); };
    }
    
    card.appendChild(title);
    card.appendChild(status);
    card.appendChild(btn);
    container.appendChild(card);
  });
}

render();

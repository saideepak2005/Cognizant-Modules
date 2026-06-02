const loadBtn = document.getElementById("load-btn");
const spinner = document.getElementById("spinner");
const container = document.getElementById("api-events");

function mockApiCall() {
  return new Promise((resolve) => {
    setTimeout(() => {
      resolve([
        { id: 101, name: "Async Art Show", date: "2024-11-01" },
        { id: 102, name: "Promise Picnic", date: "2024-11-05" }
      ]);
    }, 1500);
  });
}

loadBtn.addEventListener("click", async () => {
  spinner.style.display = "block";
  container.innerHTML = "";
  loadBtn.disabled = true;
  
  try {
    const data = await mockApiCall();
    data.forEach(ev => {
      const div = document.createElement("div");
      div.className = "api-item";
      div.innerHTML = `<strong>${ev.name}</strong> - ${ev.date}`;
      container.appendChild(div);
    });
  } catch (err) {
    container.innerHTML = `<p style="color:red;">Error loading events.</p>`;
  } finally {
    spinner.style.display = "none";
    loadBtn.disabled = false;
  }
});

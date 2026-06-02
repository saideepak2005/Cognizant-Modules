const ajaxForm = document.getElementById("ajax-form");
const statusDiv = document.getElementById("status");

ajaxForm.addEventListener("submit", function(e) {
  e.preventDefault();
  
  const name = document.getElementById("ajax-name").value;
  statusDiv.textContent = "Sending data...";
  statusDiv.className = "status";
  
  setTimeout(() => {
    fetch("https://jsonplaceholder.typicode.com/posts", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify({ name: name, event: "Community Event" })
    })
    .then(response => {
      if (!response.ok) throw new Error("Network response was not ok");
      return response.json();
    })
    .then(data => {
      statusDiv.textContent = "Registration successful! ID: " + data.id;
      statusDiv.className = "status success";
      ajaxForm.reset();
    })
    .catch(error => {
      statusDiv.textContent = "Registration failed. Try again.";
      statusDiv.className = "status error";
    });
  }, 1000);
});

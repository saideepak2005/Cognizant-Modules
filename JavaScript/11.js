const form = document.getElementById("reg-form");

form.addEventListener("submit", function(event) {
  event.preventDefault();
  
  let isValid = true;
  const elements = form.elements;
  
  const name = elements["name"].value.trim();
  const email = elements["email"].value.trim();
  const selectedEvent = elements["event"].value;
  
  document.getElementById("name-err").textContent = name === "" ? "Name is required" : "";
  document.getElementById("email-err").textContent = email === "" ? "Email is required" : "";
  document.getElementById("event-err").textContent = selectedEvent === "" ? "Please select an event" : "";
  
  if (name === "" || email === "" || selectedEvent === "") {
    isValid = false;
  }
  
  const successMsg = document.getElementById("success-msg");
  if (isValid) {
    successMsg.textContent = "Registration successful!";
    form.reset();
  } else {
    successMsg.textContent = "";
  }
});

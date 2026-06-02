const btn = document.getElementById("submit-btn");

btn.addEventListener("click", function() {
  const uname = document.getElementById("username").value;
  
  debugger;
  
  console.log("Submitting form for:", uname);
  
  fetch("https://jsonplaceholder.typicode.com/invalid-endpoint", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ user: uname })
  })
  .then(res => {
    console.log("Response status:", res.status);
  })
  .catch(err => {
    console.error("Network error occurred:", err);
  });
});

import os

folder = r"c:\Users\91996\Desktop\cog\html"
os.makedirs(folder, exist_ok=True)

files = {}

files["1.html"] = """<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>HTML5 Base Template</title>
</head>
<body>
<!-- Navigation -->
<nav>
    <p>Navigation goes here</p>
</nav>
<!-- Main -->
<main>
    <p>Main content goes here</p>
</main>
<!-- Footer -->
<footer>
    <p>Footer goes here</p>
</footer>
</body>
</html>"""

files["2.html"] = """<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Navigation and Linking</title>
</head>
<body>
<nav>
    <a href="#home">Home</a> | 
    <a href="#events">Events</a> | 
    <a href="#contact">Contact</a> | 
    <a href="help.html" target="_blank">Help</a>
</nav>
<main>
    <section id="home">
        <h2>Home</h2>
        <p>Welcome to the portal.</p>
    </section>
    <section id="events">
        <h2>Events</h2>
        <p>Upcoming events listed here.</p>
    </section>
    <section id="contact">
        <h2>Contact</h2>
        <p>Contact information.</p>
    </section>
</main>
</body>
</html>"""

files["3.html"] = """<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Welcome Message</title>
<style>
    #welcomeBanner { background-color: blue; color: white; padding: 20px; }
    .highlight { background-color: yellow; color: black; padding: 5px; }
</style>
</head>
<body>
<div id="welcomeBanner">
    <h2>Welcome to the Community Portal!</h2>
    <p>Enjoy a <span style="color: red; font-weight: bold;">special offer</span> for our local residents.</p>
</div>
<br>
<p class="highlight">Don't miss our upcoming events!</p>
</body>
</html>"""

files["4.html"] = """<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Image Gallery</title>
<style>
    .gallery-img { border: 2px solid #333; width: 100px; height: 100px; object-fit: cover; }
    table, th, td { border: 1px solid #ddd; border-collapse: collapse; padding: 10px; text-align: center; }
</style>
</head>
<body>
<h2>Past Events Gallery</h2>
<table>
    <tr>
        <td>
            <img src="https://picsum.photos/100" alt="Music Fest" title="Summer Music Fest" class="gallery-img">
            <p>Music Fest</p>
        </td>
        <td>
            <img src="https://picsum.photos/101" alt="Art Expo" title="Local Art Expo" class="gallery-img">
            <p>Art Expo</p>
        </td>
        <td>
            <img src="https://picsum.photos/102" alt="Food Fair" title="Community Food Fair" class="gallery-img">
            <p>Food Fair</p>
        </td>
    </tr>
    <tr>
        <td>
            <img src="https://picsum.photos/103" alt="Tech Meetup" title="Tech Meetup" class="gallery-img">
            <p>Tech Meetup</p>
        </td>
        <td>
            <img src="https://picsum.photos/104" alt="Book Club" title="Book Club Meeting" class="gallery-img">
            <p>Book Club</p>
        </td>
        <td>
            <img src="https://picsum.photos/105" alt="Marathon" title="City Marathon" class="gallery-img">
            <p>Marathon</p>
        </td>
    </tr>
</table>
</body>
</html>"""

files["5.html"] = """<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Event Registration</title>
<style>
    body { font-family: sans-serif; }
    form { max-width: 400px; margin: 20px 0; display: flex; flex-direction: column; gap: 10px; }
    input, select, textarea, button { padding: 8px; font-size: 1rem; }
    output { font-weight: bold; color: green; }
</style>
</head>
<body>
<h2>Register for an Event</h2>
<form onsubmit="event.preventDefault(); document.getElementById('res').value = 'Registration Confirmed!';">
    <input type="text" name="name" placeholder="Full Name" required autofocus>
    <input type="email" name="email" placeholder="Email Address" required>
    <input type="date" name="date" required>
    <select name="type" required>
        <option value="">Select Event Type</option>
        <option value="music">Music</option>
        <option value="tech">Tech</option>
        <option value="art">Art</option>
    </select>
    <textarea name="message" placeholder="Optional Message" rows="4"></textarea>
    <button type="submit">Submit Registration</button>
    <output id="res"></output>
</form>
</body>
</html>"""

files["6.html"] = """<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Event Feedback & Handling</title>
<style>
    body { font-family: sans-serif; padding: 20px; }
    .interactive-img { transition: all 0.3s ease; cursor: pointer; }
</style>
</head>
<body>
<h2>Interactive Feedback Form</h2>
<form>
    <label>Phone Number (blur to validate):</label><br>
    <input type="text" placeholder="1234567890" onblur="if(this.value.length < 10) alert('Invalid phone number! Needs at least 10 digits.');">
    
    <br><br>
    <label>Select Event (change to see fee):</label><br>
    <select onchange="document.getElementById('fee').textContent = 'Fee: $' + this.value;">
        <option value="0">Select Event</option>
        <option value="10">Music - $10</option>
        <option value="50">Tech - $50</option>
    </select>
    <span id="fee" style="font-weight:bold; margin-left:10px;">Fee: $0</span>
    
    <br><br>
    <p>Double-click image to enlarge:</p>
    <img src="https://picsum.photos/100" alt="Event" class="interactive-img" ondblclick="this.style.width='200px'; this.style.height='200px';">
    
    <br><br>
    <label>Feedback (type to count chars):</label><br>
    <textarea onkeyup="document.getElementById('charCount').textContent = this.value.length + ' chars';"></textarea>
    <p id="charCount">0 chars</p>
    
    <button type="button" onclick="alert('Submission Confirmed!');">Confirm</button>
</form>
</body>
</html>"""

files["7.html"] = """<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Video Invite</title>
</head>
<body>
<h2>Event Promo</h2>
<video width="320" height="240" controls oncanplay="document.getElementById('vid-msg').textContent='Video ready to play!';">
    <source src="https://www.w3schools.com/html/mov_bbb.mp4" type="video/mp4">
    Your browser does not support the video tag.
</video>
<p id="vid-msg" style="color: blue; font-weight: bold;">Loading video...</p>
<script>
    window.onbeforeunload = function() {
        return "Are you sure you want to leave this page before finishing?";
    };
</script>
<p><i>Note: Try refreshing or closing the tab to see the onbeforeunload warning.</i></p>
</body>
</html>"""

files["8.html"] = """<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>User Preferences</title>
</head>
<body>
<h2>Save Your Preference</h2>
<p>Select your favorite event type. It will be remembered when you reload the page.</p>
<select id="eventType" onchange="localStorage.setItem('prefEvent', this.value);">
    <option value="">Select Event Type</option>
    <option value="music">Music</option>
    <option value="tech">Tech</option>
    <option value="art">Art</option>
</select>
<br><br>
<button onclick="localStorage.clear(); sessionStorage.clear(); alert('Preferences cleared'); document.getElementById('eventType').value='';">Clear Preferences</button>

<script>
    window.onload = function() {
        const pref = localStorage.getItem('prefEvent');
        if (pref) {
            document.getElementById('eventType').value = pref;
        }
    };
</script>
</body>
</html>"""

files["9.html"] = """<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Geolocation</title>
</head>
<body>
<h2>Find Nearby Events</h2>
<button onclick="getLocation()">Find My Location</button>
<p id="loc-output" style="font-weight:bold;"></p>
<script>
function getLocation() {
    const out = document.getElementById('loc-output');
    out.textContent = "Locating...";
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(
            (pos) => { 
                out.textContent = "Latitude: " + pos.coords.latitude + ", Longitude: " + pos.coords.longitude; 
            },
            (err) => { 
                out.textContent = "Error: " + err.message; 
            },
            { enableHighAccuracy: true, timeout: 5000, maximumAge: 0 }
        );
    } else {
        out.textContent = "Geolocation is not supported by this browser.";
    }
}
</script>
</body>
</html>"""

files["10.html"] = """<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Debugging Demo</title>
</head>
<body>
<h1 id="header">Debug Me</h1>
<button onclick="crashMe()">Run Buggy Code</button>
<p>Open Chrome DevTools (F12 or Ctrl+Shift+I), check the Console, and inspect elements.</p>
<script>
    console.log("Page loaded. Inspect me in DevTools.");
    function crashMe() {
        let a = 10;
        let b = 0;
        console.log("Value of a is: " + a);
        // Place a breakpoint on the next line in DevTools
        let c = a / b;
        console.warn("Division by zero resulted in: " + c);
        document.getElementById('header').style.color = "red";
    }
</script>
</body>
</html>"""

for k, v in files.items():
    with open(os.path.join(folder, k), 'w') as f:
        f.write(v)


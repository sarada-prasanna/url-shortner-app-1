const BASE_URL = "http://localhost:8080";

let currentCode = "";

// Shorten URL
function shortenUrl() {
    const longUrl = document.getElementById("longUrl").value;

    fetch(BASE_URL + "/shorten", {
        method: "POST",
        headers: {
            "Content-Type": "text/plain"
        },
        body: longUrl
    })
    .then(res => res.text())
    .then(shortUrl => {
        document.getElementById("result").classList.remove("hidden");

        document.getElementById("shortLink").href = shortUrl;
        document.getElementById("shortLink").innerText = shortUrl;

        // Extract code from URL
        currentCode = shortUrl.split("/").pop();
    })
    .catch(err => alert("Error: " + err));
}

// Get Analytics
function getAnalytics() {
    fetch(BASE_URL + "/analytics/" + currentCode)
    .then(res => res.json())
    .then(data => {
        document.getElementById("analytics").innerHTML = `
            <p><b>Original URL:</b> ${data.originalUrl}</p>
            <p><b>Clicks:</b> ${data.clickCount}</p>
            <p><b>Created At:</b> ${data.createdAt}</p>
        `;
    })
    .catch(err => alert("Error: " + err));
}
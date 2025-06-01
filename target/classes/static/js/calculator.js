// filepath: src/main/resources/static/js/calculator.js
const form = document.getElementById('calcForm');
const resultDiv = document.getElementById('result');
const bInput = document.getElementById('b');
const opSelect = document.getElementById('operation');
const jutsuSound = document.getElementById('jutsuSound');

function updateInputs() {
    const op = opSelect.value;
    if (["ln", "exp", "factorial", "abs"].includes(op)) {
        bInput.style.display = "none";
        bInput.required = false;
    } else {
        bInput.style.display = "";
        bInput.required = true;
    }
}
opSelect.addEventListener('change', updateInputs);
updateInputs();

form.addEventListener('submit', async function(e) {
    e.preventDefault();
    if (jutsuSound) {
        jutsuSound.currentTime = 0;
        jutsuSound.play();
    }
    const a = document.getElementById('a').value;
    const b = document.getElementById('b').value;
    const op = opSelect.value;
    let url = '/api/calc/' + op + '?a=' + encodeURIComponent(a);
    if (["add", "subtract", "multiply", "divide", "power", "mod"].includes(op)) {
        url += '&b=' + encodeURIComponent(b);
    } else if (op === "root") {
        url += '&n=' + encodeURIComponent(b);
    } else if (op === "log") {
        url += '&base=' + encodeURIComponent(b);
    } else if (op === "factorial") {
        url = '/api/calc/factorial?n=' + encodeURIComponent(a);
    }
    try {
        const response = await fetch(url);
        if (!response.ok) throw new Error("Error: " + response.status);
        const text = await response.text();
        resultDiv.textContent = text;
    } catch (err) {
        resultDiv.textContent = "⚡ Rasengan Error! " + err.message;
    }
});
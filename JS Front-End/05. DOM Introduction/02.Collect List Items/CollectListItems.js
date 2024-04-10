function extractText() {
    let textElement = document.querySelectorAll('#items > li');
    let resultElement = document.getElementById('result');

    let resultString = '';
    for (const row of textElement) {
        resultString = resultString + row.textContent + '\n';
    }

    resultElement.textContent = resultString
}
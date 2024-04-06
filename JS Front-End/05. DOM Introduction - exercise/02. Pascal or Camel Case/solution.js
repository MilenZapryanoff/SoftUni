function solve() {
    let inputText = document.getElementById('text').value.toLowerCase();
    let namingConvention = document.getElementById('naming-convention').value;
    let result = document.getElementById('result');

    let resultString = '';
    let inputWords = inputText.split(' ');

    if (namingConvention === 'Camel Case') {
        resultString = resultString + inputWords[0]
        for (let i = 1; i < inputWords.length; i++) {
            let capitalizedWord = inputWords[i].charAt(0).toUpperCase() + inputWords[i].slice(1)
            resultString = resultString + capitalizedWord
        }

    } else if (namingConvention === 'Pascal Case') {
        for (const word of inputWords) {
            let capitalizedWord = word.charAt(0).toUpperCase() + word.slice(1)
            resultString = resultString + capitalizedWord
        }
    } else {
        resultString = 'Error!'
    }

    result.textContent = resultString;
}
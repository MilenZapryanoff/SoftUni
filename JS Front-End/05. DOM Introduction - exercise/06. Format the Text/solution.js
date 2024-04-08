function solve() {
    let inputElement = document.getElementById('input').value;
    let outputElement = document.getElementById('output');

    let sentences = inputElement.split('.');
    let filteredSentences = sentences.filter(sentence => sentence.trim().length > 1);
    let numberOfParagraphs = Math.ceil(filteredSentences.length / 3);

    for (let i = 1; i <= numberOfParagraphs; i++) {

        let paragraphText = '';

        for (let j = 1; j <= 3; j++) {

            if (filteredSentences.length > 0) {

                let currentSentence = filteredSentences.shift();

                if (!currentSentence.includes('.')) {
                    currentSentence = currentSentence + '.'
                }

                paragraphText += currentSentence
            }
        }

        //creating paragraphs and attaching them to the parent
        const newParagraph = document.createElement("p");

        const newParagraphText = document.createTextNode(paragraphText);
        newParagraph.appendChild(newParagraphText);

        outputElement.appendChild(newParagraph)
    }
}
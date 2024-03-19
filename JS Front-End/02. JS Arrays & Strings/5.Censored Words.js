function solve (text, wordToMask) {
    //replaceAll not accepted by judge
    while (text.includes(wordToMask)) {
        text = text.replace(wordToMask, '*'.repeat(wordToMask.length));
    }
    console.log(text)
}


solve ('A small sentence with some words', 'small');
solve ('Find the hidden word', 'hidden');
function solve (searchWord, text) {

    let words = text.split(' ');
    let wordFound = false;

    for (const word of words) {
        let currentWord = word.toString().toLowerCase();

        if (searchWord.toLowerCase() === currentWord) {
            console.log(searchWord);
            wordFound = true;
            return;
        }
    }

    if (!wordFound) {
        console.log(`${searchWord} not found!`)
    }
}

solve('javascript', 'JavaScript is the best programming language');
solve('python','JavaScript is the best programming language');
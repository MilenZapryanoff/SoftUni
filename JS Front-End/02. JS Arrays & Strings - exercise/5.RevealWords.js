function solve (keyWord, text) {

    let keyWords = keyWord.split(', ');

    for (const keyWord of keyWords) {
        let searchedWord = '*'.repeat(keyWord.toString().length);

        if (text.includes(searchedWord)) {
            text = text.replace(searchedWord, keyWord);
        }
    }
    console.log(text)
}


solve ('great', 'softuni is ***** place for learning new programming languages');
solve ('great, learning', 'softuni is ***** place for ******** new programming languages');
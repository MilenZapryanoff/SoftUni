function solve(text, searchWord) {

    // let count = text
    //     .split(' ')
    //     .filter(element => element === searchWord)
    //     .length;

    let words = text.split(' ');
    let count = 0;

    for (const word of words) {
        if (word === searchWord) {
            count++;
        }
    }

    console.log(count)
}


solve('This is a word and it also is a sentence', 'is');
solve('softuni is great place for learning new programming languages', 'softuni');
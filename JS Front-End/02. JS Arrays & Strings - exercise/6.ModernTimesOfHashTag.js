function solve(input) {
    let words = input.split(' ');

    for (const word of words) {

        let regex = /#\b[a-zA-Z]+\b/g;
        let currentWord = word.toString();

        if (regex.test(currentWord)) {
            console.log(currentWord.substring(1, 1 + currentWord.length))
        }
    }
}


solve('Nowadays everyone uses # to tag a #special word in #socialMedia');
solve('The symbol # is known #variously in English-speaking #regions as the #number sign');
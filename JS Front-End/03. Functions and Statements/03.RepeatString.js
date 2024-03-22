function solve(text, count) {

    console.log(createResultString(text, count));

    function createResultString(text, count) {
        return text.repeat(count);
    }
}


solve("abc", 3);
solve("String", 2);
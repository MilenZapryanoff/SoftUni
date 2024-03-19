function printCharsBetween(symbolOne, symbolTwo) {

    let pointers = definePointers(symbolOne, symbolTwo);
    let startPointer = pointers[0];
    let endPointer = pointers[1];

    let result = '';
    for (let i = startPointer; i < endPointer; i++) {
        let currentSymbol = String.fromCharCode(i)
        result = result + ` ${currentSymbol}`
    }

    console.log(result)


    function definePointers(symbolOne, symbolTwo) {
        let startPoint;
        let endPoint;

        if (symbolOne.charCodeAt(0) < symbolTwo.charCodeAt(0)) {
            startPoint = symbolOne.charCodeAt(0) + 1;
            endPoint = symbolTwo.charCodeAt(0);
        } else {
            startPoint = symbolTwo.charCodeAt(0) + 1;
            endPoint = symbolOne.charCodeAt(0);
        }
        return ([startPoint, endPoint]);
    }
}


printCharsBetween('a', 'd');
printCharsBetween('#', ':');
printCharsBetween('C', '#');
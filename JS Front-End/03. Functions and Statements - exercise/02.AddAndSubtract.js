function solve(numOne, numTwo, numThree) {

    let sum = (numOne, numTwo) => numOne + numTwo
    let subtract = (numOne, numTwo) => numOne - numTwo

    console.log(subtract(sum(numOne, numTwo), numThree))
}


solve(23, 6, 10);
solve(1, 17, 30);
solve(42, 58, 100);
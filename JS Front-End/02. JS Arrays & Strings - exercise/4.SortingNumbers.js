function solve(numbers) {

    // let smallestToBiggestArr = numbers.slice().sort((a, b) => a - b);
    // let biggestToSmallestArr = numbers.slice().sort((a, b) => b - a);
    // let resultArr = [];
    //
    // for (let i = 0; i < numbers.length / 2; i++) {
    //     resultArr.push(smallestToBiggestArr[i]);
    //     if (resultArr.length === numbers.length) {
    //         break;
    //     }
    //     resultArr.push(biggestToSmallestArr[i]);
    // }

    let sortedNumbers = numbers.sort((a, b) => a - b);
    let resultArr = [];

    while (sortedNumbers.length > 0) {
        let firstNumber = sortedNumbers.shift();
        let lastNumber = sortedNumbers.pop();

        resultArr.push(firstNumber);
        if (lastNumber) {
            resultArr.push(lastNumber)
        }
    }
    return resultArr;
}

console.log(solve([1, 5, -1, 10, 9]));
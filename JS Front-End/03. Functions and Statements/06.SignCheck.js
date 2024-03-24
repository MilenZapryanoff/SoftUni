function solve(...inputNumbers) {

    if (countNegativeNumbers(inputNumbers) % 2 === 0) {
        console.log('Positive')
    } else {
        console.log('Negative')
    }

    function countNegativeNumbers(inputNumbers) {

        let negativeNumbersCount = 0;

        for (const number of inputNumbers) {
            if (number < 0) {
                negativeNumbersCount++;
            }
        }
        return negativeNumbersCount;
    }
}


solve(5, 12, -15);
solve(-6, -12, 14);
solve(-1, -2, -3);
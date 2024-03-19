function solve(number) {

    let digits = number.toString().split('');
    let evenSum = 0;
    let oddSum = 0;

    for (const digit of digits) {
        let currentDigit = Number.parseInt(digit);
        if (checkDigit(currentDigit)) {
            evenSum += currentDigit;
        } else oddSum += currentDigit;
    }

    console.log(`Odd sum = ${oddSum}, Even sum = ${evenSum}`)

    function checkDigit(currentDigit) {
        return currentDigit % 2 === 0;
    }
}


solve(1000435);
solve(3495892137259234);
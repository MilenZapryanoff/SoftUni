function solve(numbers) {

    for (const number of numbers) {

        console.log(checkIfPalindrome(number));

        function checkIfPalindrome(number) {

            let digits = number.toString().split('');

            if (digits.length === 1) {
                return true;
            } else if (digits.length % 2 !== 0) {
                for (let i = 0; i < digits.length / 2; i++) {
                    return digits.shift() === digits.pop();
                }
            } else {
                for (let i = 0; i < digits.length - 1 / 2; i++) {
                    return digits.shift() === digits.pop();
                }
            }
        }
    }
}


// solve([123, 323, 421, 121]);
solve([32, 2, 232, 1010]);
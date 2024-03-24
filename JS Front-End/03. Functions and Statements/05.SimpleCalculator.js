function solve(numOne, numTwo, operator) {
    console.log(calculate(numOne, numTwo, operator))

    function calculate() {

        switch (numOne, numTwo, operator) {
            case 'multiply':
                return numOne * numTwo;
            case 'divide':
                return numOne / numTwo;
            case 'add':
                return numOne + numTwo;
            case 'subtract':
                return numOne - numTwo;
        }
    }
}

solve(5, 5, 'multiply');
solve(40, 8, 'divide');
solve(12, 19, 'add');
solve(50, 13, 'subtract');

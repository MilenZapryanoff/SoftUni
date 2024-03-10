function solve (a, b, operator) {
    if (operator === '+') {
        console.log(a + b);
    } else if (operator === '-') {
        console.log(a - b);
    } else if (operator === '*') {
        console.log(a * b);
    } else if (operator === '/') {
        console.log(a / b);
    } else if (operator === '%') {
        console.log(a % b);
    } else if (operator === '**') {
        console.log(a ** b);
    }
}

solve (5, 6, '+');
solve (3, 5.5, '*');
function solve (inputNumber) {
    for (let i = 1; i <= 10; i++) {
        result = inputNumber * i;
        console.log(`${inputNumber} X ${i} = ${result}`);
    }
}

solve (5);
solve (2);
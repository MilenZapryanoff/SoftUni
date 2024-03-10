function solve(inputNumber) {
    let sum = 0;
    let inputString = inputNumber.toString();

    for (let i = 0; i < inputString.length; i++) {
        sum += parseInt(inputString.charAt(i));
    }
    console.log(sum);
}

solve (245678);
solve (97561);
solve (543);
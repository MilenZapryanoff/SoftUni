function solve(numbers, step) {

    let resultArr = [];
    for (let i = 0; i < numbers.length; i = i + step) {
        resultArr.push(numbers[i])
    }
    return resultArr;
}


console.log(solve(['5', '20', '31', '4', '20'], 2));
console.log(solve(['dsa', 'asd', 'test', 'tset'], 2));
console.log(solve(['1', '2', '3', '4', '5'], 6));
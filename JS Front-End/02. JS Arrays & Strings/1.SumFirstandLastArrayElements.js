function solve(numbers) {
    if (numbers.length == 1) {
        console.log(numbers[0]);
    } else {
        console.log(numbers[0] + numbers[numbers.length - 1]);
    }
}


solve ([20, 30, 40]);
solve ([10, 17, 22, 33]);
solve ([11, 58, 69]);
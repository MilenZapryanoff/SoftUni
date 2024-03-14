function solve (numbers, rotation) {

    for (let i = 1; i <= rotation; i++) {
        let currentNum = numbers.shift();
        numbers.push(currentNum);
    }
    console.log(numbers.join(' '))
}

solve ([51, 47, 32, 61, 21], 2);
solve ([32, 21, 61, 1], 4);
solve ([2, 4, 15, 31], 5);
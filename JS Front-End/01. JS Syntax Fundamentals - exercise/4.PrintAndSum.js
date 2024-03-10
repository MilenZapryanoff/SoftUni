function solve (M, N) {
    let sum = 0;
    let numbersRow;
    
    for (let i = M; i <= N; i++) {
        if (numbersRow == undefined) {
            numbersRow = M
        } else {
            numbersRow = numbersRow + ` ${i}`
        }
        sum = sum + i;
    }
    console.log(numbersRow);
    console.log(`Sum: ${sum}`);
}

solve (5, 10);
solve (0, 26);
solve (50, 60);
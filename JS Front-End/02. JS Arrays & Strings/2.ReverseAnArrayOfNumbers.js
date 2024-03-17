function solve (digitsCount, sequence) {
    
    // let result = numbers
    // .slice(0, length)
    // .reverse()
    // .join(' ');

    let result='';
    for (let i=digitsCount-1; i >= 0; i--) {
        result = result.concat(sequence[i] + ' ');     
    }
    console.log(result.trim());
}

solve (3, [10, 20, 30, 40, 50]);
solve (4, [-1, 20, 99, 5]);
solve (2, [66, 43, 75, 89, 47]);
function solve(number) {

    for (let i = 0; i < number; i++) {
        let resultRow = () => {
            let result = '';
            for (let j = 0; j < number; j++) {
                result = `${result} ${number}`;
            }
            return result;
        }
        console.log(resultRow().trim())
    }
}


solve(3);
solve(7);
solve(2);
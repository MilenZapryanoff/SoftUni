function solve (number, operator1, operator2, operator3, operator4, operator5) {
    
    // решение с Array

    // const operators = [operator1, operator2, operator3, operator4, operator5];
    // for (let i = 0; i < operators.length; i++) {
    
    //     let currentOperator = operators.at(i);
    
    //     if (currentOperator === "chop") {
    //         number = number / 2;
    //         console.log(number);
    //     } else if (currentOperator === "dice") {
    //         number = Math.sqrt(number);
    //         console.log(number);
    //     } else if (currentOperator === "spice") {
    //         number = number + 1;
    //         console.log(number);
    //     } else if (currentOperator === "bake")  {
    //         number = number * 3;
    //         console.log(number);
    //     } else if (currentOperator === "fillet") {
    //         number = number - (number * 0.20);
    //         console.log(number);
    //     } 
    // }
    


    // решение без Array 
    for (let i = 1; i <= 5; i++) {
        
        let currentOperator;
        
        switch (i) {
            case 1 :
            currentOperator = operator1
            break;
            case 2 :
            currentOperator = operator2
            break;
            case 3 :
            currentOperator = operator3
            break;
            case 4 :
            currentOperator = operator4
            break;
            case 5 :
            currentOperator = operator5
            break;     
        }
        
        if (currentOperator === "chop") {
            number = number / 2;
            console.log(number);
        } else if (currentOperator === "dice") {
            number = Math.sqrt(number);
            console.log(number);
        } else if (currentOperator === "spice") {
            number = number + 1;
            console.log(number);
        } else if (currentOperator === "bake")  {
            number = number * 3;
            console.log(number);
        } else if (currentOperator === "fillet") {
            number = number - (number * 0.20);
            console.log(number);
        } 
    }
}


// solve ('32', 'chop', 'chop', 'chop', 'chop', 'chop');
solve ('9', 'dice', 'spice', 'chop', 'bake', 'fillet');
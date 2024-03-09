function solve (inputNumber) {
    
    let inputString = inputNumber.toString();
    
    let previousDigit = inputString.charAt(0);
    let currentDigit;
    let digitsIdentical = true;
    
    for (let i = 1; i < inputString.length; i++) {
        
        currentDigit = inputString.charAt(i);
        if (previousDigit !== currentDigit) {
            digitsIdentical = false;
        }
        previousDigit = currentDigit;
    }
    console.log(digitsIdentical);
    
    
    let sum = 0;
    for (let i = 0; i < inputString.length; i++) {
        if (processedDigit = undefined) {
            processedDigit = i;
        }
        sum = sum + parseInt(inputString.charAt(i));
    }
    console.log(sum);
}


solve (4444);

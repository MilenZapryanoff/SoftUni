function solve(word) {


    let isValid = true;
    lengthCheck(word);
    charsCheck(word);
    digitNumberCheck(word)

    if (isValid) {
        console.log('Password is valid')
    }

    function lengthCheck(word) {
        let regex = /^.{6,10}$/; //length check
        if (!regex.test(word)) {
            isValid = false;
            console.log('Password must be between 6 and 10 characters')
        }
    }

    function charsCheck(word) {
        let regex = /^[a-zA-Z0-9]+$/; //letters and digits check
        if (!regex.test(word)) {
            isValid = false;
            console.log('Password must consist only of letters and digits')
        }
    }

    function digitNumberCheck(word) {
        let regex = /.*\d.*\d.*/; //number of digits check
        if (!regex.test(word)) {
            isValid = false;
            console.log('Password must have at least 2 digits')
        }
    }
}

solve('logIn');
solve('MyPass123');
solve('Pa$s$s');
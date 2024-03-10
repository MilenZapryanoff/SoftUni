function solve (digitOne, digitTwo, digitThree) {
    let resultString = `${digitOne}${digitTwo}${digitThree}`;
    console.log(resultString.split('').reverse().join(' '));
}


solve ('A','B','C');
solve ('1','L','&');

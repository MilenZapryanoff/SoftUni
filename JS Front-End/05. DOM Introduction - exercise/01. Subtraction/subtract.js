function subtract() {
    let firstElement = Number(document.getElementById('firstNumber').value);
    let secondElement = Number(document.getElementById('secondNumber').value);
    let resultElement = document.getElementById('result');

    console.log(firstElement)
    console.log(secondElement)

    resultElement.textContent = (firstElement - secondElement).toString();
}
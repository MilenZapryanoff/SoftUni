function deleteByEmail() {
    let tableRowElement = document.querySelectorAll('tr td');
    let inputElement = document.querySelector('input[name=email]');
    let resultElement = document.getElementById('result');

    let recordFound = false;

    for (const element of tableRowElement) {
        if (element.textContent === inputElement.value) {
            element.parentElement.remove();
            inputElement.value = '';
            recordFound = true;
        }

        if (recordFound) {
            resultElement.textContent = 'Deleted.'
        } else {
            if (inputElement.value.length > 0) {
                resultElement.textContent = 'Not found.'
            }
        }
    }
}
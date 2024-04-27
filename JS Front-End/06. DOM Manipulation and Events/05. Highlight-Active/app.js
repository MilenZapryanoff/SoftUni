function focused() {
    let inputFieldsElements = document.querySelectorAll('input');

    for (const inputFieldsElement of inputFieldsElements) {
        inputFieldsElement.addEventListener('focus', () => {
            inputFieldsElement.parentElement.classList.add('focused');
        })
    }

    for (const inputFieldsElement of inputFieldsElements) {
        inputFieldsElement.addEventListener('blur', () => {
            inputFieldsElement.parentElement.classList.remove('focused');
        })
    }
}
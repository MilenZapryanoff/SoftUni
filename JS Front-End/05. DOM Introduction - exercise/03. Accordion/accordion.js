function toggle() {
    let additionalTextElement = document.querySelector('#extra');
    let buttonElement = document.querySelector('.button');

    switch (buttonElement.textContent) {
        case 'More':
            additionalTextElement.style.display = 'block';
            buttonElement.textContent = 'Less'
            break;
        case 'Less':
            additionalTextElement.style.display = 'none';
            buttonElement.textContent = 'More'
            break;
    }
}
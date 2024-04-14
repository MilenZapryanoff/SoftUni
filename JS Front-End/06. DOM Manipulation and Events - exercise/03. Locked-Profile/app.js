function lockedProfile() {
    let buttonsElements = document.querySelectorAll('.profile button');

    Array.from(buttonsElements)
        .forEach(button => button.addEventListener('click', () => {
            let lockedStatusElement = button.parentElement.querySelector('input[value=lock]');

            if (!lockedStatusElement.checked) {
                if (button.textContent === 'Show more') {
                    button.previousElementSibling.style.display = 'block'
                    button.textContent = 'Hide it'
                } else {
                    button.previousElementSibling.style.display = 'none'
                    button.textContent = 'Show more'
                }
            }
        }))
}
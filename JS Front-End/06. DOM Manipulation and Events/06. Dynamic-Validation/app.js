function validate() {
    let emailInputElement = document.getElementById('email');

    const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;

    emailInputElement.addEventListener("change", () => {
        if (!emailPattern.test(emailInputElement.value)) {
            emailInputElement.classList.add('error')
        } else {
            emailInputElement.classList.remove('error')
        }
    })

}
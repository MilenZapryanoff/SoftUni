function attachEventsListeners() {
    let buttonsElements = document.querySelectorAll('input[type=button]');

    let daysInputElement = document.getElementById('days');
    let hoursInputElement = document.getElementById('hours');
    let minutesInputElement = document.getElementById('minutes');
    let secondsInputElement = document.getElementById('seconds');

    let timeInSeconds = 0;

    Array.from(buttonsElements)
        .forEach(button => button.addEventListener('click', () => {
            let relatedInputFieldElement = button.parentElement.querySelector('input[type=text]');
            let idAttribute = relatedInputFieldElement.getAttribute('id');
            let relatedInputFieldElementValue = relatedInputFieldElement.value;

            if (relatedInputFieldElementValue > 0) {
                switch (idAttribute) {
                    case 'days':
                        timeInSeconds = relatedInputFieldElementValue * 86400
                        console.log(timeInSeconds)
                        break;
                    case 'hours':
                        timeInSeconds = relatedInputFieldElementValue * 3600
                        console.log(timeInSeconds)
                        break;
                    case 'minutes':
                        timeInSeconds = relatedInputFieldElementValue * 60
                        console.log(timeInSeconds)
                        break;
                    case 'seconds':
                        timeInSeconds = relatedInputFieldElementValue
                        console.log(timeInSeconds)
                        break;
                }
                daysInputElement.value = timeInSeconds / 86400;
                hoursInputElement.value = timeInSeconds / 3600;
                minutesInputElement.value = timeInSeconds / 60;
                secondsInputElement.value = timeInSeconds
            }
        }))
}
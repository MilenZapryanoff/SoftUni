function create(words) {
    let contentElement = document.getElementById('content');

    for (const word of words) {
        let newDivElement = document.createElement('div');

        let newPElement = document.createElement('p');
        newPElement.textContent = word.toString();
        newPElement.style.display = 'none'

        newDivElement.appendChild(newPElement);
        contentElement.appendChild(newDivElement)
    }

    Array.from(document.querySelectorAll('#content div'))
        .forEach(e => e.addEventListener('click', () => {
            e.firstChild.style.display = 'block'
        }))
}
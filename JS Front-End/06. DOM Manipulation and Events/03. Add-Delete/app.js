function addItem() {

    let newInputElement = document.getElementById('newItemText');
    let ulElement = document.getElementById('items');

    //Add button implementation

    let newElement = document.createElement('li');
    newElement.textContent = newInputElement.value;

    let newDeleteLink = document.createElement('a');
    newDeleteLink.textContent = '[Delete]'
    newDeleteLink.href = "#"
    newDeleteLink.addEventListener('click', () => {
        newDeleteLink.parentElement.remove();
    });

    newElement.appendChild(newDeleteLink);
    ulElement.appendChild(newElement).value

    newInputElement.value = '';
}
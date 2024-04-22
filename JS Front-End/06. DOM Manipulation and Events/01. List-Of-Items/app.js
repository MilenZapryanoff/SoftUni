function addItem() {
    let ulElement = document.getElementById('items');
    let inputElement = document.getElementById('newItemText');

    let newElement = document.createElement('li');
    newElement.textContent = inputElement.value;

    ulElement.appendChild(newElement)

    inputElement.value = '';
}
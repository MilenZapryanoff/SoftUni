function solve() {
    document.querySelector('#searchBtn').addEventListener('click', onClick);

    function onClick() {

        let tableRowsElements = document.querySelectorAll('tr');
        let searchElement = document.getElementById('searchField').value;
        let fieldsElements = document.querySelectorAll('td');

        //resetting class
        for (const field of fieldsElements) {
            field.parentElement.classList.remove('select');
        }

        if (searchElement.length > 0) {
            for (const field of fieldsElements) {
                if (field.textContent.includes(searchElement)) {
                    field.parentElement.classList.add('select');
                }
            }
        }
    }
}
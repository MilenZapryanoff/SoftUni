function search() {

    let townListElement = document.querySelectorAll('#towns li');
    let searchElement = document.getElementById('searchText').value;
    let resultElement = document.getElementById('result');
    let counter = 0;

    //resetting font decorations
    for (const town of townListElement) {
        town.style.textDecoration = 'none'
        town.style.fontWeight = 'normal'
        resultElement.textContent = ''
    }

    if (searchElement.length > 0) {
        for (const town of townListElement) {
            if (town.textContent.includes(searchElement)) {
                town.style.textDecoration = 'underline'
                town.style.fontWeight = 'bold'
                counter++;
            }
        }
        if (counter > 0) {
            resultElement.textContent = counter + ' matches found'
        }
    }
}

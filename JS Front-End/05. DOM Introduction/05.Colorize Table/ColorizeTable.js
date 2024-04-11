function colorize() {
    let nodeListElements = document.querySelectorAll('tr:nth-child(2N)');

    for (const element of nodeListElements) {
        element.style.backgroundColor = 'Teal'
    }
}
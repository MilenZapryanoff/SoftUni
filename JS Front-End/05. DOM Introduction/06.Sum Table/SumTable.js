function sumTable() {
    let amounts = document.querySelectorAll('td:nth-child(2N)');

    let sum = 0;
    for (const amount of amounts) {
        sum += Number(amount.textContent);
    }

    document.getElementById('sum').textContent = sum.toString();
}
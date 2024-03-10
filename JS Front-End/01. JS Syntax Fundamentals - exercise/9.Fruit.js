function solve (fruit, weight, price) {
    
    let kilograms = weight/1000;
    let totalCost = kilograms * price;

    console.log(`I need $${totalCost.toFixed(2)} to buy ${kilograms.toFixed(2)} kilograms ${fruit}.`);
}


solve ('orange', 2500, 1.80);
solve ('apple', 1563, 2.35);
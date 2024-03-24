function solve(product, quantity) {

    let result = (returnPrice(product) * quantity).toFixed(2);
    console.log(result)

    function returnPrice(product) {
        switch (product) {
            case 'coffee':
                return 1.50;
            case 'water':
                return 1.00;
            case 'coke':
                return 1.40;
            case 'snacks':
                return 2.00;
        }
    }
}

solve("water", 5);
solve("coffee", 2);
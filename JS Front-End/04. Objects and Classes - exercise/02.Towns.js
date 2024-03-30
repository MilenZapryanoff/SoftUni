function solve(input) {
    for (const inputElement of input) {
        let [town, latitude, longitude] = inputElement.split(' | ')

        let city = {};

        city.town = town;
        city.latitude = Number.parseFloat(latitude).toFixed(2)
        city.longitude = Number.parseFloat(longitude).toFixed(2)

        console.log(city)
    }
}



solve (['Sofia | 42.696552 | 23.32601',
    'Beijing | 39.913818 | 116.363625']
);
solve (['Plovdiv | 136.45 | 812.575']);

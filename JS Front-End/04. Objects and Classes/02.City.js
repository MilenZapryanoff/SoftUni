function solve(city) {

    let entries = Object.entries(city);
    let counter = entries.length;

    for (let i = 0; i < counter; i++) {
        let currentEntry = entries.shift();

        let propertyName = currentEntry.shift();
        let propertyValue = currentEntry.shift();

        console.log(propertyName + ' -> ' + propertyValue)
    }
}

solve({
        name: "Sofia",
        area: 492,
        population: 1238438,
        country: "Bulgaria",
        postCode: "1000"
    }
)


solve(
    {
        name: "Plovdiv",
        area: 389,
        population: 1162358,
        country: "Bulgaria",
        postCode: "4000"
    }
)
function solve(jsonInput) {

    let person = JSON.parse(jsonInput);

    let keys = Object.keys(person);
    for (const key of keys) {
        console.log(key + ': ' + person[key])
    }

    // Object.keys(person)
    //     .forEach(key => console.log(key + ':' + person[key]))

}


solve('{"name": "George", "age": 40, "town": "Sofia"}')
solve('{"name": "Peter", "age": 35, "town": "Plovdiv"}')
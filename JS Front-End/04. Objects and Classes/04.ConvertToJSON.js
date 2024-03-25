function solve(...input) {

    let personInfo = {
        name: input[0],
        lastName: input[1],
        hairColor: input[2]
    }

    let result = JSON.stringify(personInfo);

    //js object
    // console.log(personInfo)

    //json
    console.log(result)
}


solve('George', 'Jones', 'Brown');
solve('Peter', 'Smith', 'Blond');
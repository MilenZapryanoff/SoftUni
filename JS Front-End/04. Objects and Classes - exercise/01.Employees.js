function solve(input) {

    let employees = {};

    for (const inputEmployee of input) {
        employees[inputEmployee] = inputEmployee.length
    }

    for (const employee in employees) {
        console.log(`Name: ${employee} -- Personal Number: ${employees[employee]}`)
    }
}



solve ([
        'Silas Butler',
        'Adnaan Buckley',
        'Juan Peterson',
        'Brendan Villarreal'
    ]
);
solve ([
        'Samuel Jackson',
        'Will Smith',
        'Bruce Willis',
        'Tom Holland'
    ]
);

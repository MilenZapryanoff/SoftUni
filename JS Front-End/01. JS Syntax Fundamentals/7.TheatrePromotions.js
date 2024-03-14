function solve (typeOfDay, age) {
    
    let price;
    
    if (typeOfDay === 'Weekday') {
        if (age >= 0 && age <= 18) {
            price = 12;
        } else if (age >= 18 && age <= 64) {
            price = 18;
        } else if (age >= 64 && age <= 122) {
            price = 12;
        }
        
    } else if (typeOfDay === 'Weekend') {
        if (age >= 0 && age <= 18) {
            price = 15;
        } else if (age >= 18 && age <= 64) {
            price = 20;
        } else if (age >= 64 && age <= 122) {
            price = 15;
        }
    } else if (typeOfDay === 'Holiday') {
        if (age >= 0 && age <= 18) {
            price = 5;
        } else if (age >= 18 && age <= 64) {
            price = 12;
        } else if (age >= 64 && age <= 122) {
            price = 10;
        } 
    }
    
    if (price < 0 || price == undefined) {
        console.log('Error!');
    } else {
        console.log(`${price}$`);
    }
}


solve ('Weekday', 42);
solve ('Holiday', -12);
solve ('Holiday', 15);
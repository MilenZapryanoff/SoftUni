function solve (peopleCount, type, day) {
    
    let price = 0;
    let totalPrice = 0;
    
    if (day === 'Friday') {
        if (type==='Students') {
            price = 8.45;
            if (peopleCount >= 30) {
                totalPrice = price * peopleCount * 0.85
            } else {
                totalPrice = price * peopleCount
            }
        } else if (type==='Business') {
            price = 10.90;
            if (peopleCount >= 100) {
                totalPrice = (price * peopleCount) - (price * 10)
            } else {
                totalPrice = price * peopleCount
            }
            
        } else if (type==='Regular') {
            price = 15;
            if (peopleCount >= 10 && peopleCount <= 20) {
                totalPrice = price * peopleCount * 0.95
            } else {
                totalPrice = price * peopleCount
            }
        }
    } else if (day === 'Saturday') {
        if (type==='Students') {
            price = 9.80;
            if (peopleCount >= 30) {
                totalPrice = price * peopleCount * 0.85
            } else {
                totalPrice = price * peopleCount
            }
        } else if (type==='Business') {
            price = 15.60;
            if (peopleCount >= 100) {
                totalPrice = (price * peopleCount) - (price * 10)
            } else {
                totalPrice = price * peopleCount
            }
            
        } else if (type==='Regular') {
            price = 20;
            if (peopleCount >= 10 && peopleCount <= 20) {
                totalPrice = price * peopleCount * 0.95
            } else {
                totalPrice = price * peopleCount
            }
        }
    } else if (day === 'Sunday') {
        if (type==='Students') {
            price = 10.46;
            if (peopleCount >= 30) {
                totalPrice = price * peopleCount * 0.85
            } else {
                totalPrice = price * peopleCount
            }
        } else if (type==='Business') {
            price = 16;
            if (peopleCount >= 100) {
                totalPrice = (price * peopleCount) - (price * 10)
            } else {
                totalPrice = price * peopleCount
            }
            
        } else if (type==='Regular') {
            price = 22.50;
            if (peopleCount >= 10 && peopleCount <= 20) {
                totalPrice = price * peopleCount * 0.95
            } else {
                totalPrice = price * peopleCount
            }
        }
    }
    console.log(`Total price: ${totalPrice.toFixed(2)}`)
}


solve (30,"Students","Sunday");
solve (40,"Regular","Saturday");

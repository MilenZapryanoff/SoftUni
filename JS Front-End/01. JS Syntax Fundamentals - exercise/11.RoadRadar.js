function solve (speed, area) {
    let speedLimit = 0;
    
    if (area === 'residential') {
        speedLimit = 20;
    } else if (area === 'city') {
        speedLimit = 50;
    } else if (area === 'interstate') {
        speedLimit = 90;
    } else if (area === 'motorway') {
        speedLimit = 130;
    }
    
    if (speed <= speedLimit) {
        console.log(`Driving ${speed} km/h in a ${speedLimit} zone`);
    } else {
        speedDiff = speed - speedLimit;
        
        if (speedDiff > 0 && speedDiff <= 20) {
            console.log(`The speed is ${speedDiff} km/h faster than the allowed speed of ${speedLimit} - speeding`);
        } else if (speedDiff > 20 && speedDiff <= 40) {
            console.log(`The speed is ${speedDiff} km/h faster than the allowed speed of ${speedLimit} - excessive speeding`);
        }  else {
            console.log(`The speed is ${speedDiff} km/h faster than the allowed speed of ${speedLimit} - reckless driving`);
        }
    }
}


solve(40, 'city');
solve(21, 'residential');
solve(120, 'interstate');
solve(200, 'motorway');
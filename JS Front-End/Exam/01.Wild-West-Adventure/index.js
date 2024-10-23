<<<<<<< HEAD
function solve(input) {
    let posse = [];

    // Parse character information
    let n = parseInt(input[0]);
    for (let i = 1; i <= n; i++) {
        posse.push(parseCharacterInfo(input[i]));
    }

    // Process commands
    let commandLine = input.shift();

    while (commandLine !== 'Ride Off Into Sunset') {
        let [command, ...args] = commandLine.split(' - ');
        let characterName = args[0];
        
        let character = posse.find(member => member.name === characterName);
        switch (command) {
            case 'FireShot':
                fireShot(character, args[1]);
                break;
            case 'TakeHit':
                takeHit(character, parseInt(args[1]), args[2]);
                break;
            case 'Reload':
                reload(character);
                break;
            case 'PatchUp':
                patchUp(character, parseInt(args[1]));
                break;
        }

        commandLine = input.shift();
    }



    // Print the status of each character
    for (let character of posse) {
        console.log(`${character.name}\n HP: ${character.hp}\n Bullets: ${character.bullets}`);
    }

    function parseCharacterInfo(info) {
        let [name, hp, bullets] = info.split(' ');
        return { name, hp: parseInt(hp), bullets: parseInt(bullets) };
    }

    function fireShot(character, target) {
        if (character.bullets > 0) {
            character.bullets--;
            console.log(`${character.name} has successfully hit ${target} and now has ${character.bullets} bullets!`);
        } else {
            console.log(`${character.name} doesn't have enough bullets to shoot at ${target}!`);
        }
    }

    function takeHit(character, damage, attacker) {
        character.hp -= damage;
        if (character.hp > 0) {
            console.log(`${character.name} took a hit for ${damage} HP from ${attacker} and now has ${character.hp} HP!`);
        } else {
            console.log(`${character.name} was gunned down by ${attacker}!`);
            posse = posse.filter(member => member.name !== character.name);
        }
    }

    function reload(character) {
        if (character.bullets < 6) {
            let bulletsReloaded = 6 - character.bullets;
            character.bullets = 6;
            console.log(`${character.name} reloaded ${bulletsReloaded} bullets!`);
        } else {
            console.log(`${character.name}'s pistol is fully loaded!`);
        }
    }

    function patchUp(character, amount) {
        if (character.hp === 100) {
            console.log(`${character.name} is in full health!`)
        } else {
             let maxHP = 100;
        let recovered = Math.min(maxHP - character.hp, amount);
        character.hp += recovered;
        console.log(`${character.name} patched up and recovered ${recovered} HP!`); 
        }
      
    }
}



// solve((["2",
//     "Gus 100 0",
//     "Walt 100 6",
//     "FireShot - Gus - Bandit",
//     "TakeHit - Gus - 100 - Bandit",
//     "Reload - Walt",
//     "Ride Off Into Sunset"])
// );

// solve ((["2",
//     "Jesse 100 4",
//     "Walt 100 5",
//     "FireShot - Jesse - Bandit",
//     "TakeHit - Walt - 30 - Bandit",
//     "PatchUp - Walt - 20" ,
//     "Reload - Jesse",
//     "Ride Off Into Sunset"])
// )

solve((["2",
    "Gus 100 4",
    "Walt 100 5",
    "FireShot - Gus - Bandit",
    "TakeHit - Walt - 100 - Bandit",
    "Reload - Gus",
    "Ride Off Into Sunset"])
=======
function solve(input) {
    let posse = [];

    // Parse character information
    let n = parseInt(input[0]);
    for (let i = 1; i <= n; i++) {
        posse.push(parseCharacterInfo(input[i]));
    }

    // Process commands
    let commandLine = input.shift();

    while (commandLine !== 'Ride Off Into Sunset') {
        let [command, ...args] = commandLine.split(' - ');
        let characterName = args[0];
        
        let character = posse.find(member => member.name === characterName);
        switch (command) {
            case 'FireShot':
                fireShot(character, args[1]);
                break;
            case 'TakeHit':
                takeHit(character, parseInt(args[1]), args[2]);
                break;
            case 'Reload':
                reload(character);
                break;
            case 'PatchUp':
                patchUp(character, parseInt(args[1]));
                break;
        }

        commandLine = input.shift();
    }



    // Print the status of each character
    for (let character of posse) {
        console.log(`${character.name}\n HP: ${character.hp}\n Bullets: ${character.bullets}`);
    }

    function parseCharacterInfo(info) {
        let [name, hp, bullets] = info.split(' ');
        return { name, hp: parseInt(hp), bullets: parseInt(bullets) };
    }

    function fireShot(character, target) {
        if (character.bullets > 0) {
            character.bullets--;
            console.log(`${character.name} has successfully hit ${target} and now has ${character.bullets} bullets!`);
        } else {
            console.log(`${character.name} doesn't have enough bullets to shoot at ${target}!`);
        }
    }

    function takeHit(character, damage, attacker) {
        character.hp -= damage;
        if (character.hp > 0) {
            console.log(`${character.name} took a hit for ${damage} HP from ${attacker} and now has ${character.hp} HP!`);
        } else {
            console.log(`${character.name} was gunned down by ${attacker}!`);
            posse = posse.filter(member => member.name !== character.name);
        }
    }

    function reload(character) {
        if (character.bullets < 6) {
            let bulletsReloaded = 6 - character.bullets;
            character.bullets = 6;
            console.log(`${character.name} reloaded ${bulletsReloaded} bullets!`);
        } else {
            console.log(`${character.name}'s pistol is fully loaded!`);
        }
    }

    function patchUp(character, amount) {
        if (character.hp === 100) {
            console.log(`${character.name} is in full health!`)
        } else {
             let maxHP = 100;
        let recovered = Math.min(maxHP - character.hp, amount);
        character.hp += recovered;
        console.log(`${character.name} patched up and recovered ${recovered} HP!`); 
        }
      
    }
}



// solve((["2",
//     "Gus 100 0",
//     "Walt 100 6",
//     "FireShot - Gus - Bandit",
//     "TakeHit - Gus - 100 - Bandit",
//     "Reload - Walt",
//     "Ride Off Into Sunset"])
// );

// solve ((["2",
//     "Jesse 100 4",
//     "Walt 100 5",
//     "FireShot - Jesse - Bandit",
//     "TakeHit - Walt - 30 - Bandit",
//     "PatchUp - Walt - 20" ,
//     "Reload - Jesse",
//     "Ride Off Into Sunset"])
// )

solve((["2",
    "Gus 100 4",
    "Walt 100 5",
    "FireShot - Gus - Bandit",
    "TakeHit - Walt - 100 - Bandit",
    "Reload - Gus",
    "Ride Off Into Sunset"])
>>>>>>> e39b9e061c27887df677e83dbda11ce96cdcc294
)
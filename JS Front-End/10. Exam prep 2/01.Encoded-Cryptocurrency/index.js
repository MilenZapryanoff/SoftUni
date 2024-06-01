function solve(input) {

    let message = input.shift();
    let commandLine = input.shift();

    while (commandLine !== 'Buy') {

        if (commandLine === 'TakeEven') {

            let resultString = ''

            for (let i = 0; i < message.length; i += 2) {
                resultString = resultString + message.charAt(i)
            }

            message = resultString;
            console.log(message);
        }
        if (commandLine.includes('ChangeAll')) {

            let commandLineArr = commandLine.split('?');
            let stringToChange = commandLineArr[1];
            let newString = commandLineArr[2];

            if (message.includes(stringToChange)) {
                //използвам while loop за да премахна всички намерени substring-ове
                while (message.includes(stringToChange)) {
                    message = message.replace(stringToChange, newString);
                }
            }
            console.log(message)

        }
        if (commandLine.includes('Reverse')) {

            let commandLineArr = commandLine.split('?');
            let stringToCut = commandLineArr[1];
            let reversedString = stringToCut.split('').reverse().join('');

            if (message.includes(stringToCut)) {

                //премахваме първия срещнат substring
                message = message.replace(stringToCut, '')
                //Прикачване отзад на reverse-натия string
                message += reversedString;

                console.log(message);

            } else {

                console.log('error')
            }
        }

        commandLine = input.shift();
    }
    console.log(`The cryptocurrency is: ${message}`)
}


// АВТОРСКО РЕШЕНИЕ

// function solve(input) {
//     const takeEven = (message) => {
//         let result = message.split('').filter((_, i) => i % 2 == 0).join('');
//
//         console.log(result);
//
//         return result;
//     }
//
//     const changeAll = (message, substring, replacement) => {
//         let result = message;
//
//         while (result.includes(substring)) {
//             result = result.replace(substring, replacement)
//         }
//
//         console.log(result);
//         return result;
//     };
//
//
//     const fancyChangeAll = (message, substring, replacement) => {
//         let result = message.replace(new RegExp(substring, 'g', replacement));
//
//         console.log(result);
//         return result;
//     };
//
//     const rayasFancyChangeAll = (message, substring, replacement) => {
//         const result = message.split(substring).join(replacement);
//
//         console.log(result);
//
//         return result;
//     };
//
//     const reverse = (message, substring) => {
//         if (!message.includes(substring)) {
//             console.log('error');
//
//             return message;
//         }
//
//         let result = message.replace(substring, '');
//
//         result += substring.split('').reverse().join('');
//
//         console.log(result);
//         return result;
//     };
//
//     let message = input.shift();
//     let line = input.shift();
//     while (line !== 'Buy') {
//         const [command, substring, replacement] = line.split('?');
//
//         switch (command) {
//             case 'TakeEven':
//                 message = takeEven(message);
//                 break;
//             case 'ChangeAll':
//                 message = changeAll(message, substring, replacement)
//                 break;
//             case 'Reverse':
//                 message = reverse(message, substring)
//                 break;
//         }
//
//         line = input.shift();
//     }
//
//     console.log(`The cryptocurrency is: ${message}`);
// }



solve((["z2tdsfndoctsB6z7tjc8ojzdngzhtjsyVjek!snfzsafhscs",
    "TakeEven",
    "Reverse?!nzahc",
    "ChangeAll?m?g",
    "Reverse?adshk",
    "ChangeAll?z?i",
    "Buy"])
);


solve((["PZDfA2PkAsakhnefZ7aZ", "TakeEven", "TakeEven", "TakeEven", "ChangeAll?Z?X", "ChangeAll?A?R", "Reverse?PRX", "Buy"]))

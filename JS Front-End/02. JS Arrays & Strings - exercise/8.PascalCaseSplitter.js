function solve(input) {
    let words = input.match(/[A-Z][a-z]*/g)
    console.log(words.join(', '))
}


solve('SplitMeIfYouCanHaHaYouCantOrYouCan');
solve('HoldTheDoor');
solve('ThisIsSoAnnoyingToDo');
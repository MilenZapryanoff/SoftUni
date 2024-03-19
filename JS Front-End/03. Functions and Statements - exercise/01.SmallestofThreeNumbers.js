function findSmallestNumber(...numbers) {

    let smallestNum = Number.MAX_SAFE_INTEGER;
    for (const num of numbers) {
        if (num < smallestNum) {
            smallestNum = num;
        }
    }
    console.log(smallestNum)
}

findSmallestNumber(2, 5, 3);
findSmallestNumber(600, 342, 123);
findSmallestNumber(25, 21, 4);
findSmallestNumber(2, 2, 2);



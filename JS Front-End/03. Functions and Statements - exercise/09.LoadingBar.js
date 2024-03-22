function solve(percentage) {

    if (percentage === 100) {
        console.log('100% Complete!')
        console.log('[%%%%%%%%%%]')
    } else {
        let percentageSymbolCount = percentage / 10;
        let progressBar = `${percentage}% [`;

        for (let i = 1; i <= 10; i++) {
            if (percentageSymbolCount > 0) {
                progressBar = `${progressBar}%`
                percentageSymbolCount--;
            } else {
                progressBar = `${progressBar}.`
                if (i === 10) {
                    progressBar = `${progressBar}]`
                }
            }
        }
        console.log(progressBar)
        console.log('Still loading...')
    }
}


solve(30);
solve(50);
solve(100);

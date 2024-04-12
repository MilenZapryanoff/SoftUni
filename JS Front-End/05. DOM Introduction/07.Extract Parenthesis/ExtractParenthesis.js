function extract(content) {

    let text = document.querySelector('#content').textContent;

    const regex = /\(([^)]+)\)/g;
    const matches = text.match(regex);

    const wordsInParentheses = matches.map(match => match.replace(/[()]/g, ''));

    let result = '';
    for (const word of wordsInParentheses) {
        result += word + '; '
    }
    return result;
}
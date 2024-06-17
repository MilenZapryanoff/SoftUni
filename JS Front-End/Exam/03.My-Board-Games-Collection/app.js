const baseUrl = 'http://localhost:3030/jsonstore/games'

const loadButtonElement = document.getElementById('load-games')
const gamesListElement = document.getElementById('games-list')
const formElement = document.getElementById('form');

const nameInputElement = document.getElementById('g-name')
const typeInputElement = document.getElementById('type')
const playersInputElement = document.getElementById('players')

const addButtonElement = document.getElementById('add-game')
const editButtonElement = document.getElementById('edit-game')


const loadGames = async () => {

    // Fetch all games
    const response = await fetch(baseUrl);
    const data = await response.json();

    // clear games list element
    gamesListElement.innerHTML = '';

    for (const game of Object.values(data)) {
        const changeButtonElement = document.createElement('button');
        changeButtonElement.textContent = 'Change';
        changeButtonElement.classList.add('change-btn');

        const deleteButtonElement = document.createElement('button');
        deleteButtonElement.textContent = 'Delete';
        deleteButtonElement.classList.add('delete-btn');

        const buttonContainerElement = document.createElement('div');
        buttonContainerElement.classList.add('buttons-container');
        buttonContainerElement.appendChild(changeButtonElement);
        buttonContainerElement.appendChild(deleteButtonElement);

        const namePElement = document.createElement('p')
        namePElement.textContent = game.name;
        const playersPElement = document.createElement('p')
        playersPElement.textContent = game.players;
        const typePElement = document.createElement('p')
        typePElement.textContent = game.type;

        const gameDetailsDivContainer = document.createElement('div');
        gameDetailsDivContainer.classList.add('content')
        gameDetailsDivContainer.appendChild(namePElement);
        gameDetailsDivContainer.appendChild(playersPElement);
        gameDetailsDivContainer.appendChild(typePElement);

        const gameContainer = document.createElement('div');
        gameContainer.classList.add('board-game');
        gameContainer.appendChild(gameDetailsDivContainer)
        gameContainer.appendChild(buttonContainerElement)

        gamesListElement.appendChild(gameContainer);


        // Attach on change
        changeButtonElement.addEventListener('click', () => {
            // save current game id
            formElement.setAttribute('data-id', game._id);

            //  populate input
            nameInputElement.value = game.name;
            typeInputElement.value = game.type;
            playersInputElement.value = game.players;
       
            // activate edit button
            editButtonElement.removeAttribute('disabled');

            // deactivate add button
            addButtonElement.setAttribute('disabled', 'disabled');

            // remove from list
            gameContainer.remove();
        });

        // Attach on delete
        deleteButtonElement.addEventListener('click', async () => {
            // delete http request
            await fetch(`${baseUrl}/${game._id}`, {
                method: 'DELETE'
            });

            // remove from list
            gameContainer.remove();
        });

    }
}

loadButtonElement.addEventListener('click', loadGames)


addButtonElement.addEventListener('click', async () => {
    // get input data
    const newGame = getInputData();

    // create post request
    const response = await fetch(baseUrl, {
        method: 'POST',
        headers: {
            'content-type': 'application/json',
        },
        body: JSON.stringify(newGame),
    });

    if (!response.ok) {
        return;
    }

    // clear input fields
    clearInputData();
    
    // load all gamess
    await loadGames();
});

editButtonElement.addEventListener('click', async () => {
    // get data from inputs
    const { name, type, players } = getInputData();

    // get game id
    const gameId = formElement.getAttribute('data-id');

    // make a put request
    const response = await fetch(`${baseUrl}/${gameId}`, {
        method: 'PUT',
        headers: {
            'content-type': 'application/json',
        },
        body: JSON.stringify({  
            _id: gameId,
            name,
            type,
            players,
        })
    });

    if (!response.ok) {
        return;
    }

    // deactivate edit button
    editButtonElement.setAttribute('disabled', 'disabled');

    // activate addbutton
    addButtonElement.removeAttribute('disabled');

    // clear currentGameId
    formElement.removeAttribute('data-id');

    // clear inputs fields
    clearInputData();
    
    // load games
    loadGames();
});


function getInputData() {
    const name = nameInputElement.value;
    const type = typeInputElement.value;
    const players = playersInputElement.value;

    return { name, type, players };
}

function clearInputData() {
    nameInputElement.value = '';
    typeInputElement.value = '';
    playersInputElement.value = '';
}

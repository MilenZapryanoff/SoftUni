window.addEventListener("load", solve);

function solve() {

    let placeInputElement = document.getElementById('place');
    let actionInputElement = document.getElementById('action');
    let personInputElement = document.getElementById('person');
    let addTaskButtonElement = document.getElementById('add-btn');
    let ulTasksElement = document.getElementById('task-list');
    let ulDoneElement = document.getElementById('done-list');

    addTaskButtonElement.addEventListener('click', () => {
        let place = `Place:${placeInputElement.value}`
        let action = `Action:${actionInputElement.value}`
        let person = `Person:${personInputElement.value}`

        if (placeInputElement.value.length > 0 && actionInputElement.value.length > 0 && personInputElement.value.length > 0) {
            let editButton = document.createElement('button');
            editButton.classList.add('edit');
            editButton.textContent = 'Edit'

            editButton.addEventListener('click', () => {

                placeInputElement.value = place.substring(6);
                actionInputElement.value = action.substring(7);
                personInputElement.value = person.substring(7)

                editButton.parentElement.parentElement.remove();
            })

            let doneButton = document.createElement('button');
            doneButton.classList.add('done');
            doneButton.textContent = 'Done'

            doneButton.addEventListener('click', () => {

                let doneLiElement = doneButton.parentElement.parentElement;
                doneLiElement.classList.remove('clean-task')

                doneButton.parentElement.remove();

                let deleteButton = document.createElement('button');
                deleteButton.classList.add('delete')
                deleteButton.textContent = 'Delete'

                deleteButton.addEventListener('click', () => {
                    deleteButton.parentElement.remove();
                })

                doneLiElement.appendChild(deleteButton);
                ulDoneElement.appendChild(doneLiElement);
            })

            let divButtonsContainer = document.createElement('div');
            divButtonsContainer.classList.add('buttons');
            divButtonsContainer.appendChild(editButton);
            divButtonsContainer.appendChild(doneButton);

            let placePElement = document.createElement('p');
            placePElement.textContent = place;
            let actionPElement = document.createElement('p');
            actionPElement.textContent = action
            let personPElement = document.createElement('p');
            personPElement.textContent = person;

            let articleContainer = document.createElement('article');
            articleContainer.appendChild(placePElement);
            articleContainer.appendChild(actionPElement);
            articleContainer.appendChild(personPElement);

            let liElement = document.createElement('li');
            liElement.classList.add('clean-task')
            liElement.appendChild(articleContainer);
            liElement.appendChild(divButtonsContainer);

            ulTasksElement.appendChild(liElement);

            clearInputFields();
        }
    })

    function clearInputFields() {
        placeInputElement.value = '';
        actionInputElement.value = '';
        personInputElement.value = '';
    }
}



// AUTHOR SOLUTION

// function solve() {
//     const placeInputElement = document.getElementById('place');
//     const actionInputElement = document.getElementById('action');
//     const personInputElement = document.getElementById('person');
//     const addButtonElement = document.getElementById('add-btn');
//     const taskListElement = document.getElementById('task-list');
//     const doneListElement = document.getElementById('done-list');
//
//     addButtonElement.addEventListener('click', () => {
//         // Get input information
//         const place = placeInputElement.value;
//         const action = actionInputElement.value;
//         const person = personInputElement.value;
//
//         // Create task elelment
//         const taskLiElement = createTaskElement(place, action, person);
//
//         // Add to task list
//         taskListElement.appendChild(taskLiElement);
//
//         // CLear input fields
//         clearInputs();
//     });
//
//     function createTaskElement(place, action, person) {
//         const editButtonElement = document.createElement('button');
//         editButtonElement.classList.add('edit');
//         editButtonElement.textContent = 'Edit';
//
//         const doneButtonElement = document.createElement('button');
//         doneButtonElement.classList.add('done');
//         doneButtonElement.textContent = 'Done';
//
//         const buttonsDivElement = document.createElement('div');
//         buttonsDivElement.classList.add('buttons');
//         buttonsDivElement.appendChild(editButtonElement);
//         buttonsDivElement.appendChild(doneButtonElement);
//
//         const placePElement = document.createElement('p');
//         placePElement.textContent = `Place:${place}`;
//         const actionPElement = document.createElement('p');
//         actionPElement.textContent = `Action:${action}`;
//         const personPElement = document.createElement('p');
//         personPElement.textContent = `Person:${person}`;
//
//         const articleElement = document.createElement('article');
//         articleElement.appendChild(placePElement);
//         articleElement.appendChild(actionPElement);
//         articleElement.appendChild(personPElement);
//
//         const taskLiElement = document.createElement('li');
//         taskLiElement.classList.add('clean-task');
//         taskLiElement.appendChild(articleElement);
//         taskLiElement.appendChild(buttonsDivElement);
//
//         // Event listeners
//         editButtonElement.addEventListener('click', () => {
//             // send to inputs
//             placeInputElement.value = place;
//             actionInputElement.value = action;
//             personInputElement.value = person;
//
//             // remove from tasks
//             taskLiElement.remove();
//         });
//
//         doneButtonElement.addEventListener('click', () => {
//             // remove buttons
//             buttonsDivElement.remove();
//
//             // add delete button
//             const deleteButtonElement = document.createElement('button');
//             deleteButtonElement.classList.add('delete');
//             deleteButtonElement.textContent = 'Delete';
//
//             taskLiElement.appendChild(deleteButtonElement);
//
//             // Add to done list
//             doneListElement.appendChild(taskLiElement);
//
//             deleteButtonElement.addEventListener('click', (e) => {
//                 // e.currentTarget.parentElement.remove();
//                 taskLiElement.remove();
//             });
//         });
//
//         return taskLiElement;
//     }
//
//     function clearInputs() {
//         placeInputElement.value = '';
//         actionInputElement.value = '';
//         personInputElement.value = '';
//     }
// }

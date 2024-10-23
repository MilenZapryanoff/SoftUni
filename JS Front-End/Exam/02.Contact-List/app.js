<<<<<<< HEAD
window.addEventListener("load", solve);

function solve() {
    const nameInputElement = document.getElementById('name');
    const numberInputElement = document.getElementById('phone');
    const categoryInputElement = document.getElementById('category');
    const addButtonElement = document.getElementById('add-btn');
    const ulListElement = document.getElementById('check-list');
    const ulContactListElement = document.getElementById('contact-list')

    addButtonElement.addEventListener('click', () => {
        const name = nameInputElement.value;
        const number = numberInputElement.value;
        const category = categoryInputElement.value;

        if (name.length > 0 && number.length > 0 && category.length > 0) {

            //create save button
            const saveButton = document.createElement('button');
            saveButton.classList.add('save-btn');

            saveButton.addEventListener('click', () => {
                const buttonLiParent = saveButton.parentElement.parentElement;

                ulContactListElement.appendChild(buttonLiParent);
                saveButton.parentElement.remove();

                const deleteButton = document.createElement('button');
                deleteButton.classList.add('del-btn')

                buttonLiParent.appendChild(deleteButton)

                deleteButton.addEventListener('click', () =>
                    deleteButton.parentElement.remove()
                )
            })

            //create edit button
            const editButton = document.createElement('button');
            editButton.classList.add('edit-btn');

            editButton.addEventListener('click', () => {
                nameInputElement.value = name;
                numberInputElement.value = number;
                categoryInputElement.value = category;

                editButton.parentElement.parentElement.remove();
            })

            //create div container for buttons and append them
            const buttonDivContainer = document.createElement('div');
            buttonDivContainer.classList.add('buttons');
            buttonDivContainer.appendChild(saveButton);
            buttonDivContainer.appendChild(editButton);

            const namePElement = document.createElement('p');
            namePElement.textContent = `name:${name}`
            const numberPElement = document.createElement('p');
            numberPElement.textContent = `phone:${number}`
            const categoryPElement = document.createElement('p');
            categoryPElement.textContent = `category:${category}`

            const articleElement = document.createElement('article')
            articleElement.appendChild(namePElement);
            articleElement.appendChild(numberPElement);
            articleElement.appendChild(categoryPElement);

            const liElement = document.createElement('li')
            liElement.appendChild(articleElement);
            liElement.appendChild(buttonDivContainer);

            ulListElement.appendChild(liElement);

            nameInputElement.value = '';
            numberInputElement.value = '';
            categoryInputElement.value = '';
        }
    })
}
=======
window.addEventListener("load", solve);

function solve() {
    const nameInputElement = document.getElementById('name');
    const numberInputElement = document.getElementById('phone');
    const categoryInputElement = document.getElementById('category');
    const addButtonElement = document.getElementById('add-btn');
    const ulListElement = document.getElementById('check-list');
    const ulContactListElement = document.getElementById('contact-list')

    addButtonElement.addEventListener('click', () => {
        const name = nameInputElement.value;
        const number = numberInputElement.value;
        const category = categoryInputElement.value;

        if (name.length > 0 && number.length > 0 && category.length > 0) {

            //create save button
            const saveButton = document.createElement('button');
            saveButton.classList.add('save-btn');

            saveButton.addEventListener('click', () => {
                const buttonLiParent = saveButton.parentElement.parentElement;

                ulContactListElement.appendChild(buttonLiParent);
                saveButton.parentElement.remove();

                const deleteButton = document.createElement('button');
                deleteButton.classList.add('del-btn')

                buttonLiParent.appendChild(deleteButton)

                deleteButton.addEventListener('click', () =>
                    deleteButton.parentElement.remove()
                )
            })

            //create edit button
            const editButton = document.createElement('button');
            editButton.classList.add('edit-btn');

            editButton.addEventListener('click', () => {
                nameInputElement.value = name;
                numberInputElement.value = number;
                categoryInputElement.value = category;

                editButton.parentElement.parentElement.remove();
            })

            //create div container for buttons and append them
            const buttonDivContainer = document.createElement('div');
            buttonDivContainer.classList.add('buttons');
            buttonDivContainer.appendChild(saveButton);
            buttonDivContainer.appendChild(editButton);

            const namePElement = document.createElement('p');
            namePElement.textContent = `name:${name}`
            const numberPElement = document.createElement('p');
            numberPElement.textContent = `phone:${number}`
            const categoryPElement = document.createElement('p');
            categoryPElement.textContent = `category:${category}`

            const articleElement = document.createElement('article')
            articleElement.appendChild(namePElement);
            articleElement.appendChild(numberPElement);
            articleElement.appendChild(categoryPElement);

            const liElement = document.createElement('li')
            liElement.appendChild(articleElement);
            liElement.appendChild(buttonDivContainer);

            ulListElement.appendChild(liElement);

            nameInputElement.value = '';
            numberInputElement.value = '';
            categoryInputElement.value = '';
        }
    })
}
>>>>>>> e39b9e061c27887df677e83dbda11ce96cdcc294
  
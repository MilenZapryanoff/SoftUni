function solve() {
    let productsElements = document.querySelectorAll('.product');
    let textAreaElement = document.querySelector('textarea');
    let checkoutButtonElement = document.querySelector('.checkout');
    let totalPrice = 0;
    let orderedItems = {};


    for (const product of productsElements) {
        let addButtonsElements = product.querySelectorAll('.product-add .add-product');
        const productName = product.querySelector('.product-details .product-title').textContent
        const productPrice = Number(product.querySelector('.product-line-price').textContent)

        for (const button of addButtonsElements) {
            button.addEventListener('click', () => {
                textAreaElement.value += `Added ${productName} for ${productPrice.toFixed(2)} to the cart.\n`;
                totalPrice += productPrice;
                orderedItems[productName] = true;
            })
        }
    }

    checkoutButtonElement.addEventListener('click', () => {

        //disable all 'Add' buttons
        let addButtonsElements = document.querySelectorAll('.product-add .add-product');
        for (const button of addButtonsElements) {
            button.disabled = 'disabled'
        }

        //create string with product names
        const productsList = Object.keys(orderedItems).join(', ');

        //add summarized message in textarea
        textAreaElement.value += `You bought ${productsList} for ${totalPrice.toFixed(2)}.`

        //disable 'Checkout' button
        checkoutButtonElement.disabled = 'disabled'
    })
}
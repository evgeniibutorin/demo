let infoSender = document.getElementById('infoSender');
let firstProduct = document.getElementById('firstProduct');
let secondProduct = document.getElementById('secondProduct');
let firstQuantity = document.getElementById('firstQuantity');
let secondQuantity = document.getElementById('secondQuantity');

const  request = new XMLHttpRequest();

const url = "quantity_manager?first_product=" + firstProduct +
    "&first_quantity=" + firstQuantity +
    "second_product=" + secondProduct +
    "&second_quantity=" + secondQuantity;



infoSender.onclick = function() {
    alert('Я работаю');
    request.open('GET', url);
    request.setRequestHeader('Content-Type', 'application/x-www-form-url');

    request.addEventListener("readystatechange", () => {
        if (request.readyState === 4 && request.status === 200) {

            console.log( request.responseText );
        }
    });
    request.send();
};



$(document).on('click', '[id^="cart-delete-button_"]', function() {

        let value=  $('#cart-message').val()
        if(value=="success"){
            Swal.fire({
                    position: 'top-end',
                    icon: 'success',
                    title: 'product has been deleted !',
                    showConfirmButton: false,
                    timer: 2500
                }

            )
        }else {
            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: 'Something went wrong!'
            })
        }


});




const insertItem=(item)=>{
    let arrayOfQte = getItems();
    arrayOfQte = [...arrayOfQte,item]
    setItems(arrayOfQte)
}
const updateItem=(item)=>{
    let arrayOfQte = getItems();


    const objectToUpdate = arrayOfQte.find((obj) => obj?.CodeArt == item?.CodeArt);

    if (objectToUpdate !== undefined) {
        objectToUpdate.Quantity = item.Quantity;
        setItems(arrayOfQte)
    }else{
        insertItem(item)
    }
}
const deleteItem = (codeArt) => {
    // Get the array of objects
    let arrayOfQte = getItems();

    // Find the object in the array where the CodeArt is equal to the specified CodeArt
    const objectToDelete = arrayOfQte.find((obj) => obj?.CodeArt == codeArt);

    // If the object is found, remove it from the array
    if (objectToDelete !== undefined) {
        arrayOfQte.splice(arrayOfQte.indexOf(objectToDelete), 1);
        setItems(arrayOfQte);
    }
};

const deleteAllItems=()=>{
    sessionStorage.clear()
}
const getItems=()=>{
    let arrayString = sessionStorage.getItem("arrayOfQuantities");
    const arrayOfQte = JSON.parse(arrayString);
    return arrayOfQte?arrayOfQte:[]
}
const setItems=(obj)=>{
    /* Syntax of obj :
    * [{
    *    CodeArt : 12,
    *    Quantity : 2
    * },{
    *    CodeArt : 12,
    *    Quantity : 2
    * }]
    * */
    const arrayString = JSON.stringify(obj);
    sessionStorage.setItem("arrayOfQuantities", arrayString, { expires: 30 });
}


const changedQuantity=(val,CodeArt)=>{
    let prix = $("#prix"+CodeArt)[0]
    const res = (val * prix.value).toFixed(2)
    $("#subTotal"+CodeArt)[0].innerHTML = res
    $(".qte"+CodeArt)[0].value = val
    updateItem({CodeArt:CodeArt,Quantity:val})
    calculateTotal()
}


const calculateTotal=()=>{
    const subTotalValues = $(".subTotal")
    let sum=0.0
    for(let i=0;i<subTotalValues.length;i++){
        let val = subTotalValues[i].innerHTML
        let valFloat = parseFloat(val)
        sum= sum + valFloat
    }
    $(".totalPrice")[0].innerHTML=sum.toFixed(2)
}
const changeQuantitiesFromsessionStorage=()=>{
    const allItems = getItems()
    let allNewItems = []

    const inputsQte = $(".numberstyle")

    //If we were in the cart page
    if(inputsQte.length){
        for(let i=0;i<inputsQte.length;i++){
            let codeArt = inputsQte[i].getAttribute("data-codeart")
            let oldVal = inputsQte[i].value
            const objectToGet = allItems.find((obj) => obj?.CodeArt == codeArt);
            if (objectToGet !== undefined) {
                const val = objectToGet.Quantity
                changedQuantity(val,codeArt)
                allNewItems.push({CodeArt: codeArt,Quantity:val})
            }else{
                changedQuantity(oldVal,codeArt)
                allNewItems.push({CodeArt: codeArt,Quantity:oldVal})
            }
        }
        setItems(allNewItems)
    }

}
$(document).ready(()=>{
    changeQuantitiesFromsessionStorage()
    checkAlreadyInCart()
    checkErrorCart()
})




/************/

const checkAlreadyInCart=()=>{
    const allArticles = $(".bottom-desc")
    //If we were in the product page
    if(allArticles){
        const allItems = getItems()
        console.log(allItems)
        for(let i=0;i<allArticles.length;i++){
            let codeArt = allArticles[i].getAttribute("data-codeart")
            const objectToGet = allItems.find((obj) => obj?.CodeArt == codeArt);
            if (objectToGet !== undefined) {
                allArticles[i].classList.add("AlreadyInCart")
            }else{
                allArticles[i].classList.remove("AlreadyInCart")
            }
        }
    }else{
        console.log("Nothing in the product list")
    }
}

const checkErrorCart=()=>{
    const inputMsgErr = $("#cart1-message")
    //If we were in the cart page
    if(inputMsgErr && inputMsgErr[0]){
        const str = inputMsgErr[0].value
        const arrayOfCodes = JSON.parse(str);
        if(arrayOfCodes?.length){
            var div = $(".invalid");
            var ul = $("<ul>");

            for(let i=0;i<arrayOfCodes.length;i++) {
                var li = $("<li>");
                let name = $(".name"+arrayOfCodes[i])[0].innerHTML
                li.text("Sorry, the product \""+name+"\" is currently out of stock or the quantity you requested is not available. Please try a lower quantity or check back later for availability.");
                ul.append(li);
            }


            div.append(ul);
        }
    }
}


/*************/



(function($) {
    console.log("Entred");

    $.fn.numberstyle = function(options) {
        var settings = $.extend({
            value: 0,
            step: undefined,
            min: undefined,
            max: undefined
        }, options);

        return this.each(function() {
            var input = $(this);

            var container = document.createElement("div");
            var btnAdd = document.createElement("div");
            var btnRem = document.createElement("div");
            var min = (settings.min) ? settings.min : input.attr("min");
            var max = (settings.max) ? settings.max : input.attr("max");
            var value = (settings.value) ? settings.value : parseFloat(input.val());

            container.className = "numberstyle-qty";
            btnAdd.className = (max && value >= max) ? "qty-btn qty-add disabled" : "qty-btn qty-add";
            btnAdd.innerHTML = "+";
            btnRem.className = (min && value <= min) ? "qty-btn qty-rem disabled" : "qty-btn qty-rem";
            btnRem.innerHTML = "-";

            input.wrap(container);
            input.closest(".numberstyle-qty").prepend(btnRem).append(btnAdd);

            $(document).off("click", ".qty-btn").on("click", ".qty-btn", function(e) {
                var input = $(this).siblings("input");
                var sibBtn = $(this).siblings(".qty-btn");
                var step = (settings.step) ? parseFloat(settings.step) : parseFloat(input.attr("step"));
                var min = (settings.min) ? settings.min : (input.attr("min")) ? input.attr("min") : undefined;
                var max = (settings.max) ? settings.max : (input.attr("max")) ? input.attr("max") : undefined;
                var oldValue = parseFloat(input.val());
                var newVal;

                if ($(this).hasClass("qty-add")) {
                    newVal = (oldValue >= max) ? oldValue : oldValue + step;
                    newVal = (newVal > max) ? max : newVal;

                    if (newVal == max) {
                        $(this).addClass("disabled");
                    }
                    sibBtn.removeClass("disabled");
                } else {
                    newVal = (oldValue <= min) ? oldValue : oldValue - step;
                    newVal = (newVal < min) ? min : newVal;

                    if (newVal == min) {
                        $(this).addClass("disabled");
                    }
                    sibBtn.removeClass("disabled");
                }

                input.val(newVal).trigger("change");
            });

            input.on("change", function() {
                var val = parseFloat(input.val());
                var min = (settings.min) ? settings.min : (input.attr("min")) ? input.attr("min") : undefined;
                var max = (settings.max) ? settings.max : (input.attr("max")) ? input.attr("max") : undefined;

                if (val > max) {
                    input.val(max);
                }

                if (val < min) {
                    input.val(min);
                }
            });
        });
    };

    $('.numberstyle').numberstyle();
})(jQuery);
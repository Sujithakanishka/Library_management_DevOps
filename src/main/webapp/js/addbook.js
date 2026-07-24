/**Add book javascript */
// Get the form
const addbookform = document.querySelector(".addbookdiv");

// When the form is submitted
addbookform.addEventListener("submit", function(event){

    // Get input values
    const bookName = document.getElementById("bookname").value;
    const author = document.getElementById("author").value;
    const category = document.getElementById("category").value;
    const quantity = document.getElementById("quantity").value;

    // Check empty fields
    if(bookName === "" || author === "" || category === "" || quantity === "")
    {
        alert("Please fill all the fields.");
        event.preventDefault();
        return;
    }


    console.log("Book Name :", bookName);
    console.log("Author :", author);
    console.log("Category :", category);
    console.log("Quantity :", quantity);

    

});


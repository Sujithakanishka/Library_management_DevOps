/**Return javascript */
// Get the form
const returnbookform = document.querySelector(".returnbook");

// When the form is submitted
if(returnbookform){
returnbookform.addEventListener("submit", function(event){

    // Get input values
    const borrowID = document.getElementById("borrowID").value;
    const returndate = document.getElementById("returndate").value;

    // Check empty fields
    if(borrowID === "" || returndate === "")
    {
        alert("Please fill all the fields.");
        return;
    }

    console.log("Borrow ID :", borrowID);
    console.log("Return Date :", returndate);

});
}

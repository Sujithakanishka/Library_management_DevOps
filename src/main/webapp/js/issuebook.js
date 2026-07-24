/** Issue Book javscript */
// Get the form
const issuebookform = document.querySelector(".issuebook");

// When the form is submitted
if (issuebookform ){
issuebookform .addEventListener("submit", function(event){


    // Get input values
    const studentid = document.getElementById("studentid").value;
    const bookID = document.getElementById("bookID").value;
    const borrowdate = document.getElementById("borrowdate").value;
    const returndate = document.getElementById("returndate").value;

    // Check empty fields
    if(studentid === "" || bookID === "" || borrowdate === "" || returndate === "")
    {
        alert("Please fill all the fields.");
        return;
    }

    //id in positive number
    if (studentid <= 0 || bookID <= 0) {
    alert("Please enter valid IDs.");
    return;
    }
   
    console.log("Student Id :", studentid);
    console.log("Book ID :", bookID);
    console.log("Borrow date:", borrowdate);
    console.log("Return date :", returndate);


});
}
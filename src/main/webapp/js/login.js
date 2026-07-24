/**Return javascript */
// Get the form
const loginform = document.querySelector(".login");

// When the form is submitted
if(loginform){
loginform.addEventListener("submit", function(event){

    // Get input values
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    console.log("username :", username);
    console.log("password :", password);


});
}

$('document').ready(function(){
    var password = document.getElementById("password");

    var confirm = document.getElementById("confirmPassword");

    function validatePassword(){
        if(password.value != confirm.value){
            confirm.setCustomValidity("Passwords Don't Match!");
        } else
            confirm.setCustomValidity("");
        }

    password.onchange = validatePassword;
    confirm.onkeyup = validatePassword;
});


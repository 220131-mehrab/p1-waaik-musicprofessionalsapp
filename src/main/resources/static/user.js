var welcomeMsg = 'Music Pros Finder App';
document.querySelector('h1').innerText = welcomeMsg;





function login() {
console.log("Logging in...")
    let customer = {
        "userName": document.getElementById("userName").value,
        "userEmail": document.getElementById("userEmail").value,
        "userPassword": document.getElementById("userPassword").value,
        "userCreditCard": document.getElementById("userCreditCard").value,

    }
    console.log(customer);
    fetch("/login", {
        method: "POST",
        headers: {
            'Accept': '/application/json',
            'Content-Type': '/application/json'
        },
        body: JSON.stringify(customer)
    }).then((result) => {
        if (result.status != 200) {
            throw new Error("Bad Server Response");
        }
       console.log(result.text());
       window.location.pathname= '/service.html';

    }).catch((error) => { console.log(error); });
        //console.log("Im here");



}


var welcomeMsg = 'Looking for Business?';
document.querySelector('h1').innerText = welcomeMsg;
//Fetching doGet
fetch('/pros').then(resp => resp.json()).then(pros => {
        document.querySelector('#pros').innerHTML = listPros(pros);
    }
);

function listPros(json) {
    return `${json.map(listPro).join('\n')}`;
};

let listPro = function(pro) {
    return '<p>' + pro.proId + ": " + pro.name + ": " + pro.profession + ": " + pro.email + ": " + pro.phoneNumber + ": " + pro.fee + '<button type=button onclick="postHired('+ pro.hId + ')">Hire</button></p>';
};



function postPros() {
    let pro = {
        "proId": document.getElementById("proId").value,
        "name": document.getElementById("name").value,
        "profession": document.getElementById("profession").value,
        "email": document.getElementById("email").value,
        "phoneNumber": document.getElementById("phoneNumber").value,
        "fee": document.getElementById("fee").value
    }

    console.log(pro);
    fetch("/pros", {
        method: "POST",
        headers: {
            'Accept': '/application/json',
            'Content-Type': '/application/json'
        },
        body: JSON.stringify(pro)
    }).then((result) => {
        if (result.status != 200) {
            throw new Error("Bad Server Response");
        }
       console.log(result.text());
     fetch('/pros').then(resp => resp.json()).then(pros => {
             document.querySelector('#pros').innerHTML = listPros(pros);
               })

    }).catch((error) => { console.log(error); });
        //console.log("Im here");
}
function postHired(hId, uId) {
    let hired = {
        "hId": hId,
        "uId": uId

    }

    //console.log(pro);
    fetch("/hired", {
        method: "POST",
        headers: {
            'Accept': '/application/json',
            'Content-Type': '/application/json'
        },
        body: JSON.stringify(hired)
    }).then((result) => {
        if (result.status != 200) {
            throw new Error("Bad Server Response");
        }
       console.log(result.text());
     fetch('/hired').then(resp => resp.json()).then(pros => {
             document.querySelector('#pros').innerHTML = listPros(pros);
               })

    }).catch((error) => { console.log(error); });
    //console.log("Im here");
    window.location.pathname='/hired.html';
}



let button = document.querySelector('button');
button.addEventListener('mouseenter', function() {
    button.textContent = "Submit";
})

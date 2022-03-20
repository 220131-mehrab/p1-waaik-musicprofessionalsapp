fetch('/user').then(resp => resp.json()).then(pros => {
        document.querySelector('#pros').innerHTML = listPros(pros);
    }
);

function listPros(json) {
    return `${json.map(listPro).join('\n')}`;
};

let listPro = function(pro) {
    return '<p>' + pro.proId + ": " + pro.name + ": " + pro.profession + ": " + pro.email + ": " + pro.phoneNumber + ": " + pro.fee;
};


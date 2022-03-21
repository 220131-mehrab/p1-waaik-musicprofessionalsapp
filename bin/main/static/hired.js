fetch('/pros').then(resp => resp.json()).then(pros => {
        document.querySelector('#hired').innerHTML = listPros(pros);
    }
);


function listPros(json) {
    return `${json.map(listPro).join('\n')}`;
};

let listPro = function(pro) {
    return '<p>' + pro.proId + ": " + pro.name + ": " + pro.profession + ": " + pro.email + ": " + pro.phoneNumber + ": " + pro.fee;
};


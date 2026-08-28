//------------------------JS-kode relatert til criminal-profile.html-------------------

//Hent navnet fra URL-en med JavaScript, etter at brukeren har trykket på "view Details"

const params = new URLSearchParams(window.location.search);

const firstName = params.get("firstName");
const lastName = params.get("lastName");

//Så må du hente riktig person fra backend

fetch("api/criminals")

.then(function (response){
    return response.json()
})
.then (function (data) {

    const criminal = data.find(function (person) {
        return person.firstName === firstName &&
            person.lastName === lastName;
    });
    showCriminalProfile(criminal)
})

function showCriminalProfile(data) {

    document.getElementById("name").innerText =
        data.firstName + " " + data.lastName;

    document.getElementById("profileImage").src =
        data.imageURL;

    document.getElementById("nationality").innerText =
        data.nationality;

    document.getElementById("gender").innerText =
        data.gender;

    document.getElementById("wantedByCountry").innerText =
        data.wantedByCountry;

    document.getElementById("charges").innerText =
        data.charges;
}



//------------------------JS-kode relatert til criminal-profile.html-------------------

//Hent navnet fra URL-en med JavaScript, etter at brukeren har trykket på "view Details"

const params = new URLSearchParams(window.location.search);

const firstName = params.get("firstName");
const lastName = params.get("lastName");

//Så må du hente riktig person fra backend

fetch("api/search")

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

    //CRIMINAL PROFILE

    document.getElementById("name").innerText =
        data.firstName + " " + data.lastName;


    const dates = document.querySelectorAll(".dod");
    dates.forEach(function (element) {
        element.innerText = data.dateOfBirth;
        }); //gå gjennom for hvert element.


    //Legg til age;

    document.getElementById("age").innerText = data.alder;


    const genders = document.querySelectorAll(".gender");
    genders.forEach(function (element) {
        element.innerText = data.gender;
    })

    const nationalities = document.querySelectorAll(".nationality");
    for (let i = 0; i <nationalities.length; i++) {
        nationalities[i].innerText = data.nationality;
    } //her bruker jeg for-løkke, i stedet for foreach.

    document.getElementById("pob").innerText =
        data.placeOfBirth;

    document.getElementById("aliases").innerText =
        data.aliases;

    document.getElementById("profileImage").src =
        data.imageURL;


    // PERSONAL INFORMATION

    document.getElementById("family-name").innerText =
        data.lastName;

    document.getElementById("first-name").innerText =
        data.firstName;

    // CRIMINAL INFORMATION

    document.getElementById("caseNr").innerText =
        data.caseNr

    document.getElementById("wantedByCountry").innerText =
        data.wantedByCountry;

    document.getElementById("charges").innerText =
        data.charges;


    //PHYSICAL DESCRIPTION

    document.getElementById("height").innerText =
        data.height;

    document.getElementById("weight").innerText =
        data.weight;

    document.getElementById("eye-color").innerText =
        data.eyeColor;

    document.getElementById("hair-color").innerText =
        data.hairColor;

    document.getElementById("distinguishing").innerText =
        data.distinguishing;


    //ADDITIONAL INFORMATION

    document.getElementById("language").innerText =
        data.language;

    document.getElementById("last-known-area").innerText =
        data.lastKnownArea;

    document.getElementById("note").innerText =
        data.note;


}


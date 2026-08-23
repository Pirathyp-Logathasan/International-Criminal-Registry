

window.onload = function () {
    getAllCriminals();
};

//Henter alle kriminelle
function getAllCriminals (){
    fetch("/api/criminals")
        .then (function (response) {
            return response.json();
        })
        .then (function (data) {
            showCriminals(data);

        });
}

// Henter verdiene brukeren har skrevet inn i søkeskjemaet, sender dem til API-et,
// mottar søkeresultatene og viser dem på nettsiden.

function searchData() {

    let firstName = document.getElementById("firstName").value;
    let lastName = document.getElementById("lastName").value;
    let nationality = document.getElementById("nationality").value;
    let gender = document.getElementById("gender").value;
    let wantedByCountry = document.getElementById("wantedByCountry").value;
    let charges = document.getElementById("charges").value;

    fetch("/api/search?" +
        //encodeURIComponent gjør teksten trygg å sende i en URL.
        // Den konverterer spesialtegn (som mellomrom, &, ?, =)
        // slik at serveren kan lese verdiene riktig uten feil
        "firstName=" + encodeURIComponent(firstName) +
        "&lastName=" + encodeURIComponent(lastName) +
        "&nationality=" + encodeURIComponent(nationality) +
        "&gender=" + encodeURIComponent(gender) +
        "&wantedByCountry=" + encodeURIComponent(wantedByCountry) +
        "&charges=" + encodeURIComponent(charges)
    )
        .then(function (response) {
            return response.json();

        })
        .then(function (data) {
            showCriminals(data);
        });
}
// Viser alle Bootstrap-kortene
function showCriminals (data) {

    let result = document.getElementById("result");
    result.innerHTML = "";

    for (let i = 0; i < data.length; i++) {
        // Lager et nytt div-element for hvert søkeresultat
        const div = document.createElement("div");

        //Fyller div-elementet med et Bootstrap card som viser personen sin informasjon

        div.innerHTML =
            '<div class="card" style="width: 18rem; ">' +

                '<img class="card-img-top" src="' + data[i].imageURL + '" alt="Profile image">' +

                '<div class="card-body">' +

            '<h5 class="card-title">' +
                data[i].firstName + ' ' + data[i].lastName +
            '</h5>' +

            '<p class="card-text">' +
                '<b>Nationality:</b> ' + data[i].nationality + '<br>' +
                '<b>Gender:</b> ' + data[i].gender + '<br>' +
                '<b>Wanted by:</b> ' + data[i].wantedByCountry + '<br>' +
                '<b>Charges:</b> ' + data[i].charges +
            '</p>' +
            //Sender info om personen vidre til criminal-profile.html
            '<a href="criminal-profile.html?firstName=' +
            encodeURIComponent(data[i].firstName) +
            '&lastName=' +
            encodeURIComponent(data[i].lastName) +
            '" class="btn btn-primary">View Details</a>' +
        '</div>' +
            '</div>';

        // Legger kortet inn på nettsiden under result-elementet
    result.appendChild(div);
    }
}












window.onload = function () {
    criminalProfile();
};

function fetchCriminalProfile() {
    fetch("/api/criminals")
        .then(function (response) {
            return response.json();
        })
        .then (function (data) {
            showCriminalInfo(data);
        });
}


function showCriminalInfo(data) {
    let info = document.getElementById("show-Criminal-Profile");

    const div = document.createElement("div");

    div.innerHTML =
        '<div class="profile-container">' +
        '<img class="Criminal-image" src="' + data[i].imageURL + '" alt="Criminal image">' +

        '<div class="Criminal-description">' +

        '<h5>' +
        data[i].firstName + ' ' + data[i].lastName +

        '<p>' +
        '<b>Nationality:</b> ' + data[i].nationality + '<br>' +
        '<b>Gender:</b> ' + data[i].gender + '<br>' +
        '<b>Wanted by:</b> ' + data[i].wantedByCountry + '<br>' +
        '<b>Charges:</b> ' + data[i].charges +
        '</p>' +
        '</div>' +
        '</div>';

    // Legger kortet inn på nettsiden under result-elementet
    result.appendChild(div);
}



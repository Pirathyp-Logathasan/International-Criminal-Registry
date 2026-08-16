

// Andre type Interpol Notices
const notice = {

    red: {
        title: "Red Notice",
        text: "To seek the location and arrest of persons wanted for prosecution or to serve a sentence.",
        image: "Images/Interpol-notices/INTERPOL_Red _Notice.jpg"
    },
    yellow: {
        title: "Yellow Notice",
        text: "To help locate missing persons, often minors, or to help identify persons who are unable to identify themselves.",
        image: "Images/Interpol-notices/INTERPOL_Yellow_Notice.jpg"
    },
    blue: {
        title: "Blue Notice",
        text: "To collect additional information about a person’s identity, location or activities in relation to a criminal investigation.",
        image: "Images/Interpol-notices/INTERPOL_Blue_Notice.jpg"
    },
    black: {
        title: "Black Notice",
        text: "To seek information on unidentified bodies.",
        image: "Images/Interpol-notices/INTERPOL_Black_Notice.png"
    },
    green: {
        title: "Green Notice",
        text: "To provide warning about a person’s criminal activities, where the person is considered to be a possible threat to public safety.",
        image: "Images/Interpol-notices/INTERPOL_Green_Notice.jpg"
    },
    orange: {
        title: "Orange Notice",
        text: "To warn of an event, a person, an object or a process representing a serious and imminent threat to public safety.",
        image: "Images/Interpol-notices/INTERPOL_Orange_Notice.jpg"
    },
    purple: {
        title: "Purple Notice",
        text: "To seek or provide information on modus operandi, objects, devices and concealment methods used by criminals.",
        image: "Images/Interpol-notices/INTERPOL_Purple_Notice.jpg"
    },
    silver: {
        title: "Silver Notice (pilot phase)",
        text: "To identify and trace criminal assets",
        image: "Images/Interpol-notices/INTERPOL_Silver_Notice.jpg"
    },
    UN: {
        title: "INTERPOL–United Nations Security Council Special Notice",
        text: "Issued for entities and individuals who are the targets of UN Security Council Sanctions Committees.",
        image: "Images/Interpol-notices/INTERPOL_UN_Notice.jpg"
    }

}

function showNotice (type) {

    const selectedNotice = notice [type];
    const info = document.getElementById(type + "-info")
    info.classList.toggle("show");

    const button = document.querySelectorAll(".notice-button");

    info.innerHTML = `
    <div class="notice-card">
    <img class="notice-img" src="${selectedNotice.image}" alt="Interpol notice">
      <div class="notice-body">
      <h2>${selectedNotice.title}</h2>
      <p>${selectedNotice.text}</p>
      </div>
      
    </div>`
}



    /*
    info.innerHTML = `
        <div class="card" style="width: 18rem;">
            <img src="${selectedNotice.image}" class="card-img-top" alt="Interpol notice">
                <div class="notice-card-body"">
                <h2 class="card-title">${selectedNotice.title}</h2>
                <p class="card-text">${selectedNotice.text}</p>
                </div>
    </div>`
}

*/

// -----------------------Image Slideshow(knapp)--------------------

const track = document.querySelector(".slider-track");
const slides = document.querySelectorAll(".slide");

let currentSlide = 0;

document.querySelector(".next").addEventListener("click", nextSlide);

function nextSlide() {

    currentSlide++;

    if (currentSlide >= slides.length) {
        currentSlide = 0;
    }

    /* Flytter slideren til riktig bilde*/
    track.style.transform = `translateX(-${currentSlide * 100}%)`;
}


document.querySelector(".prev").addEventListener("click", prevSlide);

function prevSlide() {
    currentSlide--;

    if (currentSlide < 0) {
        currentSlide = slides.length -1;
    }

    track.style.transform = `translateX(-${currentSlide * 100}%)`;
}

// -----------------------viser/skjuler navbar basert på scroll-retning--------------------


//Husker forrige scroll-posisjon
let forrigeScrollPosisjon = window.scrollY

const navbar = document.querySelector("nav");

//sjekker hver gang brukeren scroller
window.addEventListener("scroll", function () {

    //nåværende scroll-posisjon
    let nyScrollPosisjon = window.scrollY;

    //hvis vi scroller ned
    if (nyScrollPosisjon > forrigeScrollPosisjon && nyScrollPosisjon > 100) {
            navbar.style.transform = "translateY(-100%)"; // skjul navbar

    }
    //Hvis vi er helt øverst
        if (nyScrollPosisjon === 0) {
            navbar.style.transform = "translateY(0)";
        }

    //oppdaterer verdien for neste scroll
    forrigeScrollPosisjon = nyScrollPosisjon;
})


package com.example.demo.controller;

import com.example.demo.model.Criminal;
import com.example.demo.service.CriminalService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HomeController {
    private final CriminalService criminalService;

    public HomeController(CriminalService criminalService) {
        this.criminalService = criminalService;
    }

    //Henter alle criminals fra databasen
    @GetMapping("/getCriminals")
    public List<Criminal> getAllCriminals() {
        return criminalService.getAllCriminals();
    }

    @GetMapping("/search")
    public List<Criminal> search(
            // Tar imot søkekriterier fra URL-en.
            // required = false betyr at feltene er valgfrie,
            // så brukeren kan søke med ett eller flere kriterier.
            // Rett og slett er det helt OK om firstName ikke finnes i URL-en i det hele tatt.
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String nationality,
            @RequestParam(required = false) String gender,
            @RequestParam(required = false) String wantedByCountry,
            @RequestParam(required = false) String charges) {

        // Lager en tom liste hvor alle kriminelle som matcher søket skal lagres.
        List<Criminal> result = new ArrayList<>();

        // Vi går gjennom hele lista, hver person sjekkes en og en
        for (Criminal criminal : getAllCriminals()) {

            boolean match = true;

            // Hvis brukeren har skrevet inn et fornavn
            if (firstName != null && !firstName.isEmpty()) {
                // Sjekker om personens fornavn inneholder søket brukeren skrev
                // Begge gjøres om til små bokstaver slik at "John" og "john" blir behandlet likt
                if (!criminal.getFirstName().toLowerCase().contains(firstName.toLowerCase())) {
                    // Hvis fornavnet ikke passer, er personen ikke en match
                    match = false;
                }
            }
            // Hvis brukeren har skrevet inn et etternavn
            if (lastName != null && !lastName.isEmpty()) {
                // Sjekker om personens etternavn matcher søket
                if (!criminal.getLastName().toLowerCase().contains(lastName.toLowerCase())) {
                    match = false;
                }
            }

            // Hvis brukeren har valgt eller skrevet inn en nasjonalitet
            if (nationality != null && !nationality.isEmpty()) {
                // Sjekker om personens nasjonalitet matcher søket
                if (!criminal.getNationality().toLowerCase().contains(nationality.toLowerCase())) {
                    match = false;
                }
            }
            //Hvis brukeren har valgt kjønn
            if (gender != null && !gender.isEmpty()) {
                // Sjekker om personens kjønn matcher søket
                if (!criminal.getGender().equalsIgnoreCase(gender)) {
                    match = false;
                }
            }
            // Hvis brukeren har skrevet inn hvilket land personen er etterlyst av
            if (wantedByCountry != null && !wantedByCountry.isEmpty()) {
                // Sjekker om landet personen er etterlyst av matcher søket
                if (!criminal.getWantedByCountry().toLowerCase().contains(wantedByCountry.toLowerCase())) {
                    match = false;
                }
            }
            // Hvis brukeren har skrevet inn et nøkkelord (f.eks. fraud eller hacking)
            if (charges != null && !charges.isEmpty()) {
                // Sjekker om personens nøkkelord inneholder søket
                if (!criminal.getCharges().toLowerCase().contains(charges.toLowerCase())) {
                    match = false;
                }
            }
            // Hvis alle feltene som er fylt ut stemmer, legg til personen.
            if (match) {
                result.add(criminal);
            }
        }
        // Returnerer listen med alle personer som passerte søket
        return result;
    }



    //Lagre en ny criminal
    @PostMapping ("/criminals")
    public Criminal createCriminal (@RequestBody Criminal criminal) {
        return criminalService.saveCriminal(criminal);
    }


}

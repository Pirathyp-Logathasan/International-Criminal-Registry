package com.example.demo;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HomeController {

    private List<Criminal> criminals = List.of(
            new Criminal("John", "Miller", "USA", "Male", "USA", "Fraud", "Images/Criminals/John_Miller.png"),
            new Criminal("Amina", "Hassan", "Somalia", "Female", "Norway", "Smuggling", "Images/Criminals/Amina_Hassan.png"),
            new Criminal("Lars", "Johansen", "Norway", "Male", "Sweden", "Theft", "Images/Criminals/Lars_Johansen.png"),
            new Criminal("Maria", "Gomez", "Spain", "Female", "Spain", "Cybercrime", "Images/Criminals/Maria_Gomez.png"),
            new Criminal("Chen", "Wei", "China", "Male", "USA", "Hacking", "Images/Criminals/Chen_Wei.png"),
            new Criminal("Ahmed", "Khan", "Pakistan", "Male", "UK", "Terrorism", "Images/Criminals/Ahmed_Khan.png"),
            new Criminal("Elena", "Popescu", "Romania", "Female", "Germany", "Identity theft", "Images/Criminals/Elena_Popescu.png"),
            new Criminal("David", "Smith", "UK", "Male", "Canada", "Drug trafficking", "Images/Criminals/David_Smith.png")
    );

    @GetMapping("/search")
    public List<Criminal> search(
            // Tar imot søkekriterier fra URL-en.
            // required = false betyr at feltene er valgfrie,
            // så brukeren kan søke med ett eller flere kriterier.
            // Rett og slett er det helt OK om firstName ikke finnes i URL-en i det hele tatt.
            @RequestParam (required = false) String firstName,
            @RequestParam (required = false) String lastName,
            @RequestParam (required = false) String nationality,
            @RequestParam (required = false) String gender,
            @RequestParam (required = false) String wantedByCountry,
            @RequestParam (required = false) String charges) {

        // Lager en tom liste hvor alle kriminelle som matcher søket skal lagres.
        List<Criminal> result = new ArrayList<>();

        // Vi går gjennom hele lista, hver person sjekkes en og en
        for (Criminal criminal : criminals) {

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
            if (gender !=null && !gender.isEmpty()) {
                // Sjekker om personens kjønn matcher søket
                if (!criminal.getGender().toLowerCase().contains(gender.toLowerCase())) {
                    match = false;
                }
            }
            // Hvis brukeren har skrevet inn hvilket land personen er etterlyst av
            if (wantedByCountry !=null && !wantedByCountry.isEmpty()) {
                // Sjekker om landet personen er etterlyst av matcher søket
                if (!criminal.getWantedByCountry().toLowerCase().contains(wantedByCountry.toLowerCase())) {
                    match = false;
                }
            }
            // Hvis brukeren har skrevet inn et nøkkelord (f.eks. fraud eller hacking)
            if (charges !=null && !charges.isEmpty()) {
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

    // Henter informasjon om alle kriminelle før brukeren har angitt søkekriterier.
    @GetMapping("/criminals")
    public List <Criminal> getAllCriminals () {
        return criminals;
    }
}

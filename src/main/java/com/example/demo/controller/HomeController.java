package com.example.demo.controller;



import com.example.demo.model.Criminal;
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
            new Criminal(
                    "John", "Miller", "1987-04-12",
                    "Male", "American", "Chicago, USA",
                    "John 'Mike' Miller", "Images/Criminals/John_Miller.png",

                    "USA", "ICR-2026-001", "Fraud",
                    "183 cm", "82 kg", "Brown", "Black",
                    "Scar above left eyebrow",

                    "English", "New York, USA",
                    "Suspected of large-scale financial fraud."),

            new Criminal(
                    "Amina", "Hassan", "1992-09-21", "Female", "Somali",
                    "Mogadishu, Somalia", "Amina Ali",
                    "Images/Criminals/Amina_Hassan.png",

                    "Norway", "ICR-2026-002", "Smuggling",

                    "168 cm", "64 kg", "Brown", "Black",
                    "Small scar on right hand",

                    "Somali, English, Norwegian", "Oslo, Norway",
                    "Suspected of involvement in international smuggling operations."
            ),

            new Criminal(
                    "Lars", "Johansen", "1989-02-05", "Male", "Norwegian",
                    "Oslo, Norway", "Lars J.",
                    "Images/Criminals/Lars_Johansen.png",

                    "Sweden", "ICR-2026-003", "Theft",

                    "180 cm", "78 kg", "Blue", "Blond",
                    "Tattoo on left forearm",

                    "Norwegian, Swedish, English", "Stockholm, Sweden",
                    "Wanted in connection with multiple theft cases."
            ),

            new Criminal(
                    "Maria", "Gomez", "1995-11-18", "Female", "Spanish",
                    "Madrid, Spain", "Maria G.",
                    "Images/Criminals/Maria_Gomez.png",

                    "Spain", "ICR-2026-004", "Cybercrime",

                    "165 cm", "59 kg", "Green", "Brown",
                    "Small birthmark below left eye",

                    "Spanish, English", "Barcelona, Spain",
                    "Suspected of participating in several cybercrime incidents."
            ),

            new Criminal(
                    "Chen", "Wei", "1990-07-30", "Male", "Chinese",
                    "Shanghai, China", "Wei Chen",
                    "Images/Criminals/Chen_Wei.png",

                    "USA", "ICR-2026-005", "Hacking",

                    "176 cm", "72 kg", "Brown", "Black",
                    "Scar on chin",

                    "Mandarin, English", "San Francisco, USA",
                    "Suspected of unauthorized access to computer systems."
            ),

            new Criminal(
                    "Ahmed", "Khan", "1985-01-14", "Male", "Pakistani",
                    "Lahore, Pakistan", "A. Khan",
                    "Images/Criminals/Ahmed_Khan.png",

                    "UK", "ICR-2026-006", "Terrorism",

                    "181 cm", "80 kg", "Brown", "Black",
                    "Scar on right cheek",

                    "Urdu, English, Punjabi", "London, UK",
                    "Wanted in connection with a terrorism-related investigation."
            ),

            new Criminal(
                    "Elena", "Popescu", "1993-06-22", "Female", "Romanian",
                    "Bucharest, Romania", "Elena P.",
                    "Images/Criminals/Elena_Popescu.png",

                    "Germany", "ICR-2026-007", "Identity theft",

                    "170 cm", "62 kg", "Blue", "Brown",
                    "Tattoo behind right shoulder",

                    "Romanian, German, English", "Berlin, Germany",
                    "Suspected of identity theft and document fraud."
            ),

            new Criminal(
                    "David", "Smith", "1988-12-03", "Male", "British",
                    "Manchester, UK", "Dave Smith",
                    "Images/Criminals/David_Smith.png",

                    "Canada", "ICR-2026-008", "Drug trafficking",

                    "185 cm", "88 kg", "Blue", "Brown",
                    "Scar on left forearm",

                    "English, French", "Toronto, Canada",
                    "Suspected of involvement in international drug trafficking."
            )
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

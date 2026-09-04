package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/*@Entity = Denne Java-klassen representerer en entitet/tabell i databasen*/
@Entity


public class Criminal {
    @Id // id er primærnøkkelen (Primary Key) til denne entiteten.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // generere ID-en automatisk.
    private long id; //id til objktet, Vi bruker ID-en som database-tabellens primary key.

    //CRIMINAL PROFILE
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    //private String age;
    private String gender;
    private String nationality;
    private String placeOfBirth;
    private String aliases;
    private String imageURL;

    //CRIMINAL INFORMATION
    private String wantedByCountry;
    private String caseNr;
    private String charges;

    //PHYSICAL DESCRIPTION
    private String height;
    private String weight;
    private String eyeColor;
    private String hairColor;
    private String distinguishing;

    //ADDITIONAL INFORMATION

    private String language;
    private String lastKnownArea;
    private String note;

    public Criminal() {
        /*Den tomme konstruktøren er der slik at JPA kan opprette Criminal-objektet først
        og fylle inn dataene etterpå.*/
    }

    public Criminal(
            String firstName, String lastName, String dateOfBirth,
            String gender, String nationality, String placeOfBirth,
            String aliases, String imageURL, String wantedByCountry,
            String caseNr, String charges, String height, String weight,
            String eyeColor, String hairColor, String distinguishing,
            String language, String lastKnownArea, String note)


    {
        this.aliases = aliases;
        this.caseNr = caseNr;
        this.charges = charges;
        this.dateOfBirth = dateOfBirth;
        this.distinguishing = distinguishing;
        this.eyeColor = eyeColor;
        this.firstName = firstName;
        this.gender = gender;
        this.hairColor = hairColor;
        this.height = height;
        this.imageURL = imageURL;
        this.language = language;
        this.lastKnownArea = lastKnownArea;
        this.lastName = lastName;
        this.nationality = nationality;
        this.note = note;
        this.placeOfBirth = placeOfBirth;
        this.wantedByCountry = wantedByCountry;
        this.weight = weight;
    }

    public String getAliases() {
        return aliases;
    }

    public void setAliases(String aliases) {
        this.aliases = aliases;
    }

    public String getCaseNr() {
        return caseNr;
    }

    public void setCaseNr(String caseNr) {
        this.caseNr = caseNr;
    }

    public String getCharges() {
        return charges;
    }

    public void setCharges(String charges) {
        this.charges = charges;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDistinguishing() {
        return distinguishing;
    }

    public void setDistinguishing(String distinguishing) {
        this.distinguishing = distinguishing;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLastKnownArea() {
        return lastKnownArea;
    }

    public void setLastKnownArea(String lastKnownArea) {
        this.lastKnownArea = lastKnownArea;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getWantedByCountry() {
        return wantedByCountry;
    }

    public void setWantedByCountry(String wantedByCountry) {
        this.wantedByCountry = wantedByCountry;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}

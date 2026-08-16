package com.example.demo;

public class Criminal {
    private String firstName;
    private String lastName;
    private String nationality;
    private String gender;
    private String wantedByCountry;
    private String charges;
    private String imageURL;


    public Criminal (String firstName, String lastName, String nationality,
                     String gender, String wantedByCountry, String charges, String imageURL) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationality = nationality;
        this.gender = gender;
        this.wantedByCountry = wantedByCountry;
        this.charges = charges;
        this.imageURL = imageURL;
    }

    public String getImageURL() {
        return imageURL;
    }
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
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

    public String getCharges() {
        return charges;
    }

    public void setCharges(String charges) {
        this.charges = charges;
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

    public String getWantedByCountry() {
        return wantedByCountry;
    }

    public void setWantedByCountry(String wantedByCountry) {
        this.wantedByCountry = wantedByCountry;
    }
}

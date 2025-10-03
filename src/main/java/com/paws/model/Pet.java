package com.paws.model;

import java.time.LocalDate;
import java.time.Period;

public class Pet {
    private String name;
    private String species;
    private String breed;
    private LocalDate dateOfBirth;
    private double weight;
    private String sex;
    private String medicalHistory; // Summary or notes
    private String allergies;
    private String notes; // general notes the user might want to add

    public Pet(String name, String species, String breed, LocalDate dateOfBirth, double weight, String sex,
               String medicalHistory, String allergies, String notes) {
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.dateOfBirth = dateOfBirth;
        this.weight = weight;
        this.sex = sex;
        this.medicalHistory = medicalHistory;
        this.allergies = allergies;
        this.notes = notes;
    }

    public String getName(){
        return name;
    }

    public String getSpecies(){
        return species;
    }

    public String getBreed(){
        return breed;
    }

    public LocalDate getDateOfBirth(){
        return dateOfBirth;
    }

    public double getWeight(){
        return weight;
    }

    public String getSex(){
        return sex;
    }

    public String getMedicalHistory(){
        return medicalHistory;
    }

    public String getAllergies(){
        return allergies;
    }

    public String getNotes(){
        return notes;
    }

    public void changeName(String name){
        this.name = name;
    }

    public void changeSpecies(String species){
        this.species = species;
    }

    public void changeBreed(String breed){
        this.breed = breed;
    }

    public void changeDateOfBirth(LocalDate dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }

    public void changeWeight(double weight){
        this.weight = weight;
    }

    public void changeSex(String sex){
        this.sex = sex;
    }

    public void changeMedicalHistory(String medicalHistory){
        this.medicalHistory = medicalHistory;
    }

    public void changeAllergies(String allergies){
        this.allergies = allergies;
    }

    public void changeNotes(String notes) {
        this.notes = notes;
    }

    public static int calculateAge(LocalDate dateOfBirth) {
        LocalDate currentDate = LocalDate.now(); //current date
        if (dateOfBirth.isAfter(currentDate)) {
            throw new IllegalArgumentException("Date of birth cannot be in the future.");
        }
        Period age = Period.between(dateOfBirth, currentDate); //get the period between the two dates
        return age.getYears(); //extract num years from period
    }


}
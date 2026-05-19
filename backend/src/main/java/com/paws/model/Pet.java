package com.paws.model;

import java.time.LocalDate;
import java.time.Period;

public class Pet {
    private Long id;
    private String name;
    private String species;
    private String breed;
    private LocalDate dateOfBirth;
    private double weight;
    private String sex;
    private String medicalHistory; // Summary or notes
    private String allergies;
    private String notes; // general notes the user might want to add

    public Pet(Long id, String name, String species, String breed, LocalDate dateOfBirth, double weight, String sex,
               String medicalHistory, String allergies, String notes) {
        this.id = id;
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
    public Long getId() {
        return id;
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

    public void setId(Long id){
        this.id = id;
    }
    public void setName(String name){

        this.name = name;
    }

    public void setSpecies(String species){
        this.species = species;
    }

    public void setBreed(String breed){
        this.breed = breed;
    }

    public void setDateOfBirth(LocalDate dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }

    public void setWeight(double weight){
        this.weight = weight;
    }

    public void setSex(String sex){
        this.sex = sex;
    }

    public void setMedicalHistory(String medicalHistory){
        this.medicalHistory = medicalHistory;
    }

    public void setAllergies(String allergies){
        this.allergies = allergies;
    }

    public void setNotes(String notes) {
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
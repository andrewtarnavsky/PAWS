package model;

public class Dog {
    private String name;
    private String breed;
    private int age;
    private double weight;
    private String sex;
    private String medicalHistory; // Summary or notes
    private String allergies;
    private String notes; // general notes the user might want to add

    public Dog(String name, String breed, int age, double weight, String sex,
               String medicalHistory, String allergies, String notes) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.weight = weight;
        this.sex = sex;
        this.medicalHistory = medicalHistory;
        this.allergies = allergies;
        this.notes = notes;
    }

    public String getName(){
        return name;
    }

    public String getBreed(){
        return breed;
    }

    public int getAge(){
        return age;
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

    public void changeBreed(String breed){
        this.breed = breed;
    }

    public void changeAge(int age){
        this.age = age;
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

}
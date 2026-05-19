package com.paws.model;
import java.time.LocalDate;
import java.util.List;

public class LogEntry {
    private Pet pet;
    private List<String> tags;
    private LocalDate date;
    private int moodLevel;
    private int energyLevel;
    private String appetite;
    private double weight;
    private String symptoms;
    private String notes;

    public LogEntry(Pet pet, List<String> tags, LocalDate date, int moodLevel, int energyLevel, String appetite, double weight, String symptoms, String notes) {
        this.pet = pet;
        this.tags = tags;
        this.date = date;
        this.moodLevel = moodLevel;
        this.energyLevel = energyLevel;
        this.appetite = appetite;
        this.weight = weight;
        this.symptoms = symptoms;
        this.notes = notes;

    }

    public Pet getDog() {
        return pet;
    }

    public List<String> getTags() {
        return tags;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getMoodLevel() {
        return moodLevel;
    }

    public int getEnergyLevel() {
        return energyLevel;
    }

    public String getAppetite() {
        return appetite;
    }

    public double getWeight() {
        return weight;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public String getNotes() {
        return notes;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setMoodLevel(int moodLevel) {
        this.moodLevel = moodLevel;
    }

    public void setEnergyLevel(int energyLevel) {
        this.energyLevel = energyLevel;
    }

    public void setAppetite(String appetite) {
        this.appetite = appetite;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    
}


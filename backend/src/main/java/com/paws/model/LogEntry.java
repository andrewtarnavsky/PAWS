package com.paws.model;

import java.time.LocalDate;

public class LogEntry {

    private Long id;
    private Long petId;
    private LocalDate logDate;
    private Integer mood;
    private Integer energy;
    private Integer appetite;
    private String symptoms;
    private Integer symptomSeverity;
    private String notes;

    public LogEntry() {
    }

    public LogEntry(Long id, Long petId, LocalDate logDate, Integer mood, Integer energy,
                    Integer appetite, String symptoms, Integer symptomSeverity, String notes) {
        this.id = id;
        this.petId = petId;
        this.logDate = logDate;
        this.mood = mood;
        this.energy = energy;
        this.appetite = appetite;
        this.symptoms = symptoms;
        this.symptomSeverity = symptomSeverity;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public LocalDate getLogDate() {
        return logDate;
    }

    public void setLogDate(LocalDate logDate) {
        this.logDate = logDate;
    }

    public Integer getMood() {
        return mood;
    }

    public void setMood(Integer mood) {
        this.mood = mood;
    }

    public Integer getEnergy() {
        return energy;
    }

    public void setEnergy(Integer energy) {
        this.energy = energy;
    }

    public Integer getAppetite() {
        return appetite;
    }

    public void setAppetite(Integer appetite) {
        this.appetite = appetite;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public Integer getSymptomSeverity() {
        return symptomSeverity;
    }

    public void setSymptomSeverity(Integer symptomSeverity) {
        this.symptomSeverity = symptomSeverity;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
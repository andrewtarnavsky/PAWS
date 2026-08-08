package com.paws.service;

import com.paws.model.LogEntry;
import com.paws.model.Pet;
import com.paws.repository.LogEntryRepository;
import com.paws.repository.PetRepository;
import org.apache.juli.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class LogEntryService {
    private static final Logger log = LoggerFactory.getLogger(LogEntryService.class);
    private LogEntryRepository logEntryRepository;
    private PetRepository petRepository;

    public LogEntryService(LogEntryRepository logEntryRepository, PetRepository petRepository){
        this.logEntryRepository = logEntryRepository;
        this.petRepository = petRepository;
    }

    public Optional<LogEntry> getLogEntryById(Long id){
        return logEntryRepository.findById(id);
    }

    public List<LogEntry> getByPetId(Long petId){
        return logEntryRepository.findByPetId(petId);
    }

    public Optional<LogEntry> createLogEntry(Long petId, LogEntry logEntry){
        Optional<Pet> optionalPet = petRepository.findById(petId);
        if(optionalPet.isEmpty()){
            return Optional.empty();
        }
        logEntry.setId(null);
        logEntry.setPetId(petId);

        LogEntry logEntrySaved = logEntryRepository.save(logEntry);
        return Optional.of(logEntrySaved);
    }

    public Optional<LogEntry> updateLogEntry(Long id, LogEntry updatedLogEntry){
        Optional<LogEntry> existingLogEntryOptional = logEntryRepository.findById(id);

        if(existingLogEntryOptional.isEmpty()){
            return Optional.empty();
        }

        updatedLogEntry.setId(id);
        updatedLogEntry.setPetId(existingLogEntryOptional.get().getPetId());

        boolean updated = logEntryRepository.update(updatedLogEntry);
        if(!updated){
            return Optional.empty();
        } else {
            return Optional.of(updatedLogEntry);
        }
    }

    public Optional<LogEntry> patchLogEntry(Long id, LogEntry partialLogEntry){
        Optional<LogEntry> existingLogEntryOptional = logEntryRepository.findById(id);
        if(existingLogEntryOptional.isEmpty()){
            return Optional.empty();
        }

        LogEntry existingLogEntry = existingLogEntryOptional.get();

        if(partialLogEntry.getLogDate() != null) {
            existingLogEntry.setLogDate(partialLogEntry.getLogDate());
        }

        if (partialLogEntry.getMood() != null) {
            existingLogEntry.setMood(partialLogEntry.getMood());
        }

        if (partialLogEntry.getEnergy() != null) {
            existingLogEntry.setEnergy(partialLogEntry.getEnergy());
        }

        if (partialLogEntry.getAppetite() != null) {
            existingLogEntry.setAppetite(partialLogEntry.getAppetite());
        }

        if (partialLogEntry.getSymptoms() != null) {
            existingLogEntry.setSymptoms(partialLogEntry.getSymptoms());
        }

        if (partialLogEntry.getSymptomSeverity() != null) {
            existingLogEntry.setSymptomSeverity(partialLogEntry.getSymptomSeverity());
        }

        if (partialLogEntry.getNotes() != null) {
            existingLogEntry.setNotes(partialLogEntry.getNotes());
        }

        boolean updated = logEntryRepository.update(existingLogEntry);
        if(!updated){
            return Optional.empty();
        } else {
            return Optional.of(existingLogEntry);
        }
    }

    boolean deleteLogEntry(Long id){
        return logEntryRepository.deleteById(id);
    }
}

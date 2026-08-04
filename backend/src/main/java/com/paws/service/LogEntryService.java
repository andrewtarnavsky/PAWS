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

    public LogEntry createLogEntry(Long petId, LogEntry logEntry){
        Optional<Pet> optionalPet = petRepository.findById(petId);
        if(optionalPet.isEmpty()){
            
        }
        return logEntryRepository.save(logEntry);
    }
}

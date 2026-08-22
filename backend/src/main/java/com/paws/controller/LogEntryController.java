package com.paws.controller;

import com.paws.service.PetService;
import com.paws.model.LogEntry;
import com.paws.model.Pet;
import com.paws.service.LogEntryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class LogEntryController {
    private LogEntryService logEntryService;

    public LogEntryController(LogEntryService logEntryService){
        this.logEntryService = logEntryService;
    }

    @GetMapping("/logs/{logId}")
    public ResponseEntity<LogEntry> getLogEntryById(@PathVariable Long id){
        return logEntryService.getLogEntryById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/pets/{petId}/logs")
    public List<LogEntry> getByPetId(@PathVariable Long petId){
        return logEntryService.getByPetId(petId);
    }

    @PostMapping("/pets/{petId}/logs")
    public Optional<LogEntry> createLogEntry(Long petId, LogEntry logEntry){

    }

    @PutMapping("/logs/{logId}")
    public Optional<LogEntry> updateLogEntry(Long id, LogEntry updatedLogEntry){

    }

    @PatchMapping("/logs/{logId}")
    public Optional<LogEntry> patchLogEntry(Long id, LogEntry partialLogEntry){

    }

    @DeleteMapping("/logs/{logId}")
    boolean deleteLogEntry(@PathVariable Long id){
        return logEntryService.deleteLogEntry(id);
    }
}



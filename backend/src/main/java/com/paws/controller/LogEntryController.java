package com.paws.controller;

import com.paws.service.PetService;
import com.paws.model.LogEntry;
import com.paws.model.Pet;
import com.paws.service.LogEntryService;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<LogEntry> createLogEntry(Long petId, LogEntry logEntry){
        return logEntryService.createLogEntry(petId, logEntry)
                .map(savedLogEntry -> ResponseEntity.status(HttpStatus.CREATED).body(savedLogEntry))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/logs/{logId}")
    public ResponseEntity<LogEntry> replaceLogEntry(Long id, LogEntry updatedLogEntry){
        return logEntryService.updateLogEntry(id, updatedLogEntry)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/logs/{logId}")
    public ResponseEntity<LogEntry> patchLogEntry(Long id, LogEntry partialLogEntry){
        return logEntryService.patchLogEntry(id, partialLogEntry)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/logs/{logId}")
    public ResponseEntity<Void> deleteLogEntryById(@PathVariable Long id){
        if(logEntryService.deleteLogEntry(id)){
            ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}



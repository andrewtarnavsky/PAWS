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
    public ResponseEntity<LogEntry> getLogEntryById(@PathVariable Long logId){
        return logEntryService.getLogEntryById(logId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/pets/{petId}/logs")
    public List<LogEntry> getByPetId(@PathVariable Long petId){
        return logEntryService.getByPetId(petId);
    }

    @PostMapping("/pets/{petId}/logs")
    public ResponseEntity<LogEntry> createLogEntry(@PathVariable Long petId, @RequestBody LogEntry logEntry){
        return logEntryService.createLogEntry(petId, logEntry)
                .map(savedLogEntry -> ResponseEntity.status(HttpStatus.CREATED).body(savedLogEntry))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/logs/{logId}")
    public ResponseEntity<LogEntry> replaceLogEntry(@PathVariable Long logId, @RequestBody LogEntry updatedLogEntry){
        return logEntryService.updateLogEntry(logId, updatedLogEntry)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/logs/{logId}")
    public ResponseEntity<LogEntry> patchLogEntry(@PathVariable Long logId, @RequestBody LogEntry partialLogEntry){
        return logEntryService.patchLogEntry(logId, partialLogEntry)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/logs/{logId}")
    public ResponseEntity<Void> deleteLogEntryById(@PathVariable Long logId){
        if(logEntryService.deleteLogEntry(logId)){
            ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}



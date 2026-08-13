package com.paws.controller;

import com.paws.model.LogEntry;
import com.paws.service.LogEntryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class LogEntryController {
    private LogEntryService logEntryService;

    public LogEntryController(LogEntryService logEntryService){
        this.logEntryService = logEntryService;
    }

    @GetMapping("/pet/{petId}/logs/{logId}")
    public ResponseEntity<Optional<LogEntry>> getLogEntryById(@PathVariable Long id){

    }


}

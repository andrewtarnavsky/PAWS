package com.paws.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * basic tests for PatternAnalyzer:
 * - single symptom match
 * - multiple symptoms match
 * - no symptoms / empty logs
 *
 */
public class PatternAnalyzerBasicTest {

    private PatternAnalyzer analyzer;

    @BeforeEach
    void setUp() {
        // TODO: adjust path if your JSON lives somewhere else (e.g. /resources/data/)
        analyzer = new PatternAnalyzer("src/main/resources/data/dog_illnesses.json");
    }

    @Test
    void singleSymptomMatch_returnsAtLeastOneIllness() {
        // TODO: replace with real LogEntry construction once PatternAnalyzer API is finalized
        Pet pet = new Pet("Max", "Dog", "German Shepherd", 5);

        LogEntry vomitingOnly = new LogEntry(
                pet,
                List.of("Vomiting"),
                LocalDate.now().minusDays(1),
                5, // mood
                4, // energy
                3, // appetite
                25.0,
                "Vomiting",
                "Vomited once after eating"
        );

        List<LogEntry> logs = List.of(vomitingOnly);

        // TODO: replace with real method call, e.g. analyzer.analyze(logs)
        // var result = analyzer.analyze(logs);

        // TODO: add real assertions once result type is known
        // assertFalse(result.getIllnesses().isEmpty(), "Expected at least one illness for vomiting");
    }

    @Test
    void multipleSymptomsMatch_returnsReasonableRankedIllnesses() {
        Pet pet = new Pet("Max", "Dog", "German Shepherd", 5);

        LogEntry day1 = new LogEntry(
                pet,
                List.of("Vomiting", "Low Energy"),
                LocalDate.now().minusDays(3),
                4, 3, 2,
                24.8,
                "Vomiting, low energy",
                "Seemed tired and vomited once"
        );

        LogEntry day2 = new LogEntry(
                pet,
                List.of("Low Energy", "Decreased Appetite"),
                LocalDate.now().minusDays(1),
                3, 2, 1,
                24.5,
                "Low energy, decreased appetite",
                "Less interested in food"
        );

        List<LogEntry> logs = List.of(day1, day2);

        // TODO: call analyzer and assert that illnesses are returned in a sensible order
        // var result = analyzer.analyze(logs);
        // assertFalse(result.getIllnesses().isEmpty());
    }

    @Test
    void emptyLogs_returnsNoIllnesses() {
        List<LogEntry> logs = List.of();

        // TODO: call analyzer and assert that no illnesses are suggested
        // var result = analyzer.analyze(logs);
        // assertTrue(result.getIllnesses().isEmpty());
    }
}

package com.paws.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * edge case tests for PatternAnalyzer:
 * - overlapping illnesses sharing symptoms
 * - incomplete / sparse logs
 * - symptoms for multiple species (if applicable)
 */
public class PatternAnalyzerEdgeCasesTest {

    private PatternAnalyzer analyzer;

    @BeforeEach
    void setUp() {
        // TODO: adjust path / data set if you want to use cats, rabbits, etc.
        analyzer = new PatternAnalyzer("src/main/resources/data/dog_illnesses.json");
    }

    @Test
    void overlappingIllnesses_areRankedByCoverageAndIntensity() {
        Pet pet = new Pet("Bella", "Dog", "Mixed", 4);

        // Symptoms that could belong to multiple illnesses:
        LogEntry log1 = new LogEntry(
                pet,
                List.of("Vomiting", "Diarrhea"),
                LocalDate.now().minusDays(5),
                4, 3, 2,
                18.2,
                "Vomiting and diarrhea",
                "GI upset after new food"
        );

        LogEntry log2 = new LogEntry(
                pet,
                List.of("Low Energy", "Decreased Appetite"),
                LocalDate.now().minusDays(3),
                3, 2, 1,
                18.0,
                "Low energy, poor appetite",
                "Still lethargic"
        );

        List<LogEntry> logs = List.of(log1, log2);

        // TODO: call analyzer and assert that illnesses with more coverage/intensity rank higher
        // var result = analyzer.analyze(logs);
        // assertTrue(result.getIllnesses().size() >= 2);
    }

    @Test
    void sparseLogs_stillProduceStableOutput() {
        Pet pet = new Pet("Lucy", "Dog", "Golden Retriever", 6);

        LogEntry singleSymptom = new LogEntry(
                pet,
                List.of("Low Energy"),
                LocalDate.now().minusDays(2),
                3, 2, 3,
                28.0,
                "Low energy",
                "Just seemed tired"
        );

        List<LogEntry> logs = List.of(singleSymptom);

        // TODO: analyzer should not crash or return nonsense with very little data
        // var result = analyzer.analyze(logs);
        // assertNotNull(result);
    }

    @Test
    void logsOutsideWindow_areIgnoredByThirtyDayFilter() {
        Pet pet = new Pet("Oliver", "Dog", "Border Collie", 3);

        LogEntry oldLog = new LogEntry(
                pet,
                List.of("Vomiting"),
                LocalDate.now().minusDays(90),
                5, 5, 5,
                20.0,
                "Old vomiting event",
                "Happened three months ago"
        );

        LogEntry recentLog = new LogEntry(
                pet,
                List.of("Healthy"),
                LocalDate.now().minusDays(1),
                8, 8, 8,
                21.0,
                "Healthy",
                "No symptoms recently"
        );

        List<LogEntry> logs = List.of(oldLog, recentLog);

        // TODO: assert analyzer only considers symptoms in the last 30 days
        // var result = analyzer.analyze(logs);
        // assertTrue(result.getIllnesses().isEmpty() || result.isLowRisk());
    }
}

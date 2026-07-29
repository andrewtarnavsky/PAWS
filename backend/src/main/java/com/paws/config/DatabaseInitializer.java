package com.paws.config;

import jakarta.annotation.PostConstruct;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer {

    private final JdbcTemplate db;

    public DatabaseInitializer(JdbcTemplate db) {
        this.db = db;
    }

    @PostConstruct
    public void createTables() {
        db.execute("""
            CREATE TABLE IF NOT EXISTS pets (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT NOT NULL,
                species TEXT,
                breed TEXT,
                age REAL,
                weight REAL
            )
        """);
    }
}
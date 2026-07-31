package com.paws.repository;

import com.paws.model.LogEntry;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class LogEntryRepository {
    private JdbcTemplate db;

    public LogEntryRepository(JdbcTemplate db){
        this.db = db;
    }

    public LogEntryRepository(){

    }

    public Optional<LogEntry> findById(Long id){
        String sql = """
                SELECT * FROM log_entries WHERE id = ?
                """;
        try {
            LogEntry logEntry = db.queryForObject(sql, new BeanPropertyRowMapper<>(LogEntry.class), id);
            return Optional.of(logEntry);
        } catch (EmptyResultDataAccessException exception) {
            return Optional.empty();
        }
    }

    public List<LogEntry> findByPetId(Long petId){
        String sql = """
                SELECT * FROM log_entries
                WHERE pet_id = ?
                ORDER BY log_date DESC
                """;

        return db.query(sql, new BeanPropertyRowMapper<>(LogEntry.class), petId);
    }
}

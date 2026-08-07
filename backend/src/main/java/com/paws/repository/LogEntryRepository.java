package com.paws.repository;

import com.paws.model.LogEntry;
import org.apache.juli.logging.Log;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.swing.text.html.Option;
import java.sql.PreparedStatement;
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

    public LogEntry save(LogEntry logEntry){
        String sql = """
                INSERT INTO log_entries
                (pet_id, log_date, mood, energy, appetite, symptoms, symptom_severity, notes)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?)
            """;

        KeyHolder keyHolder = new GeneratedKeyHolder();
        db.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement.setLong(1, logEntry.getPetId());
            preparedStatement.setString(2, logEntry.getLogDate().toString());
            preparedStatement.setObject(3, logEntry.getMood());
            preparedStatement.setObject(4, logEntry.getEnergy());
            preparedStatement.setObject(5, logEntry.getAppetite());
            preparedStatement.setString(6, logEntry.getSymptoms());
            preparedStatement.setObject(7, logEntry.getSymptomSeverity());
            preparedStatement.setString(8, logEntry.getNotes());

            return preparedStatement;
        },keyHolder);

        if(keyHolder.getKey() != null){
            logEntry.setId(keyHolder.getKey().longValue());
        }
        return logEntry;
    }

    public boolean update(LogEntry logEntry){
        String sql = """
                UPDATE log_entries
                SET pet_id = ?,
                    log_date = ?,
                    mood = ?,
                    energy = ?,
                    appetite = ?,
                    symptoms = ?,
                    symptom_severity = ?,
                    notes = ?
                WHERE id = ?
                """;

        int rowsAffected = db.update(sql,
                logEntry.getPetId(),
                logEntry.getLogDate().toString(),
                logEntry.getMood(),
                logEntry.getEnergy(),
                logEntry.getAppetite(),
                logEntry.getSymptoms(),
                logEntry.getSymptomSeverity(),
                logEntry.getNotes(),
                logEntry.getId()
        );

        return rowsAffected > 0;
    }

    public boolean deleteById(Long id){
        String sql = """
                DELETE FROM log_entries
                WHERE id = ?
                """;

        int rowsAffected = db.update(sql,id);
        
        return rowsAffected > 0;
    }
}

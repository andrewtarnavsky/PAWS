package com.paws.repository;

import com.paws.model.Pet;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class PetRepository {

    private final JdbcTemplate jdbcTemplate;

    public PetRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Pet> findAll() {
        String sql = "SELECT * FROM pets";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Pet>(Pet.class));
    }

    public List<Pet> findBySpecies(String species) {
        String sql = "SELECT * FROM pets WHERE LOWER(species) = LOWER(?)";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Pet>(Pet.class), species);
    }

    public boolean deleteById(Long id) {
        String sql = "DELETE FROM pets WHERE id = ?";

        int rowsAffected = jdbcTemplate.update(sql, id);

        return rowsAffected > 0;
    }
}
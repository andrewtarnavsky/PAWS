package com.paws.repository;

import com.paws.model.Pet;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

    public Optional<Pet> findById(Long id){
        String sql = "SELECT * FROM pets WHERE id = ?";
        try {
            Pet pet = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Pet>(Pet.class), id);
            return Optional.of(pet);
        } catch (EmptyResultDataAccessException exception){
            return Optional.empty();
        }
    }

    public boolean deleteById(Long id) {
        String sql = "DELETE FROM pets WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(sql, id);
        return rowsAffected > 0;
    }

}
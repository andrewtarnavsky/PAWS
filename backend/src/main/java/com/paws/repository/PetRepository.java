package com.paws.repository;

import com.paws.model.Pet;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
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

    public Pet save(Pet pet) {
        String sql = """
            INSERT INTO pets (name, species, breed, age, weight)
            VALUES (?, ?, ?, ?, ?)
        """;

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, pet.getName());
            preparedStatement.setString(2, pet.getSpecies());
            preparedStatement.setString(3, pet.getBreed());
            preparedStatement.setObject(4, pet.getAge());
            preparedStatement.setObject(5, pet.getWeight());

            return preparedStatement;
        }, keyHolder);

        if (keyHolder.getKey() != null) {
            pet.setId(keyHolder.getKey().longValue());
        }

        return pet;
    }

    public boolean deleteById(Long id) {
        String sql = "DELETE FROM pets WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(sql, id);
        return rowsAffected > 0;
    }

}
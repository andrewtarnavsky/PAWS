package com.paws.repository;

import com.paws.model.Pet;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PetRepository {

    private final JdbcTemplate jdbcTemplate;

    public PetRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Pet> findAll() {
        String sql = "SELECT * FROM pets";

        return jdbcTemplate.query(sql, (resultSet, rowNum) -> {
            Pet pet = new Pet();

            pet.setId(resultSet.getLong("id"));
            pet.setName(resultSet.getString("name"));
            pet.setSpecies(resultSet.getString("species"));
            pet.setBreed(resultSet.getString("breed"));
            pet.setAge(resultSet.getInt("age"));
            pet.setWeight(resultSet.getDouble("weight"));

            return pet;
        });
    }
}
package com.paws.service;

import com.paws.model.Pet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PetService {

    private final List<Pet> pets = new ArrayList<>();
    private final AtomicLong nextId = new AtomicLong(1);

    public List<Pet> getAllPets() {
        return pets;
    }

    public Pet createPet(Pet pet) {
        pet.setId(nextId.getAndIncrement());
        pets.add(pet);
        return pet;
    }

    public Optional<Pet> getPetById(Long id) {
        for (Pet pet : pets) {
            if (pet.getId().equals(id)) {
                return Optional.of(pet);
            }
        }
        return Optional.empty();
    }
}
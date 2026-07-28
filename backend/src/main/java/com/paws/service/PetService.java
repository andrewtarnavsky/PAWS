package com.paws.service;

import com.paws.model.Pet;
import com.paws.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PetService {

    private final PetRepository petRepository;

    public PetService(PetRepository petRepository){
        this.petRepository = petRepository;
    }

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public Pet createPet(Pet pet) {
        pet.setId(null); //In case a value was already set
        return petRepository.save(pet);
    }

    public Optional<Pet> getPetById(Long id) {
        return petRepository.findById(id);
    }

    public List<Pet> getPetsBySpecies(String species){
        return petRepository.findBySpecies(species);
    }

    public Optional<Pet> updatePet(Long id, Pet updatedPet){
        Optional<Pet> existingPetOptional = petRepository.findById(id);
        if(existingPetOptional.isEmpty()){
            return Optional.empty();
        }

        updatedPet.setId(id); //So that you can match to the pet in db, since pet doesn't have an id yet
        boolean updated = petRepository.update(updatedPet);
        if(!updated){
            return Optional.empty();
        } else{
            return Optional.of(updatedPet);
        }
    }

    public Optional<Pet> patchPet(Long id, Pet partialPet){
        Optional<Pet> existingPetOptional = petRepository.findById(id);
        if(existingPetOptional.isEmpty()){
            return Optional.empty();
        }

        Pet existingPet = existingPetOptional.get();

        if(partialPet.getName() != null){
            existingPet.setName(partialPet.getName());
        }

        if (partialPet.getSpecies() != null) {
            existingPet.setSpecies(partialPet.getSpecies());
        }

        if (partialPet.getBreed() != null) {
            existingPet.setBreed(partialPet.getBreed());
        }

        if (partialPet.getAge() != null) {
            existingPet.setAge(partialPet.getAge());
        }

        if (partialPet.getWeight() != null) {
            existingPet.setWeight(partialPet.getWeight());
        }

        boolean updated = petRepository.update(existingPet);
        if(!updated){
            return Optional.empty();
        } else {
            return Optional.of(existingPet);
        }

    }

    public boolean deletePetById(Long id) {
        return petRepository.deleteById(id);
    }
}
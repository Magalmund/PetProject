package tech.getarrays.petsmanager.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.getarrays.petsmanager.model.Pet;
import tech.getarrays.petsmanager.repository.PetRepo;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PetService {
    private final PetRepo petRepo;

    public Pet addPet(Pet pet) {
        Optional<Pet> petById = petRepo.findPetById(pet.getId());
        if(petById.isPresent()){
            throw new IllegalArgumentException("This already exist in database");
        }
        return petRepo.save(pet);
    }

    public List<Pet> findAllPets() {
        return petRepo.findAll();
    }

    public Pet updatePet(Pet pet){
        Optional<Pet> petById = petRepo.findPetById(pet.getId());
        if(petById.isEmpty()){
            throw new IllegalArgumentException("This Pet doesn't exist");
        }
        return petRepo.save(pet);
    }
}

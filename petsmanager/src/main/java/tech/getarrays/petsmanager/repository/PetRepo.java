package tech.getarrays.petsmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.petsmanager.model.Pet;

import java.util.Optional;

public interface PetRepo extends JpaRepository<Pet, Long> {

    void deletePetById(Long id);

    Optional<Pet> findPetById(Long id);
}

package tech.getarrays.petsmanager;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.petsmanager.model.Pet;
import tech.getarrays.petsmanager.service.PetService;

import java.util.List;

@RestController
@RequestMapping("/pet")
@CrossOrigin
public class PetResource {
    private final PetService petService;

    public PetResource(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Pet>> getAllPets () {
       List<Pet> pets = petService.findAllPets();
       return new ResponseEntity<>(pets, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Pet> getPetById (@PathVariable("id") Long id) {
        Pet pet = petService.findPetById(id);
        return new ResponseEntity<>(pet, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Pet> addPet(@RequestBody Pet pet){
        Pet newPet = petService.addPet(pet);
        return new ResponseEntity<>(newPet, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Pet> updatePet(@RequestBody Pet pet){
        Pet updatePet = petService.updatePet(pet);
        return new ResponseEntity<>(updatePet, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePet(@PathVariable("id") Long id){
        petService.deletePet(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

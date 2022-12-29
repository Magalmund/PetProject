package tech.getarrays.petsmanager.controllers;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.petsmanager.model.Pet;
import tech.getarrays.petsmanager.service.PetService;

import java.util.List;

@RestController
@RequestMapping("/pet")
@CrossOrigin
@AllArgsConstructor
public class PetController {
    private final PetService petService;

    @GetMapping("/all")
    public ResponseEntity<List<Pet>> getAllPets () {
       List<Pet> pets = petService.findAllPets();
       return new ResponseEntity<>(pets, HttpStatus.OK);
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

}

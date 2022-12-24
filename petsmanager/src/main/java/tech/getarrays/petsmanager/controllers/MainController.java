package tech.getarrays.petsmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tech.getarrays.petsmanager.repository.PetRepo;
import tech.getarrays.petsmanager.model.Pet;

@Controller
public class MainController {
    @Autowired
    private PetRepo petRepo;

    @ResponseBody
    @RequestMapping("/")
    public String index() {
        Iterable<Pet> all = petRepo.findAll();

        StringBuilder sb = new StringBuilder();

        all.forEach(p -> sb.append(p.getPetName() + "<br>"));

        return sb.toString();
    }

}

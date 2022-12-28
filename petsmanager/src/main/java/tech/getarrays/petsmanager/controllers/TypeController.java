package tech.getarrays.petsmanager.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.getarrays.petsmanager.model.Type;
import tech.getarrays.petsmanager.service.TypeService;

import java.util.List;

@RestController
@RequestMapping("/type")
@CrossOrigin
public class TypeController {
    private final TypeService typeService;

    public TypeController(TypeService typeService) { this.typeService = typeService; }

    @GetMapping("/all")
    public ResponseEntity<List<Type>> getAllTypes () {
        List<Type> types = typeService.findAllTypes();
        return new ResponseEntity<>(types, HttpStatus.OK);
    }
}

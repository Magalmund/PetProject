package tech.getarrays.petsmanager.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.getarrays.petsmanager.model.Color;
import tech.getarrays.petsmanager.service.ColorService;

import java.util.List;

@RestController
@RequestMapping("/color")
@CrossOrigin
public class ColorController {
    private final ColorService colorService;

    public ColorController(ColorService colorService) {this.colorService = colorService;}

    @GetMapping("/all")
    public ResponseEntity<List<Color>> getAllColors () {
        List<Color> colors = colorService.findAllColors();
        return new ResponseEntity<>(colors, HttpStatus.OK);
    }
}

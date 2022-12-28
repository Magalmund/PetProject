package tech.getarrays.petsmanager.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.getarrays.petsmanager.model.Country;
import tech.getarrays.petsmanager.service.CountryService;

import java.util.List;

@RestController
@RequestMapping("/country")
@CrossOrigin
public class CountryController {
    private final CountryService countryService;

    public CountryController(CountryService countryService) { this.countryService = countryService; }

    @GetMapping("/all")
    public ResponseEntity<List<Country>> getAllCountries () {
        List<Country> countries = countryService.findAllCountry();
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }
}

package tech.getarrays.petsmanager.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.getarrays.petsmanager.model.Country;
import tech.getarrays.petsmanager.repository.CountryRepo;

import java.util.List;

@AllArgsConstructor
@Service
public class CountryService {
    private final CountryRepo countryRepo;

    public List<Country> findAllCountry() { return countryRepo.findAll();}
}

package tech.getarrays.petsmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.petsmanager.model.Country;


public interface CountryRepo extends JpaRepository<Country, Long> {
}

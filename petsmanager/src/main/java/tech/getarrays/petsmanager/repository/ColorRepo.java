package tech.getarrays.petsmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.petsmanager.model.Color;


public interface ColorRepo extends JpaRepository<Color, Long> {

}

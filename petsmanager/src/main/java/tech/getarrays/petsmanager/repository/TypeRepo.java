package tech.getarrays.petsmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.petsmanager.model.Type;


public interface TypeRepo extends JpaRepository<Type, Long> {
}

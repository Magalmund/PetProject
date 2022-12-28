package tech.getarrays.petsmanager.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.getarrays.petsmanager.model.Type;
import tech.getarrays.petsmanager.repository.TypeRepo;

import java.util.List;

@AllArgsConstructor
@Service
public class TypeService {
    private final TypeRepo typeRepo;

    public List<Type> findAllTypes() {return typeRepo.findAll();}
}

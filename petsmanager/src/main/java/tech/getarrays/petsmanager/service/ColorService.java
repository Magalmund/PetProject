package tech.getarrays.petsmanager.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.getarrays.petsmanager.model.Color;
import tech.getarrays.petsmanager.repository.ColorRepo;

import java.util.List;

@AllArgsConstructor
@Service
public class ColorService {
    private final ColorRepo colorRepo;

    public List<Color> findAllColors() { return colorRepo.findAll(); }
}

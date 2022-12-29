package tech.getarrays.petsmanager.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "pet")
public class Pet {
    @Id
    @SequenceGenerator(
            name = "pet_sequence",
            sequenceName = "pet_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "pet_sequence"
    )
    private Long id;
    private String petName;
    private String petCode;
    private String type;
    private String color;
    private String country;


    public Pet(String petName, String petCode, String type, String color, String country) {
        this.petName = petName;
        this.petCode = petCode;
        this.type = type;
        this.color = color;
        this.country = country;
    }

}
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
@Table(name = "Pets")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable=false, updatable = false)
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
package tech.getarrays.petsmanager.model;

//import java.util.Date;

import jakarta.persistence.*;

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

    public Pet(){}

    public Pet(String petName, String petCode, String type, String color, String country) {
        this.petName = petName;
        this.petCode = petCode;
        this.type = type;
        this.color = color;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetCode() {
        return petCode;
    }

    public void setPetCode(String petCode) {
        this.petCode = petCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", petName='" + petName + '\'' +
                ", petCode='" + petCode + '\'' +
                ", type='" + type + '\'' +
                ", color='" + color + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
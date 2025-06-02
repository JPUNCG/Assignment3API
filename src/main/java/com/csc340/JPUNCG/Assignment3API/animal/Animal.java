package com.csc340.JPUNCG.Assignment3API.animal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "animals")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long animalId;
    private String name;
    private String description;
    private String species;
    private String source;

    public Animal() {
    }

    public Animal(Long animalId, String name, String description, String species, String source) {
        this.animalId = animalId;
        this.name = name;
        this.description = description;
        this.species = species;
        this.source = source;
    }

    public Animal( String name, String description, String species, String source) {
        this.name = name;
        this.description = description;
        this.species = species;
        this.source = source;
    }

    public Long getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Long id) {
        this.animalId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getspecies() {
        return species;
    }

    public void setspecies(String species) {
        this.species = species;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}

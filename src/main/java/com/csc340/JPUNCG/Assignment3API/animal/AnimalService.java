package com.csc340.JPUNCG.Assignment3API.animal;

import java.io.IOException;
import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AnimalService {
    
    @Autowired
    private AnimalRepository animalRepository;

    public Object getAllAnimals() {
        return animalRepository.findAll();
    }

    public Animal getAnimalById(@PathVariable long animalId) {
        return animalRepository.findById(animalId).orElse(null);
    }

    public Object getAnimalsByName(String name) {
        return animalRepository.getAnimalsByName(name);
    }

    public Object getAnimalsBySpecies(String species) {
        return animalRepository.getAnimalsBySpecies(species);
    }

    public Object getAnimalsBySource(String source) {
        return animalRepository.getAnimalsBySource(source);
    }

    public Animal updateAnimal(Long animalId, Animal animal) {
        return animalRepository.save(animal);
    }

    public Animal addAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    public void deleteAnimal(Long animalId) {
        animalRepository.deleteById(animalId);
    }

    public String writeJson(Animal animal) {
    ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("animals.json"), animal);
            return "animal written to JSON file successfully";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error writing animal to JSON file";
        }
    }

    public Object readJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File("animals.json"), Animal.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

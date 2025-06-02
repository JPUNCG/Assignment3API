package com.csc340.JPUNCG.Assignment3API.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping("/animals")
    public Object getAllAnimals() {
        return animalService.getAllAnimals();
    }

    @GetMapping("/animals/{id}")
    public Animal getAnimalById(@PathVariable long id) {
        return animalService.getAnimalById(id);
    }

    @GetMapping("/animals/name")
    public Object getAnimalsByName(@RequestParam String key) {
        if (key != null) {
            return animalService.getAnimalsByName(key);
        } else {
            return animalService.getAllAnimals();
        }
    }

    @GetMapping("/animals/species/{species}")
    public Object getAnimalsBySpecies(@PathVariable String species) {
        return animalService.getAnimalsBySpecies(species);
    }
    
    @GetMapping("/animals/source/{source}")
    public Object getAnimalsBySource(@PathVariable String source) {
        return animalService.getAnimalsBySource(source);
    }

    @PostMapping("/animals")
    public Object addAnimal(@RequestBody Animal animal) {
        return animalService.addAnimal(animal);
    }

    @PutMapping("/animals/{id}")
    public Animal updateAnimal(@PathVariable Long id, @RequestBody Animal animal) {
        animalService.updateAnimal(id, animal);
        return animalService.getAnimalById(id);
    }

    @DeleteMapping("animals/{id}")
    public Object deleteAnimal(@PathVariable Long id) {
        animalService.deleteAnimal(id);
        return animalService.getAllAnimals();
    }

    @PostMapping("/animals/writeFile")
    public Object writeJson(@RequestBody Animal animal) {
        animalService.writeJson(animal);
        return animalService.writeJson(animal);
    }

    @GetMapping("/animals/readFile")
    public Object readJson() {
        return animalService.readJson();
    }
}

package com.csc340.JPUNCG.Assignment3API.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;

@Controller
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    /**
     * Endpoint to get all animals
     *
     * @return List of all animals
     */
    @GetMapping("/animals")
    public Object getAllAnimals(Model model) {
        model.addAttribute("animalsList", animalService.getAllAnimals());
        model.addAttribute("title", "All Animals");
        return "animals-list";
    }

    /**
     * Endpoint to get an animal by ID
     */
    @GetMapping("/animals/{id}")
    public Object getAnimalById(@PathVariable long id, Model model) {
        model.addAttribute("animal", animalService.getAnimalById(id));
        model.addAttribute("title", "Animal #: " + id);
        return "animal-details";
    }

    /**
     * Endpoint to get animals by name
     */
    @GetMapping("/animals/name")
    public Object getAnimalsByName(@RequestParam String key, Model model) {
        if (key != null) {
            model.addAttribute("animalsList", animalService.getAnimalsByName(key));
            model.addAttribute("title", "Animals By Name: " + key);
            return "animals-list";
        } else {
            return "redirect:/animals/";
        }
    }

    /**
     * Endpoint to get animals by species
     */
    @GetMapping("/animals/species/{species}")
    public Object getAnimalsBySpecies(@PathVariable String species, Model model) {
        model.addAttribute("animalsList", animalService.getAnimalsBySpecies(species));
        model.addAttribute("title", "Animals By Species: " + species);
        return "animals-list";
    }

    /**
     * Endpoint to get animals by source
     */
    @GetMapping("/animals/source/{source}")
    public Object getAnimalsBySource(@PathVariable String source, Model model) {
        model.addAttribute("animalsList", animalService.getAnimalsBySource(source));
        model.addAttribute("title", "Animals By Source: " + source);
        return "animals-list";
    }

    /**
     * Endpoint to show the create form for a new animal
     */
    @GetMapping("/animals/createForm")
    public Object showCreateForm(Model model) {
        Animal animal = new Animal();
        model.addAttribute("animal", animal);
        model.addAttribute("title", "Create New Animal");
        return "animals-create";
    }

    /**
     * Endpoint to add a new animal
     */
    @PostMapping("/animals")
    public Object addAnimal(Animal animal) {
        Animal newAnimal = animalService.addAnimal(animal);
        return "redirect:/animals/" + newAnimal.getAnimalId();
    }

    /**
     * Endpoint to show the update form for an animal
     */
    @GetMapping("/animals/updateForm/{id}")
    public Object showUpdateForm(@PathVariable Long id, Model model) {
        Animal animal = animalService.getAnimalById(id);
        model.addAttribute("animal", animal);
        model.addAttribute("title", "Update Animal: " + id);
        return "animals-update";
    }

    /**
     * Endpoint to update an animal
     */
    @PostMapping("/animals/update/{id}")
    public Object updateAnimal(@PathVariable Long id, Animal animal) {
        animalService.updateAnimal(id, animal);
        return "redirect:/animals/" + id;
    }

    /**
     * Endpoint to delete an animal
     */
    @GetMapping("/animals/delete/{id}")
    public Object deleteAnimal(@PathVariable Long id) {
        animalService.deleteAnimal(id);
        return "redirect:/animals/";
    }

    /**
     * Endpoint to write an animal to a JSON file
     */
    @PostMapping("/animals/writeFile")
    public Object writeJson(@RequestBody Animal animal) {
        return animalService.writeJson(animal);
    }

    /**
     * Endpoint to read a JSON file and return its contents
     */
    @GetMapping("/animals/readFile")
    public Object readJson() {
        return animalService.readJson();
    }
}

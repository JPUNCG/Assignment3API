package com.csc340.JPUNCG.Assignment3API.animal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

    List<Animal> getAnimalsBySpecies(String species);

    @Query(value = "select * from animals a where a.name like %?1% ", nativeQuery = true)
    List<Animal> getAnimalsByName(String name);

    @Query(value = "select * from animals a where a.source like %?1% ", nativeQuery = true)
    List<Animal> getAnimalsBySource(String name);
}
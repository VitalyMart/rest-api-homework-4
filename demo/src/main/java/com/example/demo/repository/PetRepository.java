package com.example.demo.repository;

import com.example.demo.model.Pet;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PetRepository {
    private final Map<Long, Pet> petStorage = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public List<Pet> findAll() {
        return new ArrayList<>(petStorage.values());
    }

    public Optional<Pet> findById(Long id) {
        return Optional.ofNullable(petStorage.get(id));
    }

    public Pet save(Pet pet) {
        if (pet.getId() == null) {
            pet.setId(idCounter.getAndIncrement());
        }
        petStorage.put(pet.getId(), pet);
        return pet;
    }

    public void deleteById(Long id) {
        petStorage.remove(id);
    }
}

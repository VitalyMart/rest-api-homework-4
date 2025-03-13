package com.example.demo.service;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.AbstractIntegrationTest;
import com.example.demo.model.Pet;

class PetServiceIntegrationTest extends AbstractIntegrationTest {

    @Autowired
    private PetService petService;

    @Test
    void testCreateAndGetPet() {
        // Создаем питомца
        Pet pet = new Pet();
        pet.setName("Rex");
        pet.setStatus("available");

        Pet createdPet = petService.createPet(pet);
        assertNotNull(createdPet);
        assertNotNull(createdPet.getId());

        // Получаем питомца по ID
        Optional<Pet> foundPet = petService.getPetById(createdPet.getId());
        assertTrue(foundPet.isPresent());
        assertEquals("Rex", foundPet.get().getName());
    }
}
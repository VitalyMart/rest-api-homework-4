package com.example.demo.controller;

import com.example.demo.AbstractIntegrationTest;
import com.example.demo.model.Pet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class PetControllerIntegrationTest extends AbstractIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testCreateAndGetPet() {
        // Создаем питомца
        Pet pet = new Pet();
        pet.setName("Rex");
        pet.setStatus("available");

        ResponseEntity<Pet> createResponse = restTemplate.postForEntity("/api/v3/pet", pet, Pet.class);
        assertEquals(HttpStatus.CREATED, createResponse.getStatusCode());
        assertNotNull(createResponse.getBody());
        assertNotNull(createResponse.getBody().getId());

        // Получаем питомца по ID
        ResponseEntity<Pet> getResponse = restTemplate.getForEntity("/api/v3/pet/" + createResponse.getBody().getId(), Pet.class);
        assertEquals(HttpStatus.OK, getResponse.getStatusCode());
        assertNotNull(getResponse.getBody());
        assertEquals("Rex", getResponse.getBody().getName());
    }
}
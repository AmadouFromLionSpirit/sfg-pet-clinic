package com.amadousarr.sfgpetclinic.services.map;

import com.amadousarr.sfgpetclinic.model.Owner;
import com.amadousarr.sfgpetclinic.model.Pet;
import com.amadousarr.sfgpetclinic.model.PetType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {
    OwnerMapService ownerMapService;
    final Long ownerId = 1l;
    final String lastName = "Smith";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(),new PetMapService());
        /**
         * What this below is going to do, i save the owner like so. So this initializes my OwnerMapService
         * and puts one Owner object into it. So that now I can do interesting things like ownerMapService.findAll()
         */
        ownerMapService.save(Owner.builder().id(ownerId).lastName("Smith").build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();
        assertEquals(1,ownerSet.size());
    }

    /* @Test
    void findAll() {
        Set<Owner> expectedList = new HashSet<>();
        Owner owner1 = new Owner();
        Owner owner2 = new Owner();
        owner1.setFirstName("Amadou");
        owner1.setLastName("Sarr");
        Pet pet1 = new Pet();
        PetType petType = new PetType();
        petType.setName("dog");
        pet1.setPetType(petType);
        owner1.getPets().add(pet1);
        pet1.setOwner(owner1);
        expectedList.add(owner1);
        expectedList.add(owner2);

        Set<Owner> resultListOwners = ownerMapService.findAll();
        resultListOwners.add(owner1);
        resultListOwners.add(owner2);
        assertEquals(expectedList,resultListOwners);
    }*/

    @Test
    void findById() {
        Owner resultOwnerFindById = ownerMapService.findById(1L);
        assertEquals(ownerId,resultOwnerFindById.getId());
    }

    @Test
    void saveExistingId() {
        long id = 2L;
        Owner owner2 = Owner.builder().id(id).build();
        Owner savedOwner = ownerMapService.save(owner2);
        assertEquals(id,savedOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner savedOwner = ownerMapService.save(Owner.builder().build());
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerId);
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner smith = ownerMapService.findByLastName(lastName);

        assertNotNull(smith);
        assertEquals(ownerId, smith.getId());
    }

    @Test
    void findByLastNameNotFound() {
        Owner smith = ownerMapService.findByLastName("foo");

        assertNull(smith);

    }
}
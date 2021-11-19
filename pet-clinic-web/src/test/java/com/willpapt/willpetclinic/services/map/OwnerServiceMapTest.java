package com.willpapt.willpetclinic.services.map;

import com.willpapt.willpetclinic.model.Owner;
import com.willpapt.willpetclinic.services.PetService;
import com.willpapt.willpetclinic.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeMapService(), new PetServiceMap());
        ownerServiceMap.save(Owner.builder().id(1L).lastName("Davy").build());
        ownerServiceMap.save(Owner.builder().id(2L).lastName("wilfried").build());
        ownerServiceMap.save(Owner.builder().id(3L).lastName("Robert").build());
        ownerServiceMap.save(Owner.builder().id(4L).lastName("Carlos").build());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerServiceMap.findAll();
        int theSize = 4;
        assertEquals(theSize, owners.size());
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(1L);
        Long idOwner = 1L;
        assertEquals(idOwner.longValue(),owner.getId().longValue());
    }

    @Test
    void deleteById() {
        int theSize = 3;
        ownerServiceMap.deleteById(1L);
        Set<Owner> owners = ownerServiceMap.findAll();
        assertEquals(3,owners.size());
    }

    @Test
    void delete() {
    }

    @Test
    void saveExitId() {
        Long id = 5L;
        Owner owner = Owner.builder().id(id).firstName("Yves").lastName("Alice").build();
        ownerServiceMap.save(owner);
        assertEquals(id,owner.getId());
    }

    @Test
    void saveNoId() {
        Owner owner = Owner.builder().lastName("Nicole").build();
        ownerServiceMap.save(owner);
        assertNotNull(owner.getId());
    }

    @Test
    void findByLastName() {
        Owner owner = ownerServiceMap.findByLastName("Robert");
        assertNotNull(owner);
    }
    @Test
    void findByLastNameNotFound() {
        Owner owner = ownerServiceMap.findByLastName("Foo");
        assertNull(owner);
    }
}
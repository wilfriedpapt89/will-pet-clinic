package com.willpapt.willpetclinic.services.springdatajpa;

import com.willpapt.willpetclinic.model.Owner;
import com.willpapt.willpetclinic.repository.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class OwnerSDJPAServiceTest {

    public static final String LAST_NAME = "Smith";
    @InjectMocks
    OwnerSDJPAService ownerSDJPAService;
    @Mock
    OwnerRepository ownerRepository;

    Owner returnedOwner = null;

//    public OwnerSDJPAServiceTest() {
//        ownerSDJPAService = new OwnerSDJPAService(ownerRepository);
//    }

    @BeforeEach
    void setUp() {
        returnedOwner = Owner.builder().id(1L).lastName("Smith").build();
    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>();
        Owner owner = Owner.builder().lastName("Wilfried").firstName("Arakaza").build();
        owners.add(owner);
        when(ownerRepository.findAll()).thenReturn(owners);
        Set<Owner> ownersFromJpaService = ownerSDJPAService.findAll();
        verify(ownerRepository).findAll();
        assertEquals(1,ownersFromJpaService.size());
    }

    @Test
    void findById() {
        Long id = 1L;
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnedOwner));
        Owner owner = ownerSDJPAService.findById(id);
        assertNotNull(owner);
        verify(ownerRepository).findById(any());
    }
    @Test
    void findByIdNotFound() {
        Long id = 1L;
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Owner owner = ownerSDJPAService.findById(id);
        assertNull(owner);
        verify(ownerRepository).findById(any());
    }

    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(returnedOwner);
        Owner owner = Owner.builder().id(2L).build();
        owner = ownerSDJPAService.save(owner);
        verify(ownerRepository).save(any());
        assertEquals(1L, owner.getId());
    }

    @Test
    void delete() {
        ownerSDJPAService.delete(returnedOwner);
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        ownerSDJPAService.deleteById(1L);
        verify(ownerRepository).deleteById(anyLong());
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(returnedOwner);
        Owner smith = ownerSDJPAService.findByLastName(LAST_NAME);
        assertEquals(LAST_NAME,smith.getLastName());
        verify(ownerRepository).findByLastName(anyString());
    }
}
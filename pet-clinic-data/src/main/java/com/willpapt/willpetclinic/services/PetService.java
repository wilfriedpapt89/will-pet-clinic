package com.willpapt.willpetclinic.services;

import com.willpapt.willpetclinic.model.Owner;
import com.willpapt.willpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}

package com.willpapt.willpetclinic.services;

import com.willpapt.willpetclinic.model.Owner;
import com.willpapt.willpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);
    Vet save(Vet vet);
    Set<Vet> findAll();
}

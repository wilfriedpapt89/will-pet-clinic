package com.willpapt.willpetclinic.repository;

import com.willpapt.willpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet,Long> {
}

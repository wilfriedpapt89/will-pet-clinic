package com.willpapt.willpetclinic.repository;

import com.willpapt.willpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OwnerRepository extends CrudRepository<Owner,Long> {
    Owner findByLastName(String lastname);
}

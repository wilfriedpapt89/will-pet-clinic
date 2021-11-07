package com.willpapt.willpetclinic.services.springdatajpa;

import com.willpapt.willpetclinic.model.Owner;
import com.willpapt.willpetclinic.repository.OwnerRepository;
import com.willpapt.willpetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerSDJPAService implements OwnerService {

   private final OwnerRepository ownerRepository;

    public OwnerSDJPAService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
     }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> allOwners = new HashSet<>();
        ownerRepository.findAll().forEach(allOwners::add);
        return allOwners;
    }

    @Override
    public Owner findById(Long id) {
        return ownerRepository.findById(id).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        ownerRepository.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }
}

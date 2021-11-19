package com.willpapt.willpetclinic.services.map;

import com.willpapt.willpetclinic.model.Owner;
import com.willpapt.willpetclinic.model.Pet;
import com.willpapt.willpetclinic.services.OwnerService;
import com.willpapt.willpetclinic.services.PetService;
import com.willpapt.willpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Profile({"default", "map"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
     }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {

        if (object != null) {
            if (object.getPets() != null) {
                object.getPets().forEach(pet -> {
                    if (pet.getPetType() != null) {
                        if (pet.getPetType().getId() == null)
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        if (pet.getId() == null) {
                            Pet savedPet = petService.save(pet);
                            pet.setId(savedPet.getId());
                        }
                    } else {
                        throw new RuntimeException("Pet type is required");
                    }
                });
            }
            return super.save(object);
        } else
            return null;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return this.findAll().stream().filter(owner -> owner.getLastName().
                equals(lastName)).findFirst().orElse(null);
    }
}

package com.willpapt.willpetclinic.bootstrap;

import com.willpapt.willpetclinic.model.Owner;
import com.willpapt.willpetclinic.model.Pet;
import com.willpapt.willpetclinic.model.PetType;
import com.willpapt.willpetclinic.model.Vet;
import com.willpapt.willpetclinic.services.OwnerService;
import com.willpapt.willpetclinic.services.PetTypeService;
import com.willpapt.willpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        petTypeService.save(cat);


        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAdress("131 Av Kinanira");
        owner1.setCity("BUJUMBURA");
        owner1.setTelephone("75228754");

        Pet mikePet = new Pet();
        mikePet.setPetType(dog);
        mikePet.setOwner(owner1);
        mikePet.setName("ROSCO");
        mikePet.setBirthDate(LocalDate.now());
        owner1.getPets().add(mikePet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner1.setAdress("8 Av MURINZI");
        owner1.setCity("BUJUMBURA");
        owner1.setTelephone("61188899");

        Pet fionaPet = new Pet();
        fionaPet.setPetType(cat);
        fionaPet.setOwner(owner1);
        fionaPet.setName("JUST CAT");
        fionaPet.setBirthDate(LocalDate.now());
        owner2.getPets().add(fionaPet)
        ;
        ownerService.save(owner2);

        System.out.println("Loaded owners ...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Loaded vets ...");
    }
}

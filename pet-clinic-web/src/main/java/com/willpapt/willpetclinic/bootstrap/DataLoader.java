package com.willpapt.willpetclinic.bootstrap;

import com.willpapt.willpetclinic.model.*;
import com.willpapt.willpetclinic.services.OwnerService;
import com.willpapt.willpetclinic.services.PetTypeService;
import com.willpapt.willpetclinic.services.SpecialtysService;
import com.willpapt.willpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtysService specialtysService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtysService specialtysService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtysService = specialtysService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count == 0)
        loadData();
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        specialtysService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        specialtysService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        specialtysService.save(dentistry);

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
        vet1.getSpecialities().add(radiology);
        vet1.getSpecialities().add(surgery);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(dentistry);

        vetService.save(vet2);

        System.out.println("Loaded vets ...");
    }
}

package com.willpapt.willpetclinic;

import com.willpapt.willpetclinic.services.PetService;
import com.willpapt.willpetclinic.services.PetTypeService;
import com.willpapt.willpetclinic.services.map.OwnerServiceMap;
import com.willpapt.willpetclinic.services.map.VetServiceMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WillPetClinicApplication {

    public static void main(String[] args) {
        SpringApplication.run(WillPetClinicApplication.class, args);
    }

    @Bean
    OwnerServiceMap ownerServiceMap(PetTypeService petTypeService,PetService petService){
        return new OwnerServiceMap(petTypeService, petService);
    }

    @Bean
    VetServiceMap vetServiceMap(){
        return new VetServiceMap();
    }

}

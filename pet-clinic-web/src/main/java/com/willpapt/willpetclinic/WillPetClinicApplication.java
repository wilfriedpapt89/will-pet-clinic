package com.willpapt.willpetclinic;

import com.willpapt.willpetclinic.services.PetService;
import com.willpapt.willpetclinic.services.PetTypeService;
import com.willpapt.willpetclinic.services.map.OwnerServiceMap;
import com.willpapt.willpetclinic.services.map.VetMapService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class WillPetClinicApplication {

    public static void main(String[] args) {
        SpringApplication.run(WillPetClinicApplication.class, args);
    }

    @Bean
    @Profile("map")
    OwnerServiceMap ownerServiceMap(PetTypeService petTypeService,PetService petService){
        return new OwnerServiceMap(petTypeService, petService);
    }

    @Bean
    @Profile("map")
    VetMapService vetServiceMap(){
        return new VetMapService();
    }

}

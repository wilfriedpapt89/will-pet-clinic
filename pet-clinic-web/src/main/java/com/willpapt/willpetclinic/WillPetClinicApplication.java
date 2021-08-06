package com.willpapt.willpetclinic;

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
    OwnerServiceMap ownerServiceMap(){
        return new OwnerServiceMap();
    }

    @Bean
    VetServiceMap vetServiceMap(){
        return new VetServiceMap();
    }

}

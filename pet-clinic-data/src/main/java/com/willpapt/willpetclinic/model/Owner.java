package com.willpapt.willpetclinic.model;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "owners")
@Getter
@Setter
@NoArgsConstructor
public class Owner extends Person{

    @Builder
    public Owner(Long id, String firstName, String lastName, String adress, String city, String telephone, Set<Pet> pets) {
        super(id, firstName, lastName);
        this.adress = adress;
        this.city = city;
        this.telephone = telephone;
        this.pets = pets;
    }

    private String adress;
    private String city;
    private String telephone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

}

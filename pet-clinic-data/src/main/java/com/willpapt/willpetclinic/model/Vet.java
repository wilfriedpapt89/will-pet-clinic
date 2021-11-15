package com.willpapt.willpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vets")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vet extends Person{

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_speciality", joinColumns = @JoinColumn(name = "vet_id"), inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> specialities = new HashSet<>();
}

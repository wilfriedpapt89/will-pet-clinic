package com.willpapt.willpetclinic.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "types")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PetType extends BaseEntity{

    private String name;
}

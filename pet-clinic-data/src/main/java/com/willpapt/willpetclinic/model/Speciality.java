package com.willpapt.willpetclinic.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "speciality")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Speciality extends BaseEntity{

    private String description;
  }

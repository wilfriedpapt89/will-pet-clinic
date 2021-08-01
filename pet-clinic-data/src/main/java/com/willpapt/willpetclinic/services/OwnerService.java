package com.willpapt.willpetclinic.services;

import com.willpapt.willpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner,Long>{

    Owner findByLastName(String lastName);

}

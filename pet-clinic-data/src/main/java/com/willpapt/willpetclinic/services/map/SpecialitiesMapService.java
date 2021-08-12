package com.willpapt.willpetclinic.services.map;

import com.willpapt.willpetclinic.model.Speciality;
import com.willpapt.willpetclinic.services.SpecialitiesService;

import java.util.Set;

public class SpecialitiesMapService extends AbstractMapService<Speciality, Long> implements SpecialitiesService {

    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Speciality object) {
        super.delete(object);
    }

    @Override
    public Speciality save(Speciality object) {
        return save(object);
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }
}

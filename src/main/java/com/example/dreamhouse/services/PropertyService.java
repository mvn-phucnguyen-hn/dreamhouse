package com.example.dreamhouse.services;

import com.example.dreamhouse.models.PropertyEntity;
import com.example.dreamhouse.repositories.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    public List<PropertyEntity> findAll() {
        return propertyRepository.findAll();
    }

    public PropertyEntity findById(UUID id) {
        return propertyRepository.findById(id).orElse(null);
    }

    public PropertyEntity save(PropertyEntity propertyEntity) {
        return propertyRepository.save(propertyEntity);
    }

    public void deleteById(UUID id) {
        propertyRepository.deleteById(id);
    }
}

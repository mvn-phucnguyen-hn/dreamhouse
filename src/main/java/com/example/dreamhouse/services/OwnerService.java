package com.example.dreamhouse.services;

import com.example.dreamhouse.models.OwnerEntity;
import com.example.dreamhouse.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    public List<OwnerEntity> findAll() {
        return ownerRepository.findAll();
    }

    public OwnerEntity findById(UUID id) {
        return ownerRepository.findById(id).orElse(null);
    }

    public OwnerEntity save(OwnerEntity owner) {
        return ownerRepository.save(owner);
    }

    public void deleteById(UUID id) {
        ownerRepository.deleteById(id);
    }
}

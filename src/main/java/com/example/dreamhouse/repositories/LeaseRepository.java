package com.example.dreamhouse.repositories;

import com.example.dreamhouse.models.LeaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LeaseRepository extends JpaRepository<LeaseEntity, UUID> {
}

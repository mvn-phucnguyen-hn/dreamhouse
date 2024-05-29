package com.example.dreamhouse.repositories;

import com.example.dreamhouse.models.MaintenanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MaintenanceRepository extends JpaRepository<MaintenanceEntity, UUID> {
}

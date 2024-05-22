package com.example.dreamhouse.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "maintenances")
public class MaintenanceEntity {

    @Id
    @GeneratedValue
    @Column(name = "request_id")
    private UUID requestId;

    @ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
    private PropertyEntity property;

    @NotNull
    @Size(min = 10, max = 500)
    @Column(name = "description", nullable = false)
    private String description;

    @NotNull
    @Column(name = "request_date", nullable = false)
    private LocalDate requestDate;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "status", nullable = false)
    private String status;
}

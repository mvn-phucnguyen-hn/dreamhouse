package com.example.dreamhouse.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "leases")
public class LeaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "lease_id")
    private UUID leaseId;

    @ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
    private PropertyEntity property;

    @ManyToOne
    @JoinColumn(name = "tenant_id", nullable = false)
    private TenantEntity tenant;

    @NotNull
    @Column(name = "lease_start_date", nullable = false)
    private LocalDate leaseStartDate;

    @NotNull
    @Column(name = "lease_end_date", nullable = false)
    private LocalDate leaseEndDate;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    @Column(name = "rent", nullable = false)
    private BigDecimal rent;
}

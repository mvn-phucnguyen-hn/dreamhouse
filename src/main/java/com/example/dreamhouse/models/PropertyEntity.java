package com.example.dreamhouse.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "properties")
public class PropertyEntity {
    @Id
    @GeneratedValue
    @Column(name = "property_id")
    private UUID propertyId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    private OwnerEntity owner;

    @NotNull
    @Size(min = 10, max = 100)
    @Column(name = "address", nullable = false)
    private String address;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "city", nullable = false)
    private String city;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "state", nullable = false)
    private String state;

    @NotNull
    @Pattern(regexp = "^\\d{5}$")
    @Column(name = "zip_code", nullable = false)
    private String zipCode;

    @NotNull
    @Size(min = 3, max = 50)
    @Column(name = "type", nullable = false)
    private String type;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    @Column(name = "size", nullable = false)
    private Float size;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LeaseEntity> leases;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MaintenanceEntity> maintenanceRequests;
}

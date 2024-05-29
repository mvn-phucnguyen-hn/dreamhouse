package com.example.dreamhouse.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tenants")
public class TenantEntity {

    @Id
    @GeneratedValue
    @Column(name = "tenant_id")
    private UUID tenantId;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotNull
    @Pattern(regexp = "^(\\+\\d{1,3}[- ]?)?\\d{10}$")
    @Column(name = "phone", nullable = false)
    private String phone;

    @NotNull
    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "property_id")
    private PropertyEntity property;
}

package com.mkomafamily.property.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "owners")
public class Owner extends User {

    @Column(name = "business_name")
    private String businessName;

    @Column(name = "ownership_type")
    private String ownershipType; // e.g Individual - Company - Agency

    private Boolean verified;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Property> properties;
}

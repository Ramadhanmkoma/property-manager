package com.mkomafamily.property.model;

import com.mkomafamily.property.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "owners")
public class Owner extends User {

    @Column(name = "business_name")
    private String businessName;

    @Column(name = "ownership_type")
    private String ownershipType; // e.g Individual - Company - Agency

    private Boolean verified;

    public Owner(String fullName, String email, String phone, String password, Role role, String businessName,
            String ownershipType, Boolean verified) {
        super(fullName, email, phone, password, role);
        this.businessName = businessName;
        this.ownershipType = ownershipType;
        this.verified = verified;
    }

    // public Owner(String businessName, String ownershipType, Boolean verified) {
    //     this.businessName = businessName;
    //     this.ownershipType = ownershipType;
    //     this.verified = verified;
    // }

    public Owner() {
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getOwnershipType() {
        return ownershipType;
    }

    public void setOwnershipType(String ownershipType) {
        this.ownershipType = ownershipType;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    

    // @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval =
    // true)
    // @JsonManagedReference
    // private List<Property> properties;

}

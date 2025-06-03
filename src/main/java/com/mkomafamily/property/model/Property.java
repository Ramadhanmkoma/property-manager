package com.mkomafamily.property.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "properties")
@NoArgsConstructor
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer propertyNo;
    private String type;
    private String location;
    private String size;
    private String monthlyRate;
    private String status;
    private String additionalDetails;
    private String block;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    // @JsonBackReference
    private Owner owner;

    public Property(
        Integer propertyNo, String type, String location, String size, String monthlyRate, String status,
            String additionalDetails, String block, Owner owner) {
        this.propertyNo = propertyNo;
        this.type = type;
        this.location = location;
        this.size = size;
        this.monthlyRate = monthlyRate;
        this.status = status;
        this.additionalDetails = additionalDetails;
        this.block = block;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPropertyNo() {
        return propertyNo;
    }

    public void setPropertyNo(Integer propertyNo) {
        this.propertyNo = propertyNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMonthlyRate() {
        return monthlyRate;
    }

    public void setMonthlyRate(String monthlyRate) {
        this.monthlyRate = monthlyRate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAdditionalDetails() {
        return additionalDetails;
    }

    public void setAdditionalDetails(String additionalDetails) {
        this.additionalDetails = additionalDetails;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }


}

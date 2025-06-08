package com.mkomafamily.property.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mkomafamily.property.model.Property;

public interface PropertyRepository extends JpaRepository<Property, Long> {
    long count();
    // find by location (Case Insensitive)
    List<Property> findPropertiesByLocationContainingIgnoreCase(String locationName);
}

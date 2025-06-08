package com.mkomafamily.property.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mkomafamily.property.model.Property;
import com.mkomafamily.property.repository.PropertyRepository;

@Service
public class PropertyService {

    private final PropertyRepository pRepository;

    public PropertyService(PropertyRepository pRepository) {
        this.pRepository = pRepository;
    }

    // Get All Props
    public List<Property> getAllProps() {
        return this.pRepository.findAll();
    }

    // Get One
    public Optional<Property> getPropById(Long id) {
        return this.pRepository.findById(id);
    }

    // get by location
    public List<Property> getPropsByLocation(String locationName) {
        return this.pRepository.findPropertiesByLocationContainingIgnoreCase(locationName);
    }

    // Add New Property or Update
    public Property saveProperty(Property property) {
        return this.pRepository.save(property);
    }

    // delete property
    public void deleteExistingProp(Property property) {
        this.pRepository.delete(property);
    }

    public long getCount() {
        return pRepository.count();
    }
}

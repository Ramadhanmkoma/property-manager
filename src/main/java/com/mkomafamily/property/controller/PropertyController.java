package com.mkomafamily.property.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mkomafamily.property.dto.PropertyDTO;
import com.mkomafamily.property.model.Owner;
import com.mkomafamily.property.model.Property;
import com.mkomafamily.property.service.OwnerService;
import com.mkomafamily.property.service.PropertyService;

// import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/v1/properties")
public class PropertyController {

    private final PropertyService pService;
    private final OwnerService ownerService;

    public PropertyController(PropertyService propertyService, OwnerService ownerService) {
        this.pService = propertyService;
        this.ownerService = ownerService;
    }

    // Get All Properties
    @GetMapping
    public ResponseEntity<List<Property>> getAllProperties() {
        return ResponseEntity.ok(this.pService.getAllProps());
    }

    // Get One By Id
    @GetMapping("/{id}")
    public ResponseEntity<Property> getPropById(@PathVariable Long id) {
        Property property = this.pService.getPropById(id).orElseThrow(
                () -> new RuntimeException("No Property was Found"));

        return ResponseEntity.ok(property);
    }

    // Find By Location
    @GetMapping("/search")
    public ResponseEntity<List<Property>> searchPropsByLocation(@RequestParam String locationName) {
        return ResponseEntity.ok(this.pService.getPropsByLocation(locationName));
    }

    // Add New Prop
    @PostMapping
    public ResponseEntity<Property> addNewProp(@RequestBody PropertyDTO propertyDto) {

        Owner owner = ownerService.getOwnerById(propertyDto.getOwnerId()).orElseThrow(
                () -> new RuntimeException("Owner not found"));

        Property property = new Property(
                propertyDto.getPropertyNo(),
                propertyDto.getType(),
                propertyDto.getLocation(),
                propertyDto.getSize(),
                propertyDto.getMonthlyRate(),
                propertyDto.getStatus(),
                propertyDto.getAdditionalDetails(),
                propertyDto.getBlock(),
                owner);

        Property newProperty = this.pService.saveProperty(property);
        return new ResponseEntity<>(newProperty, HttpStatus.CREATED);
    }

    // UPdate Prop
    @PutMapping("/update/{id}")
    public ResponseEntity<Property> updateProperty(@PathVariable Long id, @RequestBody Property property) {
        Property propToUpdated = pService.getPropById(id).orElseThrow(
                () -> new RuntimeException("Property Selected Does not Exist"));

        propToUpdated.setAdditionalDetails(property.getAdditionalDetails());
        propToUpdated.setBlock(property.getBlock());
        propToUpdated.setLocation(property.getLocation());
        propToUpdated.setMonthlyRate(property.getMonthlyRate());
        propToUpdated.setOwner(property.getOwner());
        propToUpdated.setPropertyNo(property.getPropertyNo());
        propToUpdated.setSize(property.getSize());
        propToUpdated.setStatus(property.getStatus());
        propToUpdated.setType(property.getType());

        Property updatedProperty = pService.saveProperty(propToUpdated);

        return new ResponseEntity<>(updatedProperty, HttpStatus.OK);
    }

    // Delete Specific
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProp(@PathVariable Long id) {
        Property propertyToDelete = pService.getPropById(id).orElseThrow(
                () -> new RuntimeException("Unable to Delete! \"Property Does not Exist\""));

        pService.deleteExistingProp(propertyToDelete);

        return ResponseEntity.ok("Property Deleted!");
    }
}

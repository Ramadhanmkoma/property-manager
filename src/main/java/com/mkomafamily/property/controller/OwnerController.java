package com.mkomafamily.property.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
// import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mkomafamily.property.model.Owner;
import com.mkomafamily.property.service.OwnerService;

@RestController
@RequestMapping("/api/owners")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    // Get All API Below
    @GetMapping
    public ResponseEntity<List<Owner>> getAllOwners() {
        return ResponseEntity.ok(ownerService.getAllOwners());
    }

    // GET By Id
    @GetMapping("/{id}")
    public ResponseEntity<Owner> getOwmerById(@PathVariable Long id) {
        Owner owner = ownerService.getOwnerById(id).orElseThrow(
                () -> new RuntimeException("Owner with id: [" + id + "] Does not Exist"));

        return new ResponseEntity<>(owner, HttpStatus.OK);
    }

    // Register Owner
    @PostMapping
    public ResponseEntity<Owner> registerOwner(@RequestBody Owner owner) {
        Owner newOwner = ownerService.saveOwner(owner);
        return new ResponseEntity<>(newOwner, HttpStatus.CREATED);
    }

    // Update Existing Owner
    @PutMapping("/update/{id}")
    public ResponseEntity<Owner> updateOwner(@PathVariable Long id, @RequestBody Owner owner) {
        Owner ownerToUpdate = ownerService.getOwnerById(id).orElseThrow(
                () -> new RuntimeException("Owner Not Found"));

        ownerToUpdate.setFullName(owner.getFullName());
        ownerToUpdate.setEmail(owner.getEmail());
        ownerToUpdate.setPhone(owner.getPhone());
        // ownerToUpdate.setPassword(owner.getPassword());

        // Only update password if provided
        if (owner.getPassword() != null && !owner.getPassword().isBlank()) {
            ownerToUpdate.setPassword(owner.getPassword());
        }

        Owner updatedOwner = ownerService.saveOwner(ownerToUpdate);

        return new ResponseEntity<>(updatedOwner, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteOwner(@PathVariable Long id) {
        Owner owner = ownerService.getOwnerById(id).orElseThrow(
                () -> new RuntimeException("Owner with id: [" + id + "] Does not Exists"));
        ownerService.deleteOwner(owner);

        return ResponseEntity.ok("Owner Deleted Successfully");
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<?> deleAllOwners() {
        ownerService.deleteAllOwners();

        return ResponseEntity.ok("All Owners were deleted Successfully");
    }
}

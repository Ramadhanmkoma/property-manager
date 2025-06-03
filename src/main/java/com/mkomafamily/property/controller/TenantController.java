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

import com.mkomafamily.property.model.Tenant;
import com.mkomafamily.property.service.TenantService;

@RestController // Tells Spring boot that this will be our REST Resource
@RequestMapping("/api/tenants")
public class TenantController {

    private final TenantService tService;

    public TenantController(TenantService tService) {
        this.tService = tService;
    }

    // Get All Tenants
    @GetMapping
    public ResponseEntity<List<Tenant>> getTenants() {
        return ResponseEntity.ok(this.tService.getAllTenants());
    }

    // Get Tenant By Id -> Returns only one
    @GetMapping("/{id}")
    public ResponseEntity<Tenant> getTenantById(@PathVariable Long id) {
        Tenant tenant = this.tService.getTenantById(id).orElseThrow(
                () -> new RuntimeException("Tenant not found"));

        return ResponseEntity.ok(tenant);
    }

    // Search Tenant using query params
    @GetMapping("/search")
    public ResponseEntity<List<Tenant>> searchTenantByName(@RequestParam String name) {
        return ResponseEntity.ok(this.tService.getTenantsByName(name));
    }

    // Add New Tenant
    @PostMapping("/save")
    public ResponseEntity<Tenant> saveTenant(@RequestBody Tenant tenant) {
        Tenant newTenant = tService.saveTenant(tenant);
        return new ResponseEntity<>(newTenant, HttpStatus.CREATED);
    }

    // Update Tenant
    @PutMapping("/update/{id}")
    public ResponseEntity<Tenant> updateTenant(@PathVariable Long id, @RequestBody Tenant tenant) {
        Tenant tenantToUpdate = tService.getTenantById(id).orElseThrow(
                () -> new RuntimeException("Tenant with id: " + id + " was not found"));

        tenantToUpdate.setName(tenant.getName());
        tenantToUpdate.setGender(tenant.getGender());
        tenantToUpdate.setDob(tenant.getDob());
        tenantToUpdate.setEmail(tenant.getEmail());
        tenantToUpdate.setOccupation(tenant.getOccupation());
        tenantToUpdate.setPhone(tenant.getPhone());
        tenantToUpdate.setReligion(tenant.getReligion());
        tenantToUpdate.setAdditionalNotes(tenant.getAdditionalNotes());

        Tenant updatedTenant = tService.saveTenant(tenantToUpdate);

        return new ResponseEntity<>(updatedTenant, HttpStatus.OK);
    }

    // Delete Tenant
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTenant(@PathVariable Long id, Tenant tenant) {
        tenant = this.tService.getTenantById(id).orElseThrow(
            () -> new RuntimeException("Tenant Does not exist")
        );

        this.tService.deleteTenant(tenant);

        return ResponseEntity.ok("Tenant Deleted Successfully");
    }

}

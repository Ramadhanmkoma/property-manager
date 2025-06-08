package com.mkomafamily.property.controller;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mkomafamily.property.dto.PaginatedResponse;
import com.mkomafamily.property.dto.TenantRegistrationReq;
import com.mkomafamily.property.enums.Role;
import com.mkomafamily.property.model.Tenant;
import com.mkomafamily.property.service.TenantService;

@RestController // Tells Spring boot that this will be our REST Resource
@RequestMapping("/api/v1/tenants")
public class TenantController {

    private final TenantService tService;
    private final PasswordEncoder passwordEncoder;

    public TenantController(TenantService tService, PasswordEncoder passwordEncoder) {
        this.tService = tService;
        this.passwordEncoder = passwordEncoder;
    }

    // Get All Tenants
    @GetMapping
    public ResponseEntity<PaginatedResponse<Tenant>> getTenants(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Page<Tenant> tenPage = this.tService.getAllTenants(page, size);
        PaginatedResponse<Tenant> reponse = new PaginatedResponse<>(
                tenPage.getTotalElements(), tenPage.getNumber(), tenPage.getTotalPages(), tenPage.getContent());

        return ResponseEntity.ok(reponse);
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
    @PostMapping("/register")
    public ResponseEntity<Tenant> saveTenant(@RequestBody TenantRegistrationReq request) {

        String encodedPassword = passwordEncoder.encode(request.getPassword());

        Tenant tenant = new Tenant();
        tenant.setEmail(request.getEmail());
        tenant.setFullName(request.getFullName());
        tenant.setDob(request.getDob());
        tenant.setRole(Role.TENANT);
        tenant.setGender(request.getGender());
        tenant.setOccupation(request.getOccupation());
        tenant.setPhone(request.getPhone());
        tenant.setReligion(request.getReligion());
        tenant.setAdditionalNotes(request.getAdditionalNotes());
        tenant.setPassword(encodedPassword);

        Tenant newTenant = tService.saveTenant(tenant);
        return new ResponseEntity<>(newTenant, HttpStatus.CREATED);
    }

    // Update Tenant
    @PutMapping("/update/{id}")
    public ResponseEntity<Tenant> updateTenant(@PathVariable Long id, @RequestBody Tenant tenant) {
        Tenant tenantToUpdate = tService.getTenantById(id).orElseThrow(
                () -> new RuntimeException("Tenant with id: " + id + " was not found"));

        // tenantToUpdate.setName(tenant.getName());
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

    // @PatchMapping("/role/{id}")
    // public ResponseEntity<Tenant> updateRole(@PathVariable Long id, @RequestBody
    // Role role) {
    // Tenant tenant = tService.getTenantById(id).orElseThrow(
    // () -> new RuntimeException("Tenant not found")
    // );

    // tenant.setRole(role);

    // return ResponseEntity.ok(tService.saveTenant(tenant));
    // }

    // Delete Tenant
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTenant(@PathVariable Long id, Tenant tenant) {
        tenant = this.tService.getTenantById(id).orElseThrow(
                () -> new RuntimeException("Tenant Does not exist"));

        this.tService.deleteTenant(tenant);

        return ResponseEntity.ok("Tenant Deleted Successfully");
    }

    @GetMapping("/count")
    public Map<String, Long> getTenantCount() {
        long count = tService.getCount();
        return Map.of("totalTenants", count);
    }

}

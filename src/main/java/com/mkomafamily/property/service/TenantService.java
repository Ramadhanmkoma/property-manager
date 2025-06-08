package com.mkomafamily.property.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.mkomafamily.property.model.Tenant;
import com.mkomafamily.property.repository.TenantRepository;

@Service
public class TenantService {
    private final TenantRepository tenantRepository;

    public TenantService(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }

    // Get all tenants
    public Page<Tenant> getAllTenants(int page, int size) {
        return tenantRepository.findAll(PageRequest.of(page, size));
    }

    // Get By Id
    public Optional<Tenant> getTenantById(Long id) {
        return tenantRepository.findById(id);
    }

    // Get Tenants by phone numbers
    // public List<Tenant> getTenantsByPhone(String phone) {
    //     return this.tenantRepository.findTenantsByPhone(phone);
    // }

    // Get tenants by name
    public List<Tenant> getTenantsByName(String name) {
        return this.tenantRepository.findTenantsByFullNameContainingIgnoreCase(name);
    }

    // Save New Tenant
    public Tenant saveTenant(Tenant tenant) {
        return tenantRepository.save(tenant);
    }

    // Delete Existing Tenant
    public void deleteTenant(Tenant tenant) {
        this.tenantRepository.delete(tenant);
    }

    public long getCount() {
        return tenantRepository.count();
    }
}

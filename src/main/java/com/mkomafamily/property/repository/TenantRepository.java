package com.mkomafamily.property.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mkomafamily.property.model.Tenant;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Long> {

    long count();
    // find Tenant By Phone Number
    // List<Tenant> findTenantsByPhone(String phone);

    // find Tenant by containing name (Case Insensitive)
    List<Tenant> findTenantsByFullNameContainingIgnoreCase(String name);
}

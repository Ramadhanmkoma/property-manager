package com.mkomafamily.property.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mkomafamily.property.model.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
    
    // search by owner name
    List<Owner> findOwnersByFullNameContainingIgnoreCase(String fullName);

    // find by Email
    Optional<Owner> findByEmail(String email);
}

package com.mkomafamily.property.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mkomafamily.property.model.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
    long count();
    // search by owner name
    List<Owner> findOwnersByFullNameContainingIgnoreCase(String fullName);

    // find by Email
    Optional<Owner> findByEmail(String email);
}

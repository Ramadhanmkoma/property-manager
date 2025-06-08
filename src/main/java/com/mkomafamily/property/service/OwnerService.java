package com.mkomafamily.property.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mkomafamily.property.model.Owner;
import com.mkomafamily.property.repository.OwnerRepository;

@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;
    private final PasswordEncoder passwordEncoder;

    public OwnerService(OwnerRepository ownerRepository, PasswordEncoder passwordEncoder) {
        this.ownerRepository = ownerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Fetch All Owners
    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    // Fetch By Id
    public Optional<Owner> getOwnerById(Long id) {
        return ownerRepository.findById(id);
    }

    // Search Owners By Names
    public List<Owner> searchOwners(String fullName) {
        return ownerRepository.findOwnersByFullNameContainingIgnoreCase(fullName);
    }

    // Add new or update Owner -> Intelligent Enough to detect
    public Owner saveOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    // Delete Existing Owner
    public void deleteOwner(Owner owner) {
        ownerRepository.delete(owner);
    }

    // Delete All Owners
    public void deleteAllOwners() {
        ownerRepository.deleteAll();
    }

    // Login For Owners
    public Owner login(String email, String rawPassword) {
        Owner owner = ownerRepository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Invalid Email or Password"));

        if (!passwordEncoder.matches(rawPassword, owner.getPassword())) {
            throw new RuntimeException("Invalid Email or Password");
        }

        return owner;
    }

    public long getOwnerCount() {
        return ownerRepository.count();
    }
}

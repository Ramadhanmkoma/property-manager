package com.mkomafamily.property.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mkomafamily.property.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}

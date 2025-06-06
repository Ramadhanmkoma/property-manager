package com.mkomafamily.property.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mkomafamily.property.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}

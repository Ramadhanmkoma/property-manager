package com.mkomafamily.property.model;

import java.time.LocalDateTime;

import com.mkomafamily.property.enums.AdminLevel;
import com.mkomafamily.property.enums.Permission;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "admins")
public class Admin extends User {
    @Enumerated(EnumType.STRING)
    private AdminLevel level;

    @Enumerated(EnumType.STRING)
    private Permission accessLevel;
    private LocalDateTime lastLogin;

}

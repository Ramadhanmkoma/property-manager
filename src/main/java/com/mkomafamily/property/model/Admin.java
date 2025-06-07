package com.mkomafamily.property.model;

import java.time.LocalDateTime;

import com.mkomafamily.property.enums.AdminLevel;
import com.mkomafamily.property.enums.Permission;
import com.mkomafamily.property.enums.Role;

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

    public Admin() {
    }

    public Admin(String fullName, String email, String phone, String password, AdminLevel level,
            Permission accessLevel) {
        super(fullName, email, phone, password, Role.ADMIN);
        this.level = level;
        this.accessLevel = accessLevel;
        this.lastLogin = LocalDateTime.now();
    }

    public AdminLevel getLevel() {
        return level;
    }

    public void setLevel(AdminLevel level) {
        this.level = level;
    }

    public Permission getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(Permission accessLevel) {
        this.accessLevel = accessLevel;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + getId() +
                ", fullName='" + getFullName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", phone='" + getPhone() + '\'' +
                ", level=" + level +
                ", accessLevel=" + accessLevel +
                ", lastLogin=" + lastLogin +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Admin admin)) return false;
        if (!super.equals(o)) return false;
        return level == admin.level && accessLevel == admin.accessLevel && lastLogin.equals(admin.lastLogin);
    }
}

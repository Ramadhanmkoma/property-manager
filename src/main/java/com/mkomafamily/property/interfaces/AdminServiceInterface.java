package com.mkomafamily.property.interfaces;

import java.util.List;

import com.mkomafamily.property.model.Admin;

public interface AdminServiceInterface {
    List<Admin> getAllAdmins();
    Admin getAdminById(Long id);
    Admin saveAdmin(Admin admin);
    void deleteAdmin(Long id);   
}

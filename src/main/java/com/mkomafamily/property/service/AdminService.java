package com.mkomafamily.property.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mkomafamily.property.interfaces.AdminServiceInterface;
import com.mkomafamily.property.model.Admin;
import com.mkomafamily.property.repository.AdminRepository;

@Service
public class AdminService implements AdminServiceInterface {

    private final AdminRepository adminRepository;
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }
    
    // Implement the methods defined in AdminServiceInterface
    @Override
    public List<Admin> getAllAdmins() {
        // Logic to retrieve all admins
        return adminRepository.findAll(); // Assuming adminRepository has a findAll method
    }

    @Override
    public Admin getAdminById(Long id) {
        // Logic to retrieve an admin by ID
        return adminRepository.findById(id).orElse(null); // Assuming adminRepository has a findById method
    }

    @Override
    public Admin saveAdmin(Admin admin) {
        // Logic to save an admin
        return adminRepository.save(admin); // Assuming adminRepository has a save method
    }

    @Override
    public void deleteAdmin(Long id) {
        // Logic to delete an admin by ID
        adminRepository.deleteById(id); // Assuming adminRepository has a deleteById method
    }
}

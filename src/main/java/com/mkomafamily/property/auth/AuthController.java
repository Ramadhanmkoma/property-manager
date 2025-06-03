package com.mkomafamily.property.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mkomafamily.property.dto.LoginRequest;
import com.mkomafamily.property.dto.LoginResponse;
import com.mkomafamily.property.model.Owner;
import com.mkomafamily.property.service.OwnerService;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private OwnerService ownerService;

    public AuthController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            Owner owner = ownerService.login(request.getEmail(), request.getPassword());

            return ResponseEntity.ok(new LoginResponse("Login successful", owner.getId()));
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }
    
}

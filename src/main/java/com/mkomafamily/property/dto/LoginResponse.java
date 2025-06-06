package com.mkomafamily.property.dto;

import com.mkomafamily.property.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    private String email;
    private String token;
    private Role role;
    private String message;
}

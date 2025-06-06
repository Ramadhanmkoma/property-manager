package com.mkomafamily.property.dto;

import java.time.LocalDate;

import com.mkomafamily.property.enums.AccountStatus;

import lombok.Data;

@Data
public class TenantRegistrationReq {
    private String fullName;
    private String email;
    private String phone;
    private String password;
    // private Role role;
    private AccountStatus status;
    private String gender;
    private String occupation;
    private String religion;
    private LocalDate dob;
    private String additionalNotes;
}

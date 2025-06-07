package com.mkomafamily.property.dto;

import com.mkomafamily.property.enums.AccountStatus;

import lombok.Data;

@Data
public class OwnerRegistrationReq {
    private String fullName;
    private String email;
    private String phone;
    private String password;
    private String businessName;
    private String ownershipType;
    private Boolean verified;
    private AccountStatus status;
}

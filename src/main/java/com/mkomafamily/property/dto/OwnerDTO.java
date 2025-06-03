package com.mkomafamily.property.dto;

import java.util.List;

import com.mkomafamily.property.model.Property;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OwnerDTO {
    private Long id;
    private String fullName;
    private String email;
    private String phone;
    private List<Property> properties;
}

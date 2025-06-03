package com.mkomafamily.property.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PropertyDTO {
    private Integer propertyNo;
    private String type;
    private String location;
    private String size;
    private String monthlyRate;
    private String status;
    private String additionalDetails;
    private String block;
    private Long ownerId;
}

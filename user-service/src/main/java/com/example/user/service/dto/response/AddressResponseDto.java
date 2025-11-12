package com.example.user.service.dto.response;

import lombok.Data;

@Data
public class AddressResponseDto {
    private Long id;
    private String street;
    private String city;
    private String zip;
    private String state;
    private String country;
}

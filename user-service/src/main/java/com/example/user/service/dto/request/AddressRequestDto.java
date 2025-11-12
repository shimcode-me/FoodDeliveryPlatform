package com.example.user.service.dto.request;

import lombok.Data;

@Data
public class AddressRequestDto {
    private String street;
    private String city;
    private String zip;
    private String state;
    private String country;
}

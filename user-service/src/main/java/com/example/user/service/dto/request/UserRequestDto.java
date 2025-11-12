package com.example.user.service.dto;

import com.example.user.service.dto.request.AddressRequestDto;
import lombok.Data;
import java.util.Set;

@Data
public class UserRequestDto {
    private String fullName;
    private String email;
    private String password;
    private Set<AddressRequestDto> addresses;
}

package com.example.user.service.dto;

import lombok.Data;

@Data
public class LoginRequestDto {
    private String email;
    private String password;
}

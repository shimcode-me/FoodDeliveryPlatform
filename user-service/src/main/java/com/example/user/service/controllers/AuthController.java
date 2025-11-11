package com.example.user.service.controllers;

import com.example.user.service.dto.LoginRequestDto;
import com.example.user.service.dto.LoginResponseDto;
import com.example.user.service.dto.UserRequestDto;
import com.example.user.service.dto.UserResponseDto;
import com.example.user.service.services.AuthServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthServices authServices;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> register(@RequestBody UserRequestDto dto) {
        return ResponseEntity.ok(authServices.register(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto dto) {
        return ResponseEntity.ok(authServices.login(dto));
    }
}

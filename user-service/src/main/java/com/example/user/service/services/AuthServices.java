package com.example.user.service.services;

import com.example.user.service.dto.LoginRequestDto;
import com.example.user.service.dto.LoginResponseDto;
import com.example.user.service.dto.UserRequestDto;
import com.example.user.service.dto.UserResponseDto;
import com.example.user.service.entities.Users;
import com.example.user.service.mapper.UserMapper;
import com.example.user.service.repositories.UsersRepositories;
import com.example.user.service.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServices {

    private final UsersRepositories usersRepositories;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public UserResponseDto register(UserRequestDto dto) {
        if (usersRepositories.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email already in use");
        }

        Users user = userMapper.toEntity(dto);
        user.setPasswordHash(passwordEncoder.encode(dto.getPassword()));
        return userMapper.toDto(usersRepositories.save(user));
    }

    public LoginResponseDto login(LoginRequestDto dto) {
        Users user = usersRepositories.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (!passwordEncoder.matches(dto.getPassword(), user.getPasswordHash())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtService.generateToken(user);
        return new LoginResponseDto(token);
    }
}

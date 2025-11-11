package com.example.user.service.services;

import com.example.user.service.dto.UserRequestDto;
import com.example.user.service.dto.UserResponseDto;
import com.example.user.service.entities.Users;
import com.example.user.service.mapper.UserMapper;
import com.example.user.service.repositories.UsersRepositories;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServices {

    private final UsersRepositories usersRepositories;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public UserResponseDto createUser(UserRequestDto dto) {
        Users user = userMapper.toEntity(dto);
        user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        return userMapper.toDTO(usersRepositories.save(user));
    }

    public List<UserResponseDto> getAllUsers() {
        return usersRepositories.findAll()
                .stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    public UserResponseDto getUserById(Long id) {
        return usersRepositories.findById(id)
                .map(userMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public UserResponseDto updateUser(Long id, UserRequestDto dto) {
        return usersRepositories.findById(id)
                .map(user -> {
                    user.setFullName(dto.getFullName());
                    user.setEmail(dto.getEmail());
                    if (dto.getPassword() != null && !dto.getPassword().isBlank()) {
                        user.setPasswordHash(passwordEncoder.encode(dto.getPassword()));
                    }
                    /*user.setRoleId(dto.getRoleId());
                    user.setAddressId(dto.getAddressId());*/
                    user.setUpdatedAt(LocalDateTime.now());
                    return userMapper.toDTO(usersRepositories.save(user));
                }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteUser(Long id) {
        usersRepositories.deleteById(id);
    }
}

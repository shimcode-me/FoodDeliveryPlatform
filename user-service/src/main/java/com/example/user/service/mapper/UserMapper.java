package com.example.user.service.mapper;

import com.example.user.service.dto.UserRequestDto;
import com.example.user.service.dto.UserResponseDto;
import com.example.user.service.entities.Users;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public Users toEntity(UserRequestDto dto) {
            Users user = new Users();
            user.setFullName(dto.getFullName());
            user.setEmail(dto.getEmail());
            user.setPasswordHash(dto.getPassword());
            /*user.setRoleId(dto.getRoleId());
            user.setAddressId(dto.getAddressId());*/
            return user;
        }

    public UserResponseDto toDTO(Users user) {
            UserResponseDto dto = new UserResponseDto();
            dto.setId(user.getId());
            dto.setFullName(user.getFullName());
            dto.setEmail(user.getEmail());
            /*dto.setRoleIds(user.getRoleId());
            dto.setAddressIds(user.getAddressId());*/
            dto.setCreatedAt(user.getCreatedAt());
            dto.setUpdatedAt(user.getUpdatedAt());
            return dto;
        }
    }

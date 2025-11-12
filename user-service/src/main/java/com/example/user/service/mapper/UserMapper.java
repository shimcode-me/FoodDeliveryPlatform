package com.example.user.service.mapper;

import com.example.user.service.dto.UserRequestDto;
import com.example.user.service.dto.UserResponseDto;
import com.example.user.service.dto.request.AddressRequestDto;
import com.example.user.service.dto.response.AddressResponseDto;
import com.example.user.service.entities.Addresses;
import com.example.user.service.entities.Users;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public Users toEntity(UserRequestDto dto) {
        Users user = new Users();
        user.setFullName(dto.getFullName());
        user.setEmail(dto.getEmail());
        user.setPasswordHash(dto.getPassword());
        return user;
        }

    public UserResponseDto toDto(Users user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setFullName(user.getFullName());
        dto.setEmail(user.getEmail());
        dto.setCreatedAt(user.getCreatedAt());
        dto.setUpdatedAt(user.getUpdatedAt());
        return dto;
        }
    public Addresses toAddressEntity(AddressRequestDto dto, Users user) {
        Addresses address = new Addresses();
        address.setStreet(dto.getStreet());
        address.setCity(dto.getCity());
        address.setZip(dto.getZip());
        address.setState(dto.getState());
        address.setCountry(dto.getCountry());
        address.setUser(user);
        return address;
    }

    public AddressResponseDto toAddressDto(Addresses address) {
        AddressResponseDto dto = new AddressResponseDto();
        dto.setId(address.getId());
        dto.setStreet(address.getStreet());
        dto.setCity(address.getCity());
        dto.setZip(address.getZip());
        dto.setState(address.getState());
        dto.setCountry(address.getCountry());
        return dto;
    }

}

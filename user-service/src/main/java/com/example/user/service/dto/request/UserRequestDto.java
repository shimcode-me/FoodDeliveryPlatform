package com.example.user.service.dto;

import lombok.Data;
import java.util.Set;

@Data
public class UserRequestDto {
    private String fullName;
    private String email;
    private String password;
    /*private Set<Long> roleIds;
    private Set<Long> addressIds;*/
}

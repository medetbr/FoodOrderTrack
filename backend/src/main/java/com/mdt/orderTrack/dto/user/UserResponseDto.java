package com.mdt.orderTrack.dto.user;

import lombok.Data;

@Data
public class UserResponseDto {
    private String name;
    private String surname;
    private String username;
    private String email;
    private Boolean isCustomer;
}

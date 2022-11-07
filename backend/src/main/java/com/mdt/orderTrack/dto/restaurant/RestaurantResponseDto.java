package com.mdt.orderTrack.dto.restaurant;

import com.mdt.orderTrack.dto.user.UserResponseDto;
import lombok.Data;

@Data
public class RestaurantResponseDto {
    private String restaurantCode;
    private UserResponseDto user;
    private String name;
    private String description;
    private String address;
    private Integer rating;
}

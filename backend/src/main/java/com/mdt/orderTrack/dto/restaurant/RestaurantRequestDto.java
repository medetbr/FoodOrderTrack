package com.mdt.orderTrack.dto.restaurant;

import lombok.Data;

@Data
public class RestaurantRequestDto {
    private String username;
    private String name;
    private String description;
    private String address;
}

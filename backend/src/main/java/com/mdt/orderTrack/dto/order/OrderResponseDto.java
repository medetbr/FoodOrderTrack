package com.mdt.orderTrack.dto.order;

import com.mdt.orderTrack.dto.orderItem.OrderItemResponseDto;
import com.mdt.orderTrack.dto.restaurant.RestaurantResponseDto;
import com.mdt.orderTrack.dto.user.UserResponseDto;
import lombok.Data;

import java.util.List;

@Data
public class OrderResponseDto {
    private String orderCode;
    private UserResponseDto user;
    private String address;
    private String description;
    private Double total;
    private List<OrderItemResponseDto> foodItems;
    private RestaurantResponseDto restaurant;
}

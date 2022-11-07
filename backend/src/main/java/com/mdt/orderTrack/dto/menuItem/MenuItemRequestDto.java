package com.mdt.orderTrack.dto.menuItem;

import lombok.Data;

@Data
public class MenuItemRequestDto {
    private Double price;
    private String foodItemCode;
    private String restaurantCode;
}

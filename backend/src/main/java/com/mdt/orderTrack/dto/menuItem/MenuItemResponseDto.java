package com.mdt.orderTrack.dto.menuItem;

import com.mdt.orderTrack.dto.foodItem.FoodItemResponseDto;
import lombok.Data;

@Data
public class MenuItemResponseDto {
    private FoodItemResponseDto foodItem;
    private String menuItemCode;
    private Double price;
}

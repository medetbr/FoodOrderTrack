package com.mdt.orderTrack.dto.restaurant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuItemsOfRestaurantDto {
    private String name;
    private Double price;
    private String categoryName;
    private String menuItemCode;
}

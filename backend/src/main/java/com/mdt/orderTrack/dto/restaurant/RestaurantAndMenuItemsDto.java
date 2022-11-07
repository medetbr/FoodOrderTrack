package com.mdt.orderTrack.dto.restaurant;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class RestaurantAndMenuItemsDto {
    private RestaurantResponseDto restaurant;
    private Map<String, List<MenuItemsOfRestaurantDto>> foods;
}

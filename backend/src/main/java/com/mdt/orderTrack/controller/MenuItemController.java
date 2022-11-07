package com.mdt.orderTrack.controller;

import com.mdt.orderTrack.dto.menuItem.MenuItemRequestDto;
import com.mdt.orderTrack.dto.restaurant.RestaurantAndMenuItemsDto;
import com.mdt.orderTrack.service.MenuItemService;
import com.mdt.orderTrack.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu-items")
@RequiredArgsConstructor
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class MenuItemController {
    private final MenuItemService menuItemService;
    private final RestaurantService restaurantService;
    @PostMapping("/")
    public void createMenuItem(@RequestBody List<MenuItemRequestDto> menuItemRequestDtoList){
        menuItemService.insert(menuItemRequestDtoList);
    }
    @GetMapping("/{restaurantCode}")
    public RestaurantAndMenuItemsDto getRestaurantMenuItemsDtoList(@PathVariable String restaurantCode){
        return menuItemService.findAllRestaurantMenuItemsByRestaurantId(restaurantCode);
    }
}

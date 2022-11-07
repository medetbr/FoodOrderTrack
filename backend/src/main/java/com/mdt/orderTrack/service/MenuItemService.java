package com.mdt.orderTrack.service;

import com.mdt.orderTrack.dto.menuItem.MenuItemRequestDto;
import com.mdt.orderTrack.dto.restaurant.RestaurantAndMenuItemsDto;
import com.mdt.orderTrack.entity.FoodItem;
import com.mdt.orderTrack.entity.MenuItem;
import com.mdt.orderTrack.repository.MenuItemRepository;
import com.mdt.orderTrack.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MenuItemService {
    private final MenuItemRepository menuItemRepository;
    private final FoodItemService foodItemService;
    private final RestaurantService restaurantService;

    public void insert(List<MenuItemRequestDto> menuItemRequestDtoList){
        for (MenuItemRequestDto menuItemRequestDto : menuItemRequestDtoList) {
            MenuItem menuItem = createNewMenuItem(menuItemRequestDto);
            menuItemRepository.save(menuItem);
        }

    }

    private MenuItem createNewMenuItem(MenuItemRequestDto menuItemRequestDto) {
        MenuItem menuItem = new MenuItem();
        menuItem.setPrice(menuItemRequestDto.getPrice());
        menuItem.setFoodItem(foodItemService.findByFoodItemCode(menuItemRequestDto.getFoodItemCode()));
        menuItem.setRestaurant(restaurantService.findByRestaurantCode(menuItemRequestDto.getRestaurantCode()));
        menuItem.setMenuItemCode(UUID.randomUUID().toString().split("-")[0]);
        return menuItem;
    }

    public MenuItem findByMenuItemCode(String menuItemCode) {
        return menuItemRepository.findByMenuItemCode(menuItemCode);
    }
    public RestaurantAndMenuItemsDto findAllRestaurantMenuItemsByRestaurantId(String restaurantCode) {
        return restaurantService.findAllGetRestaurantMenuItemsByRestaurantId(restaurantCode);
    }
}

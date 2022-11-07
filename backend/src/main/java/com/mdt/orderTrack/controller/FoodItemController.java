package com.mdt.orderTrack.controller;

import com.mdt.orderTrack.dto.foodItem.FoodItemRequestDto;
import com.mdt.orderTrack.dto.foodItem.FoodItemResponseDto;
import com.mdt.orderTrack.service.FoodItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/food-items")
@RequiredArgsConstructor
public class FoodItemController {
    private final FoodItemService foodItemService;
    @PostMapping("/")
    public FoodItemResponseDto createFoodItem(@RequestBody FoodItemRequestDto foodItemRequestDto){
        return foodItemService.insert(foodItemRequestDto);
    }
}

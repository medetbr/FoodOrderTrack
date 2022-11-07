package com.mdt.orderTrack.service;

import com.mdt.orderTrack.dto.foodItem.FoodItemRequestDto;
import com.mdt.orderTrack.dto.foodItem.FoodItemResponseDto;
import com.mdt.orderTrack.entity.Category;
import com.mdt.orderTrack.entity.FoodItem;
import com.mdt.orderTrack.repository.FoodItemRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FoodItemService {
    private final ModelMapper modelMapper;
    private final FoodItemRepository foodItemRepository;
    private final CategoryService categoryService;
    public FoodItemResponseDto insert(FoodItemRequestDto foodItemRequestDto){
        FoodItem foodItem = createNewFood(foodItemRequestDto);
        foodItemRepository.save(foodItem);
        return modelMapper.map(foodItem,FoodItemResponseDto.class);
    }

    private FoodItem createNewFood(FoodItemRequestDto foodItemRequestDto) {
        FoodItem foodItem = new FoodItem();
        foodItem.setName(foodItemRequestDto.getName());
        foodItem.setFoodItemCode(UUID.randomUUID().toString().split("-")[0]);
        foodItem.setCategory(categoryService.findByCategoryCode(foodItemRequestDto.getCategoryCode()));
        return foodItem;
    }

    public FoodItem findByFoodItemCode(String foodItemCode) {
        return foodItemRepository.findByFoodItemCode(foodItemCode);
    }
}

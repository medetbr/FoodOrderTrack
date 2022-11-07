package com.mdt.orderTrack.service;

import com.mdt.orderTrack.dto.restaurant.MenuItemsOfRestaurantDto;
import com.mdt.orderTrack.dto.restaurant.RestaurantAndMenuItemsDto;
import com.mdt.orderTrack.dto.restaurant.RestaurantRequestDto;
import com.mdt.orderTrack.dto.restaurant.RestaurantResponseDto;
import com.mdt.orderTrack.entity.Restaurant;
import com.mdt.orderTrack.entity.User;
import com.mdt.orderTrack.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;
    public void insert(RestaurantRequestDto restaurantRequestDto){
        Restaurant restaurant = createNewRestaurant(restaurantRequestDto);
        restaurantRepository.save(restaurant);
    }

    private Restaurant createNewRestaurant(RestaurantRequestDto shopRequest) {
        Restaurant restaurant = new Restaurant();
        User user = userService.findByUsername(shopRequest.getUsername());
        restaurant.setName(shopRequest.getName());
        restaurant.setUser(user);
        restaurant.setRestaurantCode(UUID.randomUUID().toString().split("-")[0]);
        restaurant.setAddress(shopRequest.getAddress());
        restaurant.setDescription(shopRequest.getDescription());
        return restaurant;
    }

    public List<RestaurantResponseDto> findAll() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        List<RestaurantResponseDto> restaurantResponseDtoList = new ArrayList<>();
        for (Restaurant restaurant : restaurants) {
            restaurantResponseDtoList.add(modelMapper.map(restaurant, RestaurantResponseDto.class));
        }
        return restaurantResponseDtoList;
    }

    public Restaurant findByRestaurantCode(String restaurantCode) {
        return restaurantRepository.findByRestaurantCode(restaurantCode);
    }

    public RestaurantAndMenuItemsDto findAllGetRestaurantMenuItemsByRestaurantId(String restaurantCode) {
        Restaurant restaurant = restaurantRepository.findByRestaurantCode(restaurantCode);
        List<MenuItemsOfRestaurantDto> restaurantMenuItemsByRestaurantId = restaurantRepository.findAllGetRestaurantMenuItemsByRestaurantId(restaurant.getId());
        RestaurantAndMenuItemsDto restaurantAndMenuItemsDto = new RestaurantAndMenuItemsDto();
        restaurantAndMenuItemsDto.setRestaurant(modelMapper.map(restaurant,RestaurantResponseDto.class));
        Map<String, List<MenuItemsOfRestaurantDto>> goupItemsByCategory = restaurantMenuItemsByRestaurantId.stream().collect(Collectors.groupingBy(MenuItemsOfRestaurantDto::getCategoryName));
        restaurantAndMenuItemsDto.setFoods(goupItemsByCategory);
        return restaurantAndMenuItemsDto;
    }

    public RestaurantResponseDto findByUsername(String username) {
        User user = userService.findByUsername(username);
        return modelMapper.map(restaurantRepository.findByUserId(user.getId()),RestaurantResponseDto.class);
    }
}

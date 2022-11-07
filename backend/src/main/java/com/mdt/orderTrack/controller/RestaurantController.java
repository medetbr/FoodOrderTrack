package com.mdt.orderTrack.controller;

import com.mdt.orderTrack.dto.restaurant.RestaurantRequestDto;
import com.mdt.orderTrack.dto.restaurant.RestaurantResponseDto;
import com.mdt.orderTrack.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/restaurants/")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class RestaurantController {
    private final RestaurantService restaurantService;
    private final ModelMapper modelMapper;

    @PostMapping()
    public void createRestaurant(@RequestBody RestaurantRequestDto restaurantRequestDto){
         restaurantService.insert(restaurantRequestDto);
    }

    @GetMapping()
    public List<RestaurantResponseDto> getAllRestaurantList(){
        return restaurantService.findAll();
    }
    @GetMapping("/{username}")
    public RestaurantResponseDto getOneRestaurantByUsername(@PathVariable String username){
        return restaurantService.findByUsername(username);
    }
}

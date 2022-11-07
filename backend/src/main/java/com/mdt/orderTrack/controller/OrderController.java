package com.mdt.orderTrack.controller;

import com.mdt.orderTrack.dto.order.OrderResponseDto;
import com.mdt.orderTrack.dto.order.RequestOrderDto;
import com.mdt.orderTrack.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/")
    public void createOrder(@RequestBody RequestOrderDto order){
        orderService.insert(order);
    }
    @GetMapping()
    public List<OrderResponseDto> getOrderByUserId(@RequestParam String username){
        return orderService.findAllByUsername(username);
    }
    @GetMapping("/{restaurantCode}")
    public List<OrderResponseDto> getAllOrderByRestaurantCode(@PathVariable String restaurantCode){
        return orderService.findAllByRestaurantCode(restaurantCode);
    }
    @DeleteMapping("/{orderCode}")
    public void deleteOneOrderByOrderCode(@PathVariable String orderCode){
        orderService.findByOrderCodeAndDelete(orderCode);
    }
}

package com.mdt.orderTrack.service;
import com.mdt.orderTrack.dto.order.OrderResponseDto;
import com.mdt.orderTrack.dto.order.RequestOrderDto;
import com.mdt.orderTrack.dto.orderItem.OrderItemRequestDto;
import com.mdt.orderTrack.entity.*;
import com.mdt.orderTrack.exception.UserNotFound;
import com.mdt.orderTrack.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor

public class OrderService {
    private final OrderRepository orderRepository;
    private final UserService userService;
    private final RestaurantService restaurantService;
    private final ModelMapper modelMapper;
    private final OrderItemService orderItemService;
    private final MenuItemService menuItemService;


    public void insert(RequestOrderDto orderRequest) {
        Order order = this.creatNewOrder(orderRequest);
        orderRepository.save(order);
        orderItemService.insert(order,orderRequest.getMenuItems());
    }

    private Order creatNewOrder(RequestOrderDto orderRequest) {
        Order order = new Order();
        User user = userService.findByUsername(orderRequest.getUsername());
        Restaurant restaurant = restaurantService.findByRestaurantCode(orderRequest.getRestaurantCode());
        order.setOrderCode(UUID.randomUUID().toString().split("-")[0]);

        for (OrderItemRequestDto oneMenuItem : orderRequest.getMenuItems()) {
            MenuItem menuItem = menuItemService.findByMenuItemCode(oneMenuItem.getMenuItemCode());
            Double total = order.getTotal()==null?0: order.getTotal();
            order.setTotal(total+menuItem.getPrice()*oneMenuItem.getQuantity());
        }
        order.setAddress(orderRequest.getAddress());
        order.setDescription(orderRequest.getDescription());
        order.setUser(user);
        order.setRestaurant(restaurant);

        return order;
    }

    public List<OrderResponseDto> findAllByUsername(String username) {
        try {
            User user = userService.findByUsername(username);
            if (user==null) throw new UserNotFound("Böyle bir kullanıcı bulunamadı");
            List<Order> orders = orderRepository.findAllByUserAndIsDeleted(user,null);
            List<OrderResponseDto> ordersDtoList = new ArrayList<>();
            for (int i=0;i<orders.size() ;i++) {
                ordersDtoList.add(modelMapper.map(orders.get(i),OrderResponseDto.class));
                ordersDtoList.get(i).setFoodItems(orderItemService.findAllByOrderId(orders.get(i)));
            }
            return ordersDtoList;
        }catch (Exception e){
           throw new RuntimeException(e);
        }
    }
    public List<OrderResponseDto> findAllByRestaurantCode(String restaurantCode) {
        try {
            Restaurant restaurant = restaurantService.findByRestaurantCode(restaurantCode);
            List<Order> orders = orderRepository.findAllByRestaurantAndIsDeleted(restaurant,null);
            List<OrderResponseDto> ordersDtoList = new ArrayList<>();
            for (int i=0;i<orders.size() ;i++) {
                ordersDtoList.add(modelMapper.map(orders.get(i),OrderResponseDto.class));
                ordersDtoList.get(i).setFoodItems(orderItemService.findAllByOrderId(orders.get(i)));
            }
            return ordersDtoList;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    public void findByOrderCodeAndDelete(String orderCode){
        Order order = orderRepository.findByOrderCode(orderCode);
        order.setIsDeleted(true);
        orderRepository.save(order);
    }
}

package com.mdt.orderTrack.service;

import com.mdt.orderTrack.dto.orderItem.OrderItemRequestDto;
import com.mdt.orderTrack.dto.orderItem.OrderItemResponseDto;
import com.mdt.orderTrack.entity.Order;
import com.mdt.orderTrack.entity.OrderItem;
import com.mdt.orderTrack.repository.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderItemService {
    private final OrderItemRepository orderItemRepository;
    private final ModelMapper modelMapper;
    private final MenuItemService menuItemService;
    public void insert(Order order, List<OrderItemRequestDto> menuItemsList){
        for (OrderItemRequestDto menuItem : menuItemsList) {
            OrderItem orderItem = createNewOrderItem(order, menuItem);
            orderItemRepository.save(orderItem);
        }
    }

    private OrderItem createNewOrderItem(Order order, OrderItemRequestDto menuItem) {
        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(order);
        orderItem.setQuantity(menuItem.getQuantity());
        orderItem.setMenuItem(menuItemService.findByMenuItemCode(menuItem.getMenuItemCode()));
        return orderItem;
    }

    public List<OrderItemResponseDto> findAllByOrderId(Order order){
        List<OrderItem> allOrderItemByOrderId = orderItemRepository.findAllByOrderId(order.getId());
        return allOrderItemByOrderId.stream().map(orderItem -> modelMapper.map(orderItem,OrderItemResponseDto.class)).collect(Collectors.toList());
    }
}

package com.mdt.orderTrack.dto.order;

import com.mdt.orderTrack.dto.orderItem.OrderItemRequestDto;
import lombok.Data;

import java.util.List;


@Data
public class RequestOrderDto {
    private String username;
    private String restaurantCode;
    private String address;
    private String description;
    private List<OrderItemRequestDto> menuItems;
}

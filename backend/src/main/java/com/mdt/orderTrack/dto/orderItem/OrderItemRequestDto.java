package com.mdt.orderTrack.dto.orderItem;

import lombok.Data;

@Data
public class OrderItemRequestDto {
    private Integer quantity;
    private String menuItemCode;
}

package com.mdt.orderTrack.dto.orderItem;

import com.mdt.orderTrack.dto.menuItem.MenuItemResponseDto;
import lombok.Data;

@Data
public class OrderItemResponseDto {
    private MenuItemResponseDto menuItem;
    private Integer quantity;
}

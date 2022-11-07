package com.mdt.orderTrack.repository;

import com.mdt.orderTrack.dto.restaurant.RestaurantResponseDto;
import com.mdt.orderTrack.entity.MenuItem;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem,Long> {
    MenuItem findByMenuItemCode(String menuItemCode);
}
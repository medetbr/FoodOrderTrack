package com.mdt.orderTrack.repository;

import com.mdt.orderTrack.dto.restaurant.MenuItemsOfRestaurantDto;
import com.mdt.orderTrack.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {
    Restaurant findByRestaurantCode(String restaurantCode);

    @Query("select new com.mdt.orderTrack.dto.restaurant.GetRestaurantMenuItemsDto(f.name,m.price,c.name,m.menuItemCode) from MenuItem m, Category c, FoodItem f " +
            "where m.restaurant.id=:id and f.id = m.foodItem.id and c.id=f.category.id "
            )
    List<MenuItemsOfRestaurantDto> findAllGetRestaurantMenuItemsByRestaurantId(@Param("id") Long id);

    Restaurant findByUserId(Long id);
}
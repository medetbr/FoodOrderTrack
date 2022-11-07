package com.mdt.orderTrack.repository;

import com.mdt.orderTrack.entity.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem,Long> {
    FoodItem findByFoodItemCode(String foodItemCode);
}

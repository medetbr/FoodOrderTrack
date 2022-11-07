package com.mdt.orderTrack.repository;


import com.mdt.orderTrack.entity.Order;
import com.mdt.orderTrack.entity.Restaurant;
import com.mdt.orderTrack.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    List<Order> findAllByUserAndIsDeleted(User user, Object isDeleted);
    List<Order> findAllByRestaurantAndIsDeleted(Restaurant restaurant, Object isDeleted);

    Order findByOrderCode(String orderCode);
}

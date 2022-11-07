package com.mdt.orderTrack.entity;

import lombok.Data;


import javax.persistence.*;

@Entity
@Data
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Restaurant restaurant;
    @ManyToOne
    private FoodItem foodItem;
    @Column(nullable = false)
    private String menuItemCode;
    @Column(nullable = false)
    private Double price;
}

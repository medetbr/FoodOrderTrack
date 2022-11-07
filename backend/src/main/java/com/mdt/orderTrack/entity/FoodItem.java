package com.mdt.orderTrack.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class FoodItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String foodItemCode;
    @ManyToOne()
    private Category category;
    private Boolean isDeleted;
}

package com.mdt.orderTrack.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "restaurants")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String restaurantCode;
    private Integer rating;
    private Boolean isDeleted;
    @OneToMany(mappedBy = "restaurant")
    private List<MenuItem> menuItem;
}

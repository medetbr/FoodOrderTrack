package com.mdt.orderTrack.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String orderCode;
    private Double total;
    private Boolean isDeleted;


}

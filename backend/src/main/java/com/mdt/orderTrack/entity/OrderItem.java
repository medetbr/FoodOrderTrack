package com.mdt.orderTrack.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Order order;
    @OneToOne
    private MenuItem menuItem;
    private Integer quantity;
    private Boolean isDeleted;
}

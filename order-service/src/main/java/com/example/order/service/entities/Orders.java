package com.example.order.service.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ORDER")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "restaurant_id")
    private Integer restaurantId;

    @Column(name = "total_price")
    private Integer totalPrice;
}
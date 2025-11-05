package com.example.restaurant.service.entity;

import com.example.restaurant.service.entity.RestaurantEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "dish")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DishEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Integer price;

    @Column(name = "image_url", length = 255)
    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_dish_restaurant"))
    private RestaurantEntity restaurant;
}

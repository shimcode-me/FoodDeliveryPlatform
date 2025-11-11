package com.example.restaurant.service.dto;

import lombok.Data;

@Data
public class DishesDto {
    private Long id;
    private String name;
    private String description;
    private Integer price;
    private String imageUrl;
    private Long restaurantId;
}

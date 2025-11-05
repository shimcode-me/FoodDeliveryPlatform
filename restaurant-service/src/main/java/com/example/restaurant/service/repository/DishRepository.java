package com.example.restaurant.service.entity;

import com.example.restaurant.service.entity.DishEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishRepository extends JpaRepository<com.example.restaurant.service.entity.DishEntity, Long> {

}

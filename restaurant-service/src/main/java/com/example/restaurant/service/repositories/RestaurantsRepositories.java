package com.example.restaurant.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantsRepositories extends JpaRepository<com.example.restaurant.service.entities.Restaurants, Long> {
}

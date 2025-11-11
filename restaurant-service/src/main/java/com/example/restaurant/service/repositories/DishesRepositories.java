package com.example.restaurant.service.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishesRepositories extends JpaRepository<Dishes, Long> {

}

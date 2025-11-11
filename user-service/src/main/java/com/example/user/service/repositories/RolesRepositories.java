package com.example.user.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepositories extends JpaRepository<com.example.user.service.entities.Roles, Long> {
}

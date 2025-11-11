package com.example.user.service.repositories;

import com.example.user.service.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepositories extends JpaRepository<com.example.user.service.entities.Users, Long> {
    Optional<Users> findByEmail(String email);
    boolean existsByEmail(String email);
}

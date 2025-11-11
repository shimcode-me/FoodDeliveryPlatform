package com.example.user.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressesRepositories extends JpaRepository<com.example.user.service.entities.Addresses, Long> {
}

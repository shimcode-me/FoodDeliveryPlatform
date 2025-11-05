package com.example.restaurant.service.entity;

import com.example.user.service.entity.UserEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255)
    private String street;

    @Column(length = 255)
    private String city;

    @Column(length = 255)
    private String zip;

    @Column(length = 255)
    private String state;

    @Column(length = 255)
    private String country;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;
}

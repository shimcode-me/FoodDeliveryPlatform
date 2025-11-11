package com.example.restaurant.service.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "restaurant")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Restaurants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "cuisine")
    private String cuisine;

    @Column(name = "address")
    private String address;

   @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Dishes> dishes = new ArrayList<>();
}
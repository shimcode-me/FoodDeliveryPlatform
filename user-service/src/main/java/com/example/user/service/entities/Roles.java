package com.example.user.service.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Entity
@Table(name = "role")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, unique = true, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<Users> users;
}

package com.example.demo.persistance.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user",
uniqueConstraints =  @UniqueConstraint(columnNames = "email"))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "first_name")
    @Size(max = 60)
    private String firstName;

    @Column(name = "last_name")
    @Size(max = 60)
    private String lastName;

    @Column(name = "email")
    private String email;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    private Set<Car> car = new HashSet<>();
}

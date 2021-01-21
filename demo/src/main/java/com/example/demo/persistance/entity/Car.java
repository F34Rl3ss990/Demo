package com.example.demo.persistance.entity;

import com.fasterxml.jackson.annotation.*;
import com.mysql.cj.protocol.x.Notice;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private int carId;

    @Column(name = "brand")
    @Pattern(regexp = "^[a-zA-Z]+$")
    @Size(max = 60)
    private String brand;

    @Column(name = "type")
    private String type;

    @Max(999999)
    @Column(name = "mileage")
    private int mileage;

    @Column(name = "year_of_manufacture")
    private int yearOfManufacture;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_car_user")
    @JsonIgnore
    private User user;
}

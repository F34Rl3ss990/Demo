package com.example.demo.persistance.entity;

import com.example.demo.validation.annotation.MaxYear;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.YearMonth;
import java.util.Date;

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
    @Pattern(regexp = "[A-Za-z]")
    @Size(max = 60)
    private String brand;

    @Column(name = "type")
    private String type;

    @Max(999999)
    @Column(name = "mileage")
    private int mileage;

    @Column(name = "year_of_manufacture")
    @MaxYear
    private int yearOfManufacture;

    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_car_user")
    private User user;
}

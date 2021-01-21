package com.example.demo.persistance.repository;

import com.example.demo.persistance.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
}

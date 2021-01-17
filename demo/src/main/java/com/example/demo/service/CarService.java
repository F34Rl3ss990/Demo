package com.example.demo.service;

import com.example.demo.persistance.entity.Car;
import com.example.demo.web.dto.CarDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface CarService {
    Page<Car> getCarPage(int page, int size);

    Page<Car> getCarPageById(int page, int size, int id);

    void saveCar(CarDTO carDTO);

    void modifyCar(CarDTO carDTO, Optional<Car> car);

    Optional<Car> getById(int id);

    void deleteById(int id);
}

package com.example.demo.web.controller;

import com.example.demo.persistance.entity.Car;
import com.example.demo.service.CarService;
import com.example.demo.web.dto.CarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin
public class CarController {

    private CarService carService;

    @Autowired
    public void setCarService(CarService carService){
        this.carService = carService;
    }

    @PostMapping("saveCar")
    public ResponseEntity<String> addCar(@Valid @RequestBody CarDTO carDTO) {

        carService.saveCar(carDTO);
        return new ResponseEntity<>("Successfully added!", HttpStatus.OK);
    }

    @GetMapping("getCars")
    public Page<Car> carPage(@RequestParam(name = "page", defaultValue = "0") int page,
                          @RequestParam(name = "size", defaultValue = "10") int size) {
        return carService.getCarPage(page, size);
    }

    @GetMapping("getCarByUserId")
    public Page<Car> carPageById(@RequestParam(name = "page", defaultValue = "0") int page,
                                  @RequestParam(name = "size", defaultValue = "10") int size,
                                  @RequestParam(name = "id") int id) {
        return carService.getCarPageById(page, size, id);
    }

    @DeleteMapping("deleteCar/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable int id) {

        Optional<Car> car = carService.getById(id);
        if (!car.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        carService.deleteById(id);
        return new ResponseEntity<>("Successfully deleted!", HttpStatus.OK);
    }

    @PutMapping("modifyCar/{id}")
    public ResponseEntity<String> modifyCar(@PathVariable(name = "id") int id,
                                                 @Valid @RequestBody CarDTO carDTO) {
        Optional<Car> car = carService.getById(id);
        if (!car.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        carService.modifyCar(carDTO, car);
        return new ResponseEntity<>("Successfully updated", HttpStatus.OK);
    }
}

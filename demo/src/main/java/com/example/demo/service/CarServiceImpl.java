package com.example.demo.service;

import com.example.demo.persistance.entity.Car;
import com.example.demo.persistance.entity.User;
import com.example.demo.persistance.repository.CarRepository;
import com.example.demo.web.dto.CarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

@Service
public class CarServiceImpl implements CarService{

    private CarRepository carRepository;

    private UserService userService;

    @Autowired
    public void setCarRepository(CarRepository carRepository){
        this.carRepository = carRepository;
    }

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @Override
    public Page<Car> getCarPage(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Car> pageResult = carRepository.findAll(pageRequest);
        List<Car> articles = pageResult
                .stream()
                .collect(toList());
        return new PageImpl<>(articles, pageRequest, pageResult.getTotalElements());
    }

    @Override
    public Page<Car> getCarPageById(int page, int size, int id) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Car> pageResult = carRepository.findAll(pageRequest);
        Predicate<Car> contain = (Car item) -> item.getUser().getUserId() == id;
        List<Car> articles = pageResult
                .stream()
                .filter(contain)
                .collect(toList());
        return new PageImpl<>(articles, pageRequest, pageResult.getTotalElements());
    }

    @Override
    public void saveCar(CarDTO carDTO) {
         carRepository.save(convertCarDTOtoCar(carDTO));
    }

    @Override
    public void modifyCar(CarDTO carDTO, Optional<Car> car) {
            car.get().setMileage(carDTO.getMileage());
            car.get().setType(carDTO.getType());
            car.get().setBrand(carDTO.getBrand());
            car.get().setYearOfManufacture(carDTO.getYearOfManufacture());
            carRepository.save(car.get());
        }

    @Override
    public Optional<Car> getById(int id) {
        return carRepository.findById(id);
    }

    @Override
    public void deleteById(int id) {
        carRepository.deleteById(id);
    }

    private Car convertCarDTOtoCar(CarDTO carDTO) {
        Car car = new Car();
        car.setBrand(carDTO.getBrand());
        car.setMileage(carDTO.getMileage());
        car.setType(carDTO.getType());
        car.setYearOfManufacture(carDTO.getYearOfManufacture());
        Optional<User> user = userService.getById(carDTO.getUserId());
        user.ifPresent(car::setUser);
        return car;
    }

}

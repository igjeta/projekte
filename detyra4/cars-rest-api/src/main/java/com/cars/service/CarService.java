package com.cars.service;

import com.cars.entity.Car;

import java.util.List;

public interface CarService {
    List<Car> getAllCars();
    Car getCarById(Integer id);
    Boolean createCar(Car car);
    Boolean updateCar(Integer id,Car car);
    Boolean deleteCar(Integer id);
}

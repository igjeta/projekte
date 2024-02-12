package com.cars.repository;

import com.cars.entity.Car;

import java.util.List;

public interface CarDAO {
    List<Car> getAllCars();
    Car getCarById(Integer id);
    Boolean createCar(Car car);
    Boolean updateCar(Integer id,Car car);
    Boolean deleteCar(Integer id);
}

package com.cars.service.impl;

import com.cars.client.CarClient;
import com.cars.dto.Car;
import com.cars.service.CarService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private final CarClient carClient;

    CarServiceImpl(CarClient carClient) {
        this.carClient = carClient;
    }

    @Override
    public List<Car> getAllCars() {
        return carClient.getAllCars().getBody();
    }

    @Override
    public Car getCarById(Integer id) {
        return carClient.getCarById(id).getBody();
    }

    @Override
    public Boolean createCar(Car car) {
        return carClient.addCar(car).getBody();
    }

    @Override
    public Boolean updateCar(Integer id, Car car) {
        return carClient.updateCar(id, car).getBody();
    }

    @Override
    public Boolean deleteCar(Integer id) {
        return carClient.deleteCar(id).getBody();
    }
}

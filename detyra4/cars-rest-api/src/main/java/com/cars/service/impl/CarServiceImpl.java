package com.cars.service.impl;

import com.cars.entity.Car;
import com.cars.repository.CarDAO;
import com.cars.service.CarService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private final CarDAO carDAO;

    CarServiceImpl(CarDAO carDAO){
        this.carDAO=carDAO;
    }
    @Override
    public List<Car> getAllCars() {
        return carDAO.getAllCars();
    }

    @Override
    public Car getCarById(Integer id) {
        return carDAO.getCarById(id);
    }

    @Override
    public Boolean createCar(Car car) {
        return carDAO.createCar(car);
    }

    @Override
    public Boolean updateCar(Integer id, Car car) {
        return carDAO.updateCar(id, car);
    }

    @Override
    public Boolean deleteCar(Integer id) {
        return carDAO.deleteCar(id);
    }
}

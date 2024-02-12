package com.cars.controller;

import com.cars.entity.Car;
import com.cars.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

    CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public ResponseEntity<List<Car>> getAllCars() {
        return ResponseEntity.ok(carService.getAllCars());
    }

    @GetMapping("/{carId}")
    public ResponseEntity<Car> getCarById(@PathVariable(name = "carId") Integer id) {
        return ResponseEntity.ok(carService.getCarById(id));
    }

    @PostMapping
    public ResponseEntity<Boolean> addCar(@RequestBody Car car) {
        return ResponseEntity.ok(carService.createCar(car));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateCar(@PathVariable Integer id,@RequestBody Car car) {
        return ResponseEntity.ok(carService.updateCar(id, car));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCar(@PathVariable(name="id") Integer carId){
        return ResponseEntity.ok(carService.deleteCar(carId));
    }
}

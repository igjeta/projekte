package com.cars.client;

import com.cars.dto.Car;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;

import java.util.List;

public interface CarClient {
    @GetExchange
    ResponseEntity<List<Car>> getAllCars();

    @GetExchange("/{carId}")
    ResponseEntity<Car> getCarById(@PathVariable(name = "carId") Integer id);

    @PostExchange
    ResponseEntity<Boolean> addCar(@RequestBody Car car);

    @PutExchange("/{id}")
    ResponseEntity<Boolean> updateCar(@PathVariable Integer id, @RequestBody Car car);

    @DeleteExchange("/{id}")
    ResponseEntity<Boolean> deleteCar(@PathVariable(name = "id") Integer carId);
}

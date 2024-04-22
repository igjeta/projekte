package com.cars.service;

import com.cars.entity.Wheels;

import java.util.List;

public interface WheelsService {
    List<Wheels> getAllWheels();
    Wheels getWheelsById(Integer id);
    Boolean createWheels(Wheels wheels);
    Boolean updateWheels(Integer id,Wheels wheels);
    Boolean deleteWheels(Integer id);
}

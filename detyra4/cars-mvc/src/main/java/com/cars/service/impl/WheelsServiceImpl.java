package com.cars.service.impl;

import com.cars.client.WheelsClient;
import com.cars.dto.Wheels;
import com.cars.service.WheelsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WheelsServiceImpl implements WheelsService {

    private final WheelsClient wheelsClient;

    WheelsServiceImpl(WheelsClient wheelsClient){
        this.wheelsClient=wheelsClient;
    }
    @Override
    public List<Wheels> getAllWheels() {
        return wheelsClient.getAllWheels().getBody();
    }

    @Override
    public Wheels getWheelsById(Integer id) {
        return wheelsClient.getWheelsById(id).getBody();
    }

    @Override
    public Boolean createWheels(Wheels wheels) {
        return wheelsClient.addWheels(wheels).getBody();
    }

    @Override
    public Boolean updateWheels(Integer id, Wheels wheels) {
        return wheelsClient.updateWheels(id, wheels).getBody();
    }

    @Override
    public Boolean deleteWheels(Integer id) {
        return wheelsClient.deleteWheels(id).getBody();
    }
}

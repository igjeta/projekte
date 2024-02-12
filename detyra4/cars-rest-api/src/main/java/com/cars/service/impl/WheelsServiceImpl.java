package com.cars.service.impl;

import com.cars.entity.Wheels;
import com.cars.repository.WheelsDAO;
import com.cars.service.WheelsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WheelsServiceImpl implements WheelsService {
    public final WheelsDAO wheelsDAO;
    WheelsServiceImpl(WheelsDAO wheelsDAO){
        this.wheelsDAO=wheelsDAO;
    }
    @Override
    public List<Wheels> getAllWheels() {
        return wheelsDAO.getAllWheels();
    }

    @Override
    public Wheels getWheelsById(Integer id) {
        return wheelsDAO.getWheelsById(id);
    }

    @Override
    public Boolean createWheels(Wheels wheels) {
        return wheelsDAO.createWheels(wheels);
    }

    @Override
    public Boolean updateWheels(Integer id, Wheels wheels) {
        return wheelsDAO.updateWheels(id, wheels);
    }

    @Override
    public Boolean deleteWheels(Integer id) {
        return wheelsDAO.deleteWheels(id);
    }
}

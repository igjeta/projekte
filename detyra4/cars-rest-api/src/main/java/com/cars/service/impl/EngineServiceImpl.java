package com.cars.service.impl;

import com.cars.entity.Engine;
import com.cars.repository.EngineDAO;
import com.cars.service.EngineService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EngineServiceImpl implements EngineService {
    private final EngineDAO engineDAO;
    EngineServiceImpl(EngineDAO engineDAO){
        this.engineDAO=engineDAO;
    }
    @Override
    public List<Engine> getAllEngines() {
        return engineDAO.getAllEngines();
    }

    @Override
    public Engine getEngineById(Integer id) {
        return engineDAO.getEngineById(id);
    }

    @Override
    public Boolean createEngine(Engine engine) {
        return engineDAO.createEngine(engine);
    }

    @Override
    public Boolean updateEngine(Integer id, Engine engine) {
        return engineDAO.updateEngine(id, engine);
    }

    @Override
    public Boolean deleteEngine(Integer id) {
        return engineDAO.deleteEngine(id);
    }
}

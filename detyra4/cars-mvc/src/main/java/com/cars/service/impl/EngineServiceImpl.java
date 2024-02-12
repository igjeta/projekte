package com.cars.service.impl;

import com.cars.client.EngineClient;
import com.cars.dto.Engine;
import com.cars.service.EngineService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EngineServiceImpl implements EngineService {

    private final EngineClient engineClient;

    EngineServiceImpl(EngineClient engineClient) {
        this.engineClient = engineClient;
    }

    @Override
    public List<Engine> getAllEngines() {
        return engineClient.getAllEngines().getBody();
    }

    @Override
    public Engine getEngineById(Integer id) {
        return engineClient.getEngineById(id).getBody();
    }

    @Override
    public Boolean createEngine(Engine engine) {
        return engineClient.addEngine(engine).getBody();
    }

    @Override
    public Boolean updateEngine(Integer id, Engine engine) {
        return engineClient.updateEngine(id, engine).getBody();
    }

    @Override
    public Boolean deleteEngine(Integer id) {
        return engineClient.deleteEngine(id).getBody();
    }
}

package com.cars.service;

import com.cars.entity.Engine;

import java.util.List;

public interface EngineService {
    List<Engine> getAllEngines();
    Engine getEngineById(Integer id);
    Boolean createEngine(Engine engine);
    Boolean updateEngine(Integer id,Engine engine);
    Boolean deleteEngine(Integer id);
}

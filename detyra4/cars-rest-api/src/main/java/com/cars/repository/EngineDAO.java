package com.cars.repository;

import com.cars.entity.Engine;

import java.util.List;

public interface EngineDAO {
    List<Engine> getAllEngines();
    Engine getEngineById(Integer id);
    Boolean createEngine(Engine engine);
    Boolean updateEngine(Integer id,Engine engine);
    Boolean deleteEngine(Integer id);
}

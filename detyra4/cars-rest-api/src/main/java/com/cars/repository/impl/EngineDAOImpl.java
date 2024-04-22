package com.cars.repository.impl;

import com.cars.entity.Engine;
import com.cars.mapper.EngineMapper;
import com.cars.repository.EngineDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EngineDAOImpl implements EngineDAO {
    private final JdbcTemplate jdbcTemplate;

    EngineDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String GET_ALL_ENGINES_Q = "SELECT * FROM car_engines";
    private static final String GET_ENGINE_BY_ID_Q = "SELECT * FROM car_engines WHERE car_engines.id=?";
    private static final String CREATE_ENGINE_Q = "INSERT INTO car_engines (engine_power, engine_type) VALUES (?, ?)";
    private static final String UPDATE_ENGINE_Q = "UPDATE car_engines SET engine_power = ?,engine_type=? WHERE car_engines.id = ?";

    private static final String DELETE_ENGINE_Q = "DELETE FROM car_engines WHERE car_engines.id = ?";
    private static final String DELETE_CAR_Q = "DELETE FROM cars WHERE engine_id = ?";

    @Override
    public List<Engine> getAllEngines() {
        return jdbcTemplate.query(GET_ALL_ENGINES_Q, new EngineMapper());
    }

    @Override
    public Engine getEngineById(Integer id) {
        return jdbcTemplate.queryForObject(GET_ENGINE_BY_ID_Q, new EngineMapper(), id);
    }

    @Override
    public Boolean createEngine(Engine engine) {
        var createEngine = jdbcTemplate.update(CREATE_ENGINE_Q, engine.getPower(), engine.getType());
        return createEngine != -1;
    }

    @Override
    public Boolean updateEngine(Integer id, Engine engine) {
        var updateEngine = jdbcTemplate.update(UPDATE_ENGINE_Q, engine.getPower(), engine.getType(), id);
        return updateEngine != -1;
    }

    @Override
    public Boolean deleteEngine(Integer id) {
        var deleteCar = jdbcTemplate.update(DELETE_CAR_Q, id);
        if (deleteCar != -1) {
            var deleteEngine = jdbcTemplate.update(DELETE_ENGINE_Q, id);
            return deleteEngine != -1;
        }
        return false;
    }
}
